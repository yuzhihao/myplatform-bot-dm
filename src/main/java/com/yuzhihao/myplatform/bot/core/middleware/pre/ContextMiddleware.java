package com.yuzhihao.myplatform.bot.core.middleware.pre;

import com.yuzhihao.myPlatform.common.utils.JacksonUtils;
import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.client.redis.RedisServiceImpl;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.Bot;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import com.yuzhihao.myplatform.bot.core.pojo.Session;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * 获取对话上下文信息
 * 可以使用的数据：BOT,CONTEXT
 */
public class ContextMiddleware extends DialogueMiddleware {

    @Autowired
    RedisServiceImpl redisService;

    @Override
    protected boolean isRequired() {
        return true;
    }

    @Override
    protected boolean checkParam() {
        return true;
    }

    @Override
    public void preProcessing() {
        //DMThreadContext threadCtx = DMThreadContext.getInstance();
        //DialogContext context = (DialogContext) threadCtx.get(DMThreadContextEnum.CONTEXT);
        //Bot bot = (Bot)threadCtx.get(DMThreadContextEnum.BOT);
    }

    @Override
    public void afterProcessing() {}

}
