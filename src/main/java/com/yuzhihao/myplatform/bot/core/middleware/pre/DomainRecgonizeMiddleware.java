package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.Bot;
import com.yuzhihao.myplatform.bot.core.pojo.Scene;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DomainCodeEnum;
import com.yuzhihao.myplatform.bot.core.utils.GlobalUtils;

/**
 * 领域识别
 */
public class DomainRecgonizeMiddleware extends DialogueMiddleware{
    @Override
    protected boolean checkParam() {
        return false;
    }

    @Override
    public void preProcessing() {
        // 通过领域识别 进入到特定Scene
        String sceneStr = "Scene code";
        Scene scene = scene = GlobalUtils.getSceneByDomainCode(DomainCodeEnum.getEnumByStr(sceneStr));
        if (scene==null){
            // Default scene TODO
        }
        DMThreadContext.getInstance().set(DMThreadContextEnum.DOMAIN_SCENE,scene);
    }

    @Override
    public void afterProcessing() {}
}
