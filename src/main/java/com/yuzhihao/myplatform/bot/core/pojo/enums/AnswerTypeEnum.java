package com.yuzhihao.myplatform.bot.core.pojo.enums;

public enum AnswerTypeEnum {
    SINGLE(1,"single"),
    MULTI(2,"multi");

    private Integer code;
    private String message;

    private AnswerTypeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
