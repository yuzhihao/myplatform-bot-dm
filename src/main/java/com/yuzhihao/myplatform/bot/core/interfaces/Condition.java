package com.yuzhihao.myplatform.bot.core.interfaces;

import com.yuzhihao.myplatform.bot.core.common.ContextedString;
import com.yuzhihao.myplatform.bot.core.pojo.DialogueContext;

import java.util.Map;

public interface Condition {

    void setUp(Map<String, ContextedString> params);

    /**
     * @param context
     * @return
     */
    boolean accept(DialogueContext context);


}
