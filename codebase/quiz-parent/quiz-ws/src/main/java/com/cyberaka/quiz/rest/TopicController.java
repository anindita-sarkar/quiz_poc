package com.cyberaka.quiz.rest;

import com.cyberaka.quiz.domain.Topic;
import com.cyberaka.quiz.dto.TopicDto;
import com.cyberaka.quiz.service.TopicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TopicService topicService;

    @RequestMapping("/topics")
    @ResponseBody
    public List<TopicDto> listTopics() {
        Iterable<Topic> topics = topicService.findAll();
        List<TopicDto> results = new ArrayList<TopicDto>();
        for (Topic topic : topics) {
            TopicDto dto = new TopicDto();
            dto.clone(topic);
            results.add(dto);
        }
        logger.info(">>"+results);
        return results;
    }
}
