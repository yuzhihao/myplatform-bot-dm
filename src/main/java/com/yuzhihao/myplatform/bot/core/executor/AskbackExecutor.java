package com.yuzhihao.myplatform.bot.core.executor;

import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

/**
 * 执行器：反问用户，明确实体
 */
public class AskbackExecutor implements Executor {

    @Override
    public void setUp(Map<String, Object> params) {

    }

    @Override
    public void execute(DialogContext context) {
        // 根据 用户询问实体 查找最相关实体 反问用户 TODO
    }
}
