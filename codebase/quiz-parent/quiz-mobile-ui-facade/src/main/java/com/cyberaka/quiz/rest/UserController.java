package com.cyberaka.quiz.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment env;
	@Autowired
	private QuizWSProxy proxy;

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("userName", userName);
		uriVariables.put("userPassword", userPassword);

		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = env.getProperty("ws.url") + "login?userName={userName}&userPassword={userPassword}";
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class, uriVariables);
		logger.info(">>"+response);
		return response;
	}
	
	@GetMapping("/url")
	public String getUrl() {
		
		return env.getProperty("ws.url");
	}

	@GetMapping("/login-feign")
	public ResponseEntity<String> loginFeign(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword) {

		ResponseEntity<String> response = proxy.login(userName, userPassword);
		logger.info(">>"+response);
		return response;
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
	public String retrieveConfiguration() {
		throw new RuntimeException("Not available");
	}

	public String fallbackRetrieveConfiguration() {
		return "wwww.google.com";
	}
	
}
