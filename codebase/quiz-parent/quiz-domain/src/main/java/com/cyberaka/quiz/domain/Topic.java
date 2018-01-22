package com.cyberaka.quiz.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "quiz_topic")
public class Topic implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id", nullable = false)
    private Integer topicId;

    @Column(name = "title")
    private String title;

    public Topic() {
        super();
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
