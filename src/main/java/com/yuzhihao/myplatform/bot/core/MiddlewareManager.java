package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.middleware.after.IntentExecutMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.after.NLGeneratorMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.after.ScoreRankMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.pre.ContextMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.after.DefalutAnswerMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.pre.DomainRecgonizeMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.pre.GreetingMiddleware;
import com.yuzhihao.myplatform.bot.core.middleware.pre.InterruptHandlerMiddleware;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class MiddlewareManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MiddlewareManager.class);

    private List<DialogueMiddleware> middlewares;

    public MiddlewareManager(){
        initMiddlewares();
    }

    /**
     * 中间件 初始化 按定义顺序执行
     */
    void initMiddlewares(){
        middlewares = new LinkedList();
        LOGGER.info("init middlewares:");
        /***预处理中间件***/

        //获取上下文数据
        middlewares.add(new ContextMiddleware());
        //多轮对话打断处理
        middlewares.add(new InterruptHandlerMiddleware());
        //问候
        middlewares.add(new GreetingMiddleware());
        //领域识别
        middlewares.add(new DomainRecgonizeMiddleware());
        //实体识别

        //意图识别

        /*** 后处理中间件 ***/
        // 结果评分与筛选
        middlewares.add(new ScoreRankMiddleware());
        // 意图执行（调用第三方API）
        middlewares.add(new IntentExecutMiddleware());
        // 自然语言生成（handlerbar）
        middlewares.add(new NLGeneratorMiddleware());
        // 缺省回复
        middlewares.add(new DefalutAnswerMiddleware());
        LOGGER.info("init middlewares success.");
    }

    void preProcess(AskParam askParam){
        for (DialogueMiddleware middleware:middlewares){
            middleware.preProcess();
        }
    }


    void afterProcess(AskParam askParam){
        for (DialogueMiddleware middleware:middlewares){
            middleware.afterProcess();
        }
    }
}
