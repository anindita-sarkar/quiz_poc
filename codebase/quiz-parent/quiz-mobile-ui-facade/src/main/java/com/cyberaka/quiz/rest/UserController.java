package com.cyberaka.quiz.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

	@Value("${ws.url}")
	private String resourceUrl;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword) {
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "login?userName=" + userName + "&userPassword=" + userPassword;
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl,
				String.class);
		return response;
	}
}
