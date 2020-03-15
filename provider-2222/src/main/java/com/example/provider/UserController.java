package com.example.provider;

import com.example.common.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/findUserById")
    User findUserById(@RequestParam("userId") Integer id){
        User user = new User();
        user.setUserId(id);
        user.setUserName("Tom");
        return user;
    }
}
