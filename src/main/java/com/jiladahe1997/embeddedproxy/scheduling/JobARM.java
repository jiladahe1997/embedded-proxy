
package com.jiladahe1997.embeddedproxy.scheduling;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.models.scheduling.SyncConfig;
import com.jiladahe1997.embeddedproxy.services.AcmService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Component
public class JobARM {
    @Autowired
    AcmService acmService;

    @XxlJob(value = "ARM")
    public ReturnT<String> ARM(String param) throws IOException, InterruptedException {
        SyncConfig armSyncConfigs[] = new ObjectMapper().readerFor(SyncConfig[].class).readValue(acmService.getARMSyncData());
        List<SyncConfig> configList = Arrays.asList(armSyncConfigs);
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