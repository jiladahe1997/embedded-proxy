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
    public String indexCard;
    @Getter
    public String KeilSyncData;
    @Getter
    public String NXPSyncData;
    @Getter
    public String ARMSyncData;

    public  void hihi()
    {System.out.println("你好你好你好你好");}

    public AcmService() throws ConfigException {
        Properties properties = new Properties();
        properties.put("endpoint", "acm.aliyun.com");
        properties.put("namespace", "39a56306-2778-4cb1-9d2b-fa93a2dd7633");
        properties.put("accessKey", "LTAI4Fm1Fxp4q9wZECJjcdyp");
        properties.put("secretKey", "RVIGutr8cgOkbvuTsGiXZn3kk28a2v");

        Boolean isLocal = System.getenv("JAVA_ENV") != null && (System.getenv("JAVA_ENV").equals("local"));

        ConfigService.init(properties);
        indexCard = ConfigService.getConfig("index-card", isLocal  ? "test-embeddedproxy":"embeddedproxy", 6000);
        KeilSyncData = ConfigService.getConfig("Keil-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", 6000);
        NXPSyncData = ConfigService.getConfig("NXP-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", 6000);
        ARMSyncData = ConfigService.getConfig("ARM-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", 6000);

        // 初始化的时候，给配置添加监听，配置变更会回调通知
        ConfigService.addListener("index-card", isLocal  ? "test-embeddedproxy":"embeddedproxy", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                indexCard = configInfo;
            }
        });
        ConfigService.addListener("Keil-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                KeilSyncData = configInfo;
            }
        });
        ConfigService.addListener("NXP-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                NXPSyncData = configInfo;
            }
        });
        ConfigService.addListener("ARM-sync-data", isLocal ? "test-embeddedproxy":"embeddedproxy", new ConfigChangeListener() {
            public void receiveConfigInfo(String configInfo) {
                ARMSyncData = configInfo;
            }
        });
    }
}
