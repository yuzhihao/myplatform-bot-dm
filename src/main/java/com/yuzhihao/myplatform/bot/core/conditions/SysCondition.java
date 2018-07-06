package com.yuzhihao.myplatform.bot.core.conditions;

import com.yuzhihao.myplatform.bot.core.common.ContextedString;
import com.yuzhihao.myplatform.bot.core.interfaces.Condition;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

public class SysCondition implements Condition {


    @Override
    public void setUp(Map<String, ContextedString> params) {

    }

    @Override
    public boolean accept(DialogContext context) {
        return false;
    }

}
