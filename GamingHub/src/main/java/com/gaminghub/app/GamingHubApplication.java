package com.gaminghub.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.gaminghub")
@SpringBootApplication(scanBasePackages="com.gaminghub")
public class GamingHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamingHubApplication.class, args);
	}

}
