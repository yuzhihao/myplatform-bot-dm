package com.yuzhihao.myplatform.bot.core.pojo.enums;

public enum DMThreadContextEnum {
    SESSION_ID,
    QUESTION_ID,
    QUESTION,
    BOT,
    DOMAIN_SCENE("????????"),
    STATE_NODE_CURRENT,
    CONTEXT("???"),
    PROEESS_STATE("??????"),
    ANSWER_INFO("??");

    private String desc;

    private DMThreadContextEnum(){}

    private DMThreadContextEnum(String desc){
        this.desc = desc;
    }
}
