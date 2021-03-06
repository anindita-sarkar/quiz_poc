package com.cyberaka.quiz.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "quiz_question")
public class Question implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ques_id", nullable = false)
    private Integer questionId;
    @Column(columnDefinition = "text", name = "question")
    private String question;
    @Column(name = "answers")
    private String answers;
    @Column(columnDefinition = "text", name = "options")
    private String options;
    @Column(name = "difficulty_level")
    private Integer difficultyLevel;
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "sub_topic_id", referencedColumnName = "sub_topic_id")
    private SubTopic subTopic;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User contributer;

    public Question() {
        super();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public SubTopic getSubTopic() {
        return subTopic;
    }

    public void setSubTopic(SubTopic subTopic) {
        this.subTopic = subTopic;
    }

    public User getContributer() {
        return contributer;
    }

    public void setContributer(User contributer) {
        this.contributer = contributer;
    }

    public Integer getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(Integer difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public boolean isValid() {
        return topic != null && subTopic != null && contributer != null &&
                difficultyLevel != null && options != null && !options.isEmpty() &&
                answers != null && !answers.isEmpty() && question != null &&
                !question.isEmpty();
    }

}
