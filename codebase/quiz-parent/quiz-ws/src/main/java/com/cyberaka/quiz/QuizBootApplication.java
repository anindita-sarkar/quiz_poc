package com.cyberaka.quiz;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Entry point into the quiz boot application.
 *
 * @author anindita
 */

@SpringBootApplication
@EnableDiscoveryClient
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

	

	
}
