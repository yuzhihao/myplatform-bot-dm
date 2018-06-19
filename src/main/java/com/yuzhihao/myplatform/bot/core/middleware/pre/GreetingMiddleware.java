package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

public class GreetingMiddleware extends DialogueMiddleware {



    @Override
    public void preProcessing() {
        greeting();
    }

    @Override
    public void afterProcessing() {
    }

    public boolean checkQuestion(){
        return true;
    };

    public void greeting(){
        // greeting
        // 设置 response，后续中间件就不需要执行了
    }


    protected boolean isRequire() {
        return true;
    }

    @Override
    protected boolean checkParam() {
        return false;
    }
}
