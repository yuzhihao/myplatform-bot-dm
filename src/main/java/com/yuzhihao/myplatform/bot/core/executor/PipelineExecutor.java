package com.yuzhihao.myplatform.bot.core.executor;

import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

public class PipelineExecutor extends DefautExecutor{

    public void initPipeline(String jsonConfig){
        // 通过json配置, 初始化自定义流程
    }

    public AnswerInfo pipeline(){
        return new AnswerInfo();
    }

    @Override
    public void execute(DialogContext context){
        pipeline();
    }
}
