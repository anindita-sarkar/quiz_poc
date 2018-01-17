package com.cyberaka.quiz.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "quiz-ws", url = "localhost:8000")
public interface QuizWSProxy {
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword);

	@GetMapping("/topics")
	public ResponseEntity<String> listTopics();

	@GetMapping("/subtopics/{topicID}")
	public ResponseEntity<String> findByTopic(@PathVariable("topicID") int topicId);

	@GetMapping("/quiz/{topicId}/{subTopicId}/{level}/{count}")
	public ResponseEntity<String> getQuiz(@PathVariable("topicId") int topicId,
			@PathVariable("subTopicId") int subTopicId, @PathVariable("level") int level,
			@PathVariable("count") int count);

}
