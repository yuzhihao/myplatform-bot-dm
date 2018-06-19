package com.yuzhihao.myplatform.bot.core.pojo;

import com.yuzhihao.myplatform.bot.core.pojo.enums.AnswerTypeEnum;

public class AnswerInfo {
    /**
     * 问题id
     */
    private Long questionId;

    /**
     * 答案类型
     */
    private AnswerTypeEnum answerType;

    /**
     * 文本类型答案
     */
    private String answerText;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public AnswerTypeEnum getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerTypeEnum answerType) {
        this.answerType = answerType;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
