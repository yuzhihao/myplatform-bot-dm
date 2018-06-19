package com.yuzhihao.myplatform.bot.core.middleware.after;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

/**
 * 缺省回复
 *
 */
public class DefalutAnswerMiddleware extends DialogueMiddleware {



    @Override
    public void afterProcessing() {

    }

    @Override
    protected boolean isRequired() {
        return true;
    }


    @Override
    protected boolean isAfter() {
        return true;
    }

    @Override
    protected boolean checkParam() {
        return false;
    }

    @Override
    protected void preProcessing() {

    }


}
