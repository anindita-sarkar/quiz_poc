package com.cyberaka.quiz.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubTopicController {
	@Value("${ws.url}")
	private String resourceUrl;

	@GetMapping("/subtopics/{topicID}")
	public ResponseEntity<String> findByTopic(@PathVariable("topicID") int topicId) {
		Map<String, String> uriVariables=new HashMap<>();
		uriVariables.put("topicID", ""+topicId);
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "subtopics/{topicID}" ;
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class,uriVariables);
		return response;
	}
}
