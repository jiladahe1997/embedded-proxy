package com.jiladahe1997.embeddedproxy.scheduling;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;

public class JobKeil {

    @XxlJob("Keil Main")
    public ReturnT<String> KeilMain(String param) throws IOException, InterruptedException {
        int singleFileLength = 10240; // 10MB分块
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpHost proxy = new HttpHost("127.0.0.1",1082,"http");
        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();
        HttpGet httpGet = new HttpGet("https://armkeil.blob.core.windows.net/eval/MDK529.EXE");
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);

       try {
           HttpEntity entity = closeableHttpResponse.getEntity();
           InputStream stream = entity.getContent();
           System.out.println("文件大小："+entity.getContentLength());

           FileOutputStream fileOutputStream = new FileOutputStream("./MDK529.EXE");
           int readByte;
           byte[] readBuffer = new byte[10240];
           int readCount = 0;
           while((readByte = stream.read(readBuffer)) !=- 1) {
               readCount++;
               System.out.println("downloading,count:"+ readCount);
               fileOutputStream.write(readBuffer,0,readByte);
           }
           System.out.println("下载完毕");
       } finally {
           System.out.println("关闭输出");
           httpClient.close();
       }

        // 开始分块上传
        String secretId = "AKIDFEwNsMmTR5h26AegDTRKHwKghma8qO8b";
        String secretKey = "5TqvjHoJYWIoVwYv2sSloeCSQVUCdmYf";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
        COSClient cosClient = new COSClient(cred, clientConfig);

        // 初始化分块上传
        InitiateMultipartUploadResult initiateMultipartUploadResult =  cosClient.initiateMultipartUpload(new InitiateMultipartUploadRequest("embeddedproxy-1252616609", "mirrorFile/MDK529.EXE"));
        String uploadId = initiateMultipartUploadResult.getUploadId();

        // 开始多线程上传
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        FileInputStream fileInputStream = new FileInputStream("./MDK529.EXE");

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
            executorService.execute(()->{
                ByteArrayInputStream partStream = new ByteArrayInputStream(onceReadyBytes);
                UploadPartRequest uploadPartRequest = new UploadPartRequest().withBucketName("embeddedproxy-1252616609").withKey("mirrorFile/MDK529.EXE").withUploadId(uploadId).withPartNumber(finalPartNumber)
                        .withInputStream(partStream).withPartSize(finalReadByte);
                UploadPartResult uploadPartResult = cosClient.uploadPart(uploadPartRequest);
                System.out.println("上传完成, etag:"+uploadPartResult.getETag());
                partETags.add(new PartETag(finalPartNumber, uploadPartResult.getETag()));
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        CompleteMultipartUploadResult result = cosClient.completeMultipartUpload(new CompleteMultipartUploadRequest("embeddedproxy-1252616609", "mirrorFile/MDK529.EXE",uploadId,partETags));
        return ReturnT.SUCCESS;
    }
}
