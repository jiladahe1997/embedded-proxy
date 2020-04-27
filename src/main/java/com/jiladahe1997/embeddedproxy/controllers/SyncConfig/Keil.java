package com.jiladahe1997.embeddedproxy.controllers.SyncConfig;

import com.alibaba.edas.acm.exception.ConfigException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.SyncConfig.KeilVo;
import com.jiladahe1997.embeddedproxy.models.index.ConfigList;
import com.jiladahe1997.embeddedproxy.models.scheduling.KeilSyncConfig;
import com.jiladahe1997.embeddedproxy.scheduling.JobKeil;
import com.jiladahe1997.embeddedproxy.services.AcmService;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Keil {

    @Autowired
    AcmService acmService;


    @RequestMapping("/api/SyncConfig/keil")
    public CommonReturn config() throws IOException {
        KeilSyncConfig keilSyncConfigs[] = new ObjectMapper().readerFor(KeilSyncConfig[].class).readValue(acmService.getKeilSyncData());
        List<KeilSyncConfig> configList = Arrays.asList(keilSyncConfigs);
        List<KeilVo> ret = new ArrayList<KeilVo>();
        configList.forEach(c->{
            KeilVo keilVo = new KeilVo();
            keilVo.setFileName(c.getFileName());
            ret.add(keilVo);
        });
        return new CommonReturn().success(ret);
    }
}
