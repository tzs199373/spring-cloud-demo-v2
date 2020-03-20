package com.example.provider;

import com.example.common.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/findUserById")
    User findUserById(@RequestParam("userId") Integer id){
        if(id <= 0){
            throw new RuntimeException("id error");
        }
        User user = new User();
        user.setUserId(id);
        user.setUserName("Tom");
        return user;
    }

    User fallback(@RequestParam("userId") Integer id){
        User user = new User();
        user.setUserId(id);
        user.setUserName("Tom's son");
        return user;
    }
}
