package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class QuizNetflixEurekaNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizNetflixEurekaNamingServerApplication.class, args);

	}

}
