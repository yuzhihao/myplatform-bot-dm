package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.results.NLUResult;

/**
 * 自然语言理解 NLU
 */
public class NLUMiddleware extends DialogueMiddleware {

    @Override
    protected void preProcessing() {
        // 调用自然语言理解api TODO

        NLUResult nluResult = null;
        DMThreadContext.getInstance().set(DMThreadContextEnum.NLU_RESULT, nluResult);
    }

    @Override
    protected void afterProcessing() {

    }
}
