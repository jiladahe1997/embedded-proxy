package com.jiladahe1997.embeddedproxy.schedulingTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.EmbeddedproxyApplication;
import com.jiladahe1997.embeddedproxy.models.scheduling.SyncConfig;
import com.jiladahe1997.embeddedproxy.scheduling.Utils;
import com.jiladahe1997.embeddedproxy.services.AcmService;
import com.xxl.job.core.biz.model.ReturnT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmbeddedproxyApplication.class)
public class JobARMTests {
    @Autowired
    AcmService acmService;

    @Test
    public void testConfigAndDownload() throws JsonProcessingException {
        SyncConfig armSyncConfigs[] = new ObjectMapper().readerFor(SyncConfig[].class).readValue(acmService.getARMSyncData());
        List<SyncConfig> configList = Arrays.asList(armSyncConfigs);

        configList.forEach(c->{
            try {
                UtilsTests.downloadFileFromUrlTest(c.url,c.fileName);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }
}
