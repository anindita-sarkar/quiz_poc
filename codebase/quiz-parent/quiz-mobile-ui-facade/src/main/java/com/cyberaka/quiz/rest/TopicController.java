package com.cyberaka.quiz.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TopicController {
	@Value("${ws.url}")
	private String resourceUrl;
	@Autowired
	private QuizWSProxy proxy;

	@GetMapping("/topics")
	public ResponseEntity<String> listTopics() {
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "topics";
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class);
		return response;
	}
	@GetMapping("/topics-feign")
	public ResponseEntity<String> listTopicsFeign() {
		ResponseEntity<String> response = proxy.listTopics();
		return response;
	}
}
