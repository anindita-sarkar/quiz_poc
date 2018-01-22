package com.cyberaka.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cyberaka.quiz.dao.TopicRepository;
import com.cyberaka.quiz.domain.Topic;
import com.cyberaka.quiz.service.TopicService;

@Service
@CacheConfig(cacheNames = "quizCache")
public class TopicServiceImpl implements TopicService {
	@Autowired
	TopicRepository topicRepo;

	@Cacheable()
	public Iterable<Topic> findAll() {
		return topicRepo.findAll();

	}
}
