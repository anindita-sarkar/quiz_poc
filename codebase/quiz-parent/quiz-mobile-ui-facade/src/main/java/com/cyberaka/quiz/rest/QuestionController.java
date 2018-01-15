package com.cyberaka.quiz.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuestionController {
	@Value("${ws.url}")
	private String resourceUrl;

	@RequestMapping("/quiz/{topicId}/{subTopicId}/{level}/{count}")
	@ResponseBody
	public ResponseEntity<String> getQuiz(@PathVariable("topicId") int topicId,
			@PathVariable("subTopicId") int subTopicId, @PathVariable("level") int level,
			@PathVariable("count") int count) {
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "quiz/" + topicId + "/" + subTopicId + "/" + level + "/" + count;
		ResponseEntity<String> response = restTemplate.getForEntity(updatedResourceUrl, String.class);
		return response;
	}

	@RequestMapping(value = "/quiz/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> submitQuizAnswer(Model model, @PathVariable("userId") int userId,
			@RequestBody String body) {
		RestTemplate restTemplate = new RestTemplate();
		String updatedResourceUrl = resourceUrl + "quiz/" + userId;
		ResponseEntity<String> response = restTemplate.postForEntity(updatedResourceUrl, body, String.class);
		return response;
	}

}
