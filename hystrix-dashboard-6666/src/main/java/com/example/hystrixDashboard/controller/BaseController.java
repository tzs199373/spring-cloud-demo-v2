package com.example.hystrixDashboard.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @RequestMapping("/print")
    public String print(){
        return "OK";
    }
}
