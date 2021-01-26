package com.example.nacosConfig.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
    @Value("${myConfig.myKey:1}")
    private String config;

    @RequestMapping("/getValue")
    public String getValue() {
        return config;
    }
}
