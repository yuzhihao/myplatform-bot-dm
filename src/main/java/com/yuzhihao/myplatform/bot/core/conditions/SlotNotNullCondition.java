package com.yuzhihao.myplatform.bot.core.conditions;

import com.yuzhihao.myplatform.bot.core.common.ContextedString;
import com.yuzhihao.myplatform.bot.core.interfaces.Condition;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

/**
 * slot槽填充情况判断
 */
public class SlotNotNullCondition implements Condition {
    @Override
    public void setUp(Map<String, ContextedString> params) {
        params.get("");
    }

    @Override
    public boolean accept(DialogContext context) {
        return false;
    }
}
