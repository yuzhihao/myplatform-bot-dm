package com.yuzhihao.myplatform.bot.core.middleware.after;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

/**
 * 意图执行
 */
public class IntentExecutMiddleware extends DialogueMiddleware {

    @Override
    protected void preProcessing() {
        return;
    }

    @Override
    protected void afterProcessing() {
        // 根据意图识别结果以及配置 调用第三方接口
    }
}
