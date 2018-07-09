package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.Bot;
import com.yuzhihao.myplatform.bot.core.pojo.CurrentStateNode;
import com.yuzhihao.myplatform.bot.core.pojo.Scene;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DomainCodeEnum;
import com.yuzhihao.myplatform.bot.core.utils.GlobalUtils;

import java.util.Map;

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
        DMThreadContext threadCtx = DMThreadContext.getInstance();
        String query = (String) threadCtx.get(DMThreadContextEnum.QUESTION);
        Map config = getBotMiddlewareConfig();
        String sceneStr = domainReconize((String) config.get("url"),query);
        String sceneId = (String) ((Map)config.get("domainScene")).get(sceneStr);
        Scene scene = GlobalUtils.getSceneById(sceneId);
        if (scene == null){
            // Default scene TODO
        }
        if (threadCtx.get(DMThreadContextEnum.STATE_NODE_CURRENT)==null){
            // 初始化CurrentNode  TODO
            CurrentStateNode curNode = null;
            threadCtx.set(DMThreadContextEnum.STATE_NODE_CURRENT, curNode);
        }
        threadCtx.set(DMThreadContextEnum.DOMAIN_SCENE,scene);
    }

    @Override
    public void afterProcessing() {}

    /**
     * 调用领域识别
     * @param url
     * @param query
     * @return
     */
    private String domainReconize(String url, String query){
        // TODO
        return "assurance";
    }
}
