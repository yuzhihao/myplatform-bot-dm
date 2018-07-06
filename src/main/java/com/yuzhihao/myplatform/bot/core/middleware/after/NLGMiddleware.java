package com.yuzhihao.myplatform.bot.core.middleware.after;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;

/**
 * 自然语言生成器
 */
public class NLGMiddleware extends DialogueMiddleware {

    @Override
    protected void preProcessing() {
        return;
    }

    @Override
    protected void afterProcessing() {
        // 自然语言生成器 TODO

        AnswerInfo answerInfo = null;

    }
}
