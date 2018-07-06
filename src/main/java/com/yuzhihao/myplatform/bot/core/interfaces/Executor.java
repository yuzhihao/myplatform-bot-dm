package com.yuzhihao.myplatform.bot.core.interfaces;

import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

/**
 * 节点的执行接口
 */
public interface Executor {

    void setUp(Map<String,Object> params);

    void execute(DialogContext context);
}
