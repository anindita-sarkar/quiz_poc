package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class QuizZipkinDistributedTracingServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuizZipkinDistributedTracingServerApplication.class, args);

	}
}
