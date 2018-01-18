package com.cyberaka.quiz.rest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "quiz-ws", url="localhost:8000")
//@FeignClient(name = "quiz-ws")
@FeignClient(name = "quiz-netflix-zuul-api-gateway-server")
@RibbonClient(name = "quiz-ws")
public interface QuizWSProxy {
	@GetMapping("/quiz-ws/login")
	public ResponseEntity<String> login(@RequestParam("userName") String userName,
			@RequestParam("userPassword") String userPassword);

	@GetMapping("/quiz-ws/topics")
	public ResponseEntity<String> listTopics();

	@GetMapping("/quiz-ws/subtopics/{topicID}")
	public ResponseEntity<String> findByTopic(@PathVariable("topicID") int topicId);

	@GetMapping("/quiz-ws/quiz/{topicId}/{subTopicId}/{level}/{count}")
	public ResponseEntity<String> getQuiz(@PathVariable("topicId") int topicId,
			@PathVariable("subTopicId") int subTopicId, @PathVariable("level") int level,
			@PathVariable("count") int count);

}
