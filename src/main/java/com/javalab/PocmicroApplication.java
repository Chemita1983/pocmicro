package com.javalab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.javalab")
public class PocmicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocmicroApplication.class, args);
	}

}
