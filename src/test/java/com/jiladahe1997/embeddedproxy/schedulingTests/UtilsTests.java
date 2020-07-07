package com.jiladahe1997.embeddedproxy.schedulingTests;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UtilsTests {
    public static void downloadFileFromUrlTest(String url, String fileName) throws IOException {
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

            /* Note: only download 5MB for test */
            if(readCount > 512000) break;
        }
        System.out.println(fileName+"下载完毕");
        stream.close();
        fileOutputStream.close();
        httpClient.close();
    }
}
