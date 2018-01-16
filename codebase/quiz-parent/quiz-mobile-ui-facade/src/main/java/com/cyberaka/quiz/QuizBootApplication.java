package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QuizBootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(QuizBootApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
