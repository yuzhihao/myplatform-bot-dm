package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.results.EntityResult;
import com.yuzhihao.myplatform.bot.core.pojo.results.IntentResult;

/**
 * 意图识别
 */
public class IntentRecognizeMiddleware extends DialogueMiddleware {

    @Override
    protected void preProcessing() {
        EntityResult entityResult = (EntityResult) DMThreadContext.getInstance().get(DMThreadContextEnum.ENTITY_RESULT);
        //调用API 根据实体识别结果 得到意图识别结果 TODO

        IntentResult intentResult = null;
        DMThreadContext.getInstance().set(DMThreadContextEnum.INTENT_RESULT,intentResult);
    }

    @Override
    protected void afterProcessing() {

    }
}
