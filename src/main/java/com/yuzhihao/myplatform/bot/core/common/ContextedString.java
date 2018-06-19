package com.yuzhihao.myplatform.bot.core.common;

public class ContextedString {

    String value = null;

    public ContextedString(){
        this(null);
    }

    public ContextedString(String s){
        this.value = s;
    }
}
