package com.example.consumer;

import com.example.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages= {"com.example.common"})
@ComponentScan({"com.example.common","com.example.consumer"})
@RibbonClient(name="provider",configuration=MySelfRule.class)
public class Consumer3332Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer3332Application.class, args);
	}

}
