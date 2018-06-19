package com.yuzhihao.myplatform.bot.core.middleware.after;

import com.yuzhihao.myplatform.bot.core.middleware.DialogueMiddleware;

/**
 * 评分与结果筛选
 */
public class ScoreRankMiddleware extends DialogueMiddleware{

    @Override
    protected void preProcessing() {

    }

    @Override
    protected void afterProcessing() {
        // 根据规则进行评分，对结果进行筛选
    }
}
