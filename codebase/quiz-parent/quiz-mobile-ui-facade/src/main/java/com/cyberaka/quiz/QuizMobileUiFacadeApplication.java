package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@EnableFeignClients("com.cyberaka.quiz")
@EnableDiscoveryClient
@SpringBootApplication
public class QuizMobileUiFacadeApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(QuizMobileUiFacadeApplication.class, args);

	}

}
