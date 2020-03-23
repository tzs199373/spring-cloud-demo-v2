package com.example.provider;

import com.example.common.model.User;
import com.example.common.service.ProviderApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements ProviderApi {
    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam("userId") Integer id){
        User user = new User();
        user.setUserId(id);
        user.setUserName("another Tom");
        return user;
    }

}
