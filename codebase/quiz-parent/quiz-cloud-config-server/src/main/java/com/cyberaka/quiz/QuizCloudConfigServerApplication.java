package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class QuizCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizCloudConfigServerApplication.class,args);

	}

}
