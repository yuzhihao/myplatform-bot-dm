package com.yuzhihao.myplatform.bot.core.pojo.enums;

/**
 * DM线程共享数据内容枚举
 */
public enum DMThreadContextEnum {
    SESSION_ID,
    QUESTION_ID,
    QUESTION,
    BOT("当前机器人"),
    DOMAIN_SCENE("识别领域"),
    STATE_NODE_CURRENT,
    CONTEXT("上下文"),
    PROEESS_STATE("处理状态"),
    ANSWER_INFO("回复答案"),
    NLU_RESULT("自然语义理解处理结果"),
    ENTITY_RESULT("实体结果"),
    INTENT_RESULT("意图结果");

    private String desc;

    private DMThreadContextEnum(){}

    private DMThreadContextEnum(String desc){
        this.desc = desc;
    }
}
