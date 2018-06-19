package com.yuzhihao.myplatform.bot.core.pojo.param;

import com.yuzhihao.myplatform.bot.core.pojo.StateNode;

/**
 * 提问参数
 *
 * @author yuzhihao
 * @date 2018/06/05
 */
public class AskParam {
    private String question;
    private String userId;
    private String sessionId;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


}
