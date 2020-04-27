package com.jiladahe1997.embeddedproxy.scheduling;

import com.alibaba.edas.acm.exception.ConfigException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.models.index.ConfigList;
import com.jiladahe1997.embeddedproxy.models.scheduling.KeilSyncConfig;
import com.jiladahe1997.embeddedproxy.services.AcmService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

@Component
public class JobKeil {
    @Autowired
    AcmService acmService;

    @XxlJob(value = "Keil Main")
    public ReturnT<String> KeilMain(String param) throws IOException, InterruptedException {
        KeilSyncConfig keilSyncConfigs[] = new ObjectMapper().readerFor(KeilSyncConfig[].class).readValue(acmService.getKeilSyncData());
        List<KeilSyncConfig> configList = Arrays.asList(keilSyncConfigs);
        configList.forEach(c->{
            try {
                Utils.downloadFileFromUrl(c.url,c.fileName);
                Utils.uploadFile(c.fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return ReturnT.SUCCESS;
    }
}
