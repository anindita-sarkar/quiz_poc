package com.cyberaka.quiz;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

/**
 * Entry point into the quiz boot application.
 *
 * @author anindita
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableAutoConfiguration
public class QuizBootApplication { // extends SpringBootServletInitializer {

	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(QuizBootApplication.class);
	// }

	static final Logger LOG = Logger.getLogger(QuizBootApplication.class.getName());

	public QuizBootApplication() {
		// Default constructor.
	}

	public static void main(String[] args) {
		SpringApplication.run(QuizBootApplication.class, args);
	}

	public void info() {
		LOG.info("Quiz Boot Applicaiton");
	}

	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}


	
}
