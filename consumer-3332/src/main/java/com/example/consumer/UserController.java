package com.example.consumer;

import com.example.common.model.User;
import com.example.common.service.ProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings("all")
public class UserController {
    @Autowired
    private ProviderApi providerApi;

    @RequestMapping(value = "/findUserById")
    User findUserById(@RequestParam("userId") Integer id){
        System.out.println(id);
        System.out.println("consumer3332");
        return providerApi.findUserById(id);
    }
}
