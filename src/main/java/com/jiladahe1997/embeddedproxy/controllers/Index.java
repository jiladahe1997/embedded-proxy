package com.jiladahe1997.embeddedproxy.controllers;

import com.alibaba.edas.acm.exception.ConfigException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiladahe1997.embeddedproxy.models.CommonReturn;
import com.jiladahe1997.embeddedproxy.models.index.ConfigList;
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

@RestController
public class Index {

    @Autowired
    AcmService acmService;

    @RequestMapping("/")
    public String index() throws IOException {
        HttpEntity httpEntity = Request.Get("https://embeddedproxy-1252616609.cos.ap-chengdu.myqcloud.com/static/index.html").execute().returnResponse().getEntity();
        return EntityUtils.toString(httpEntity, "utf8");
    }

    @RequestMapping("/admin")
    public String admin() throws IOException {
        HttpEntity httpEntity = Request.Get("https://embeddedproxy-1252616609.cos.ap-chengdu.myqcloud.com/static/admin.html").execute().returnResponse().getEntity();
        return EntityUtils.toString(httpEntity, "utf8");
    }

    @RequestMapping("/api/index/config")
    public CommonReturn config() throws IOException {
        ConfigList configList =  new ObjectMapper().readerFor(ConfigList.class).readValue(acmService.getIndexCard());
        return new CommonReturn().success(configList);
    }
}
