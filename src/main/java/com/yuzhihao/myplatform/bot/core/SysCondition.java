package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.common.ContextedString;
import com.yuzhihao.myplatform.bot.core.interfaces.Condition;
import com.yuzhihao.myplatform.bot.core.pojo.DialogueContext;

import java.util.Map;

public class SysCondition implements Condition {


    @Override
    public void setUp(Map<String, ContextedString> params) {

    }

    @Override
    public boolean accept(DialogueContext context) {
        return false;
    }

}
