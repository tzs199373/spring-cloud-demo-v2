package com.example.consumer;

import com.example.common.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="provider")
public interface InvokeProvider {

    @RequestMapping("/findUserById")
     User findUserById(@RequestParam("userId") Integer id);
}
