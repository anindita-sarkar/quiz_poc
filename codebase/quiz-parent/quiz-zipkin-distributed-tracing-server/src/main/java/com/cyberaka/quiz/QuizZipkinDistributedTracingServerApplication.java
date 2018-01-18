package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class QuizZipkinDistributedTracingServerApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication
				.run(QuizZipkinDistributedTracingServerApplication.class, args);

	}
}
