package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.sun.xml.internal.ws.db.DatabindingImpl;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

/**
 * 多轮对话打断处理
 */
public class InterruptHandlerMiddleware extends DialogueMiddleware {
    @Override
    protected void preProcessing() {
        // 对话打断判断 处理
    }

    @Override
    protected void afterProcessing() {

    }
}
