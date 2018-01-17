package com.cyberaka.quiz.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

	@Autowired
	private Environment env;

	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword) {
		Map<String, String> uriVariables=new HashMap<>();
		uriVariables.put("userName", userName);
		uriVariables.put("userPassword", userPassword);
		
		
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = env.getProperty("ws.url") + "login?userName={userName}&userPassword={userPassword}";
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class,uriVariables);
		return response;
	}
}
