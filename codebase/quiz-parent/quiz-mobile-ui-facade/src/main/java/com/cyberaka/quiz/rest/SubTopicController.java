package com.cyberaka.quiz.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SubTopicController {
	@Value("${ws.url}")
	private String resourceUrl;

	@RequestMapping("/subtopics/{topicID}")
	@ResponseBody
	public ResponseEntity<String> findByTopic(@PathVariable("topicID") int topicId) {
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "subtopics/" + topicId;
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class);
		return response;
	}
}
