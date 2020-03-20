package com.example.common.service;

import com.example.common.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProviderApi {
    @RequestMapping("/findUserById")
    User findUserById(@RequestParam("userId") Integer id);
}
