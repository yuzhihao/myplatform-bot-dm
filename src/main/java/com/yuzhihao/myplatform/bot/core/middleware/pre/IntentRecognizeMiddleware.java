package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.results.EntityResult;
import com.yuzhihao.myplatform.bot.core.pojo.results.IntentResult;

/**
 * 意图识别
 * 可用变量：
 * ENTITY_RESULT,CONTEXT,QUESTION,BOT
 */
public class IntentRecognizeMiddleware extends DialogueMiddleware {

    @Override
    protected void preProcessing() {
        EntityResult entityResult = (EntityResult) DMThreadContext.getInstance().get(DMThreadContextEnum.ENTITY_RESULT);
        String question = (String) DMThreadContext.getInstance().get(DMThreadContextEnum.QUESTION);
        IntentResult intentResult = intentReconize(entityResult,question);
        DMThreadContext.getInstance().set(DMThreadContextEnum.INTENT_RESULT,intentResult);
        ((DialogContext)DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT)).setIntentResult(intentResult);
    }

    private IntentResult intentReconize(EntityResult entityResult, String query){
        //调用API 根据实体识别结果 得到意图识别结果 TODO
        return new IntentResult();
    }

    @Override
    protected void afterProcessing() {

    }
}
