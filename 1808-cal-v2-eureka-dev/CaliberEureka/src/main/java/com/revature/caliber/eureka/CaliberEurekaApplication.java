package com.revature.caliber.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CaliberEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaliberEurekaApplication.class, args);
	}
}
