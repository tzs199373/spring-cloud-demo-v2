package com.example.common.service;

import com.example.common.fallback.ProviderApiFallbackFactory;
import com.example.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="provider",fallbackFactory = ProviderApiFallbackFactory.class)
public interface ProviderApi {
    @RequestMapping("/findUserById")
    User findUserById(@RequestParam("userId") Integer id);
}
