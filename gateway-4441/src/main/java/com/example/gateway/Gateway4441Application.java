package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Gateway4441Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway4441Application.class, args);
	}

}
