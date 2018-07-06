package com.yuzhihao.myplatform.bot.core.middleware;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.common.consts.DialogueConsts;
import com.yuzhihao.myplatform.bot.core.interfaces.Middleware;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;

/**
 * 对话中间件基类
 *
 * 子类可选择 覆盖以下方法进行配置
 *      isPre()
 *      isAfter()
 *      isConfigured()
 *      checkDone()
 *      isRequire()
 *      checkParam()
 *
 * @author yuzhihao
 */
public abstract class DialogueMiddleware implements Middleware {

    /**
     * 判断配置中是否有配置该模块
     */
    protected boolean isConfigured(){
        //TODO
        return true;
    }

    /**
     * DONE状态表示处理完了，直接返回了
     */
    protected boolean checkDone(){
        if(DialogueConsts.DONE.equals(DMThreadContext.getInstance().get(DMThreadContextEnum.PROEESS_STATE))){
            return true;
        }
        return false;
    }

    /**
     * 是否必须执行
     */
    protected boolean isRequired(){
        return false;
    }

    /**
     * 是否执行预处理
     */
    protected boolean isPre(){
        return false;
    };

    /**
     * 是否执行后处理
     */
    protected boolean isAfter(){
        return false;
    };

    /**
     * 执行所需参数是否完备
     */
    protected boolean checkParam(){
        return true;
    };

    @Override
    public void preProcess(){
        if (isPre() && (isRequired() || isConfigured() && !checkDone() && checkParam())){
            preProcessing();
        }
    }

    @Override
    public void afterProcess(){
        if (isAfter() && (isRequired() || isConfigured() && !checkDone() && checkParam())){
            afterProcessing();
        }
    }

    /**
     * 预处理 子类实现方法
     */
    protected abstract void preProcessing();

    /**
     * 后处理 子类实现方法
     */
    protected abstract void afterProcessing();
}
