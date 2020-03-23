package com.example.consumer;

import com.example.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserRibbonController {
    @Autowired
    RestTemplate restTemplate;

    //ribbon的调用方式
    @RequestMapping(value = "findUserById_ribbon")
    public User findUserById(Integer userId){
        //下面这个地址就是两个提供方的   服务名称+提供方controller的开放接口...
        return restTemplate.getForObject("http://provider/findUserById?userId="+userId,User.class);
    }
}
