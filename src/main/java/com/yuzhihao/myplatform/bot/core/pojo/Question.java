package com.yuzhihao.myplatform.bot.core.pojo;

/**
 * 用户提问 pojo
 */
public class Question {
    private Long id;
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
