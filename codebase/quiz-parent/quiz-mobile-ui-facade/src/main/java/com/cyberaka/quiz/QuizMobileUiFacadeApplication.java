package com.cyberaka.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableFeignClients("com.cyberaka.quiz")
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class QuizMobileUiFacadeApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(QuizMobileUiFacadeApplication.class, args);

	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}
