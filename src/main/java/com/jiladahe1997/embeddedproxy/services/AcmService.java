package com.jiladahe1997.embeddedproxy.services;

import com.alibaba.edas.acm.ConfigService;
import com.alibaba.edas.acm.exception.ConfigException;
import com.alibaba.edas.acm.listener.ConfigChangeListener;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class AcmService {

    @Getter
    String config;

    AcmService() throws ConfigException {
        Properties properties = new Properties();
        properties.put("endpoint", "acm.aliyun.com");
        properties.put("namespace", "39a56306-2778-4cb1-9d2b-fa93a2dd7633");
        properties.put("accessKey", "LTAI4Fm1Fxp4q9wZECJjcdyp");
        properties.put("secretKey", "RVIGutr8cgOkbvuTsGiXZn3kk28a2v");

        ConfigService.init(properties);
        config = ConfigService.getConfig("embeddedproxy", "DEFAULT_GROUP", 6000);

        // 初始化的时候，给配置添加监听，配置变更会回调通知
        ConfigService.addListener("embeddedproxy", "DEFAULT_GROUP", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                config = configInfo;
            }
        });
    }
}
