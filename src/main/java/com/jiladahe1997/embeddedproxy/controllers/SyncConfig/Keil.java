package com.jiladahe1997.embeddedproxy.controllers.SyncConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.SyncConfig.KeilVo;
import com.jiladahe1997.embeddedproxy.models.scheduling.SyncConfig;
import com.jiladahe1997.embeddedproxy.services.AcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Keil {

    @Autowired
    AcmService acmService;


    @RequestMapping("/api/SyncConfig")
    public CommonReturn config(@RequestParam String name) throws IOException, NoSuchFieldException, IllegalAccessException {
        Field field  = AcmService.class.getField(name + "SyncData");
        SyncConfig syncConfigs[] = new ObjectMapper().readerFor(SyncConfig[].class).readValue((String) field.get(acmService));
        List<SyncConfig> configList = Arrays.asList(syncConfigs);
        List<KeilVo> ret = new ArrayList<KeilVo>();
        configList.forEach(c->{
            KeilVo keilVo = new KeilVo();
            keilVo.setFileName(c.getFileName());
            ret.add(keilVo);
        });
        return new CommonReturn().success(ret);
    }
}
