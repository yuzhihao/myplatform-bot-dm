package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

/**
 * 获取对话上下文信息
 */
public class ContextMiddleware extends DialogueMiddleware {

    @Override
    protected boolean isRequired() {
        return true;
    }

    @Override
    protected boolean checkParam() {
        return true;
    }

    @Override
    public void preProcessing() {
        //根据sessionId获取对话上下文
        //从redis cache中尝试获取上次对话信息

    }

    @Override
    public void afterProcessing() {}

}
