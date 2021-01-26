package com.example.nacosConfig.util;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Component
public class NacosUtil {
    @Value("${spring.cloud.nacos.config.server-addr}")
    private String serverAddr;

    private static final Map<ConfigKey,String> map = new HashMap<>();

    public String getConfig(String group,String dataId) throws NacosException {
        ConfigService configService = NacosFactory.createConfigService(serverAddr);
        String value = configService.getConfig(dataId, group, 5000);
        map.put(new ConfigKey(group,dataId),value);

        //监听器，一旦nacos中相应值改变，则进行相应开关状态改变
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String content) {
                map.put(new ConfigKey(group,dataId),value);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        return map.get(new ConfigKey(group,dataId));
    }


    public static class ConfigKey{
        private String group;
        private String dataId;

        public ConfigKey(String group, String dataId) {
            this.group = group;
            this.dataId = dataId;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ConfigKey configKey = (ConfigKey) o;

            if (!group.equals(configKey.group)) return false;
            return dataId.equals(configKey.dataId);
        }

        @Override
        public int hashCode() {
            int result = group.hashCode();
            result = 31 * result + dataId.hashCode();
            return result;
        }
    }
}