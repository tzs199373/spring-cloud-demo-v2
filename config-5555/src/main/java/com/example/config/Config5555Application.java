package com.example.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Config5555Application {
	public static void main(String[] args) {
		SpringApplication.run(Config5555Application.class, args);
	}
}
