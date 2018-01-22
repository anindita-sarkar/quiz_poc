package com.cyberaka.quiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cyberaka.quiz.dao.SubTopicRepository;
import com.cyberaka.quiz.domain.SubTopic;
import com.cyberaka.quiz.service.SubTopicService;

@Service
@CacheConfig(cacheNames = "quizCache")
public class SubTopicServiceImpl implements SubTopicService {
	@Autowired
	SubTopicRepository subTopicRepo;

	@Cacheable(value = "quizCache", key = "#topicId", unless = "#result==null")

	public Iterable<SubTopic> findByTopic(Integer topicId) {
		return subTopicRepo.findByTopic(topicId);

	}
}
