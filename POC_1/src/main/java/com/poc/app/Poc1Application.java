package com.poc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.poc.app")
public class Poc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc1Application.class, args);
	}
}
