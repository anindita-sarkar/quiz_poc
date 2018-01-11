package com.cyberaka.quiz;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:mysql.properties")
public class MysqlAutoConfiguration {
	@Value("${mysql.datasource.driver-class-name}")
	private String driverClassName;

	@Value("${mysql.datasource.url}")
	private String url;

	@Value("${mysql.datasource.username}")
	private String userName;

	@Value("${mysql.datasource.password}")
	private String password;

	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}

	@Bean
	@ConditionalOnProperty(name = "usemysql", havingValue = "local")
	@ConditionalOnMissingBean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		return dataSource;
	}
}

