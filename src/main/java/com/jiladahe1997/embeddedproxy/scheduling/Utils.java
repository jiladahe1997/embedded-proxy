package com.jiladahe1997.embeddedproxy.scheduling;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.xxl.job.core.biz.model.ReturnT;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Utils {

    public static void downloadFileFromUrl(String url, String fileName) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpHost proxy = new HttpHost(System.getenv("proxyAddress"), Integer.parseInt(System.getenv("proxyPort")),"http");
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

        HttpEntity entity = closeableHttpResponse.getEntity();
        InputStream stream = entity.getContent();
        System.out.println("文件大小："+entity.getContentLength());
        FileOutputStream fileOutputStream = new FileOutputStream("./"+fileName);
        int readByte;
        byte[] readBuffer = new byte[1024000];
        float readCount = 0;
        while((readByte = stream.read(readBuffer)) !=- 1) {
            readCount+=readByte;
            System.out.printf("downloading %s: %.2f%%\r",fileName, readCount/entity.getContentLength()*100);
            fileOutputStream.write(readBuffer,0,readByte);
        }
        System.out.println(fileName+"下载完毕");
        stream.close();
        fileOutputStream.close();
        httpClient.close();
    }

    public static void uploadFile(String fileName) throws IOException {
        String secretId = "AKIDFEwNsMmTR5h26AegDTRKHwKghma8qO8b";
        String secretKey = "5TqvjHoJYWIoVwYv2sSloeCSQVUCdmYf";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 初始化分块上传
        InitiateMultipartUploadResult initiateMultipartUploadResult =  cosClient.initiateMultipartUpload(new InitiateMultipartUploadRequest("embeddedproxy-2-1252616609", "mirrorFile/"+fileName));
        String uploadId = initiateMultipartUploadResult.getUploadId();

        // 开始多线程上传
        List<Bucket> buckets = cosClient.listBuckets();
        for (Bucket bucketElement : buckets) {
            String bucketName = bucketElement.getName();
            String bucketLocation = bucketElement.getLocation();
            System.out.println("查询储存桶"+bucketLocation+bucketName);
        }
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        FileInputStream fileInputStream = new FileInputStream("./"+fileName);

        ArrayList<PartETag> partETags = new ArrayList<PartETag>();
        int readByte;
        byte[] readBuffer = new byte[10240000];
        int partNumber=0;
        CountDownLatch countDownLatch;
        while((readByte = fileInputStream.read(readBuffer)) !=- 1) {
            partNumber++;
            byte[] onceReadyBytes = readBuffer.clone();
            int finalPartNumber = partNumber;
            int finalReadByte = readByte;
            ByteArrayInputStream partStream = new ByteArrayInputStream(onceReadyBytes);
            UploadPartRequest uploadPartRequest = new UploadPartRequest().withBucketName("embeddedproxy-2-1252616609").withKey("mirrorFile/"+fileName).withUploadId(uploadId).withPartNumber(finalPartNumber)
                    .withInputStream(partStream).withPartSize(finalReadByte);
            UploadPartResult uploadPartResult = cosClient.uploadPart(uploadPartRequest);
            System.out.println("分块上传完成, etag:"+uploadPartResult.getETag());
            partETags.add(new PartETag(finalPartNumber, uploadPartResult.getETag()));
            partStream.close();
        }
        CompleteMultipartUploadResult result = cosClient.completeMultipartUpload(new CompleteMultipartUploadRequest("embeddedproxy-2-1252616609", "mirrorFile/"+fileName,uploadId,partETags));
        System.out.println("上传完成");
    }

    /* TODO:上传文件后，需要刷新一下CDN，目前观察到CDN好像10分钟左右会自动刷新，观察ing */
//    public static void refreshCDN(String filename) throws URISyntaxException {
//        URIBuilder uriBuilder = new URIBuilder("https://cdn.tencentcloudapi.com");
//        uriBuilder.setParameters(Arrays.asList(
//                new BasicNameValuePair("Action","PurgeUrlsCache"),
//                new BasicNameValuePair("Version", "2018-06-06"),
//                new BasicNameValuePair("Urls.0","https://")
//        ))
//        HttpEntity httpEntity = Request.Get("https://embeddedproxy-1252616609.cos.ap-chengdu.myqcloud.com/static/index.html").execute().returnResponse().getEntity();
//    }
}
