package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.results.EntityResult;

/**
 * 实体识别
 * 可用变量：DOMAIN_SCENE,BOT,QUESTION,CONTEXT
 */
public class EntityRecognizeMiddleware extends DialogueMiddleware {
    @Override
    protected void preProcessing() {
        String question = (String) DMThreadContext.getInstance().get(DMThreadContextEnum.QUESTION);
        EntityResult entityResult = entityReconize(question);
        DMThreadContext.getInstance().set(DMThreadContextEnum.ENTITY_RESULT, entityResult);
        ((DialogContext)DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT)).setEntityResult(entityResult);
    }

    /**
     *
     * @return
     */
    private EntityResult entityReconize(String question){
        // 调用实体识别API TODO
        return new EntityResult();
    }

    @Override
    protected void afterProcessing() {

    }
}
