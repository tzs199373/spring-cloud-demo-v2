package com.example.nacosConfig.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.example.nacosConfig.util.NacosUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Autowired
    private NacosUtil nacosUtil;


    @Value("${myConfig.myKey:1}")
    private String config;

    @RequestMapping("/getValue")
    public String getValue() {
        return config;
    }

    @RequestMapping("/getValue2")
    public String getValue2() throws NacosException {
        return nacosUtil.getConfig("CONFIG_GROUP","test-dataId");
    }
}
