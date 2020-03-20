package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages= {"com.example.common"})
@ComponentScan({"com.example.common","com.example.consumer"})
public class Consumer3333Application {

	public static void main(String[] args) {
		SpringApplication.run(Consumer3333Application.class, args);
	}

}
