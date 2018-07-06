package com.yuzhihao.myplatform.bot.core.executor;

import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

/**
 * 问答流程执行 基类
 *
 * @author yuzhihao
 * @date 2018/06/06
 */
public class DefautExecutor implements Executor{

    public DefautExecutor(){

    }

    @Override
    public void setUp(Map<String,Object> params) {

    }

    @Override
    public void execute(DialogContext context){

        //entity识别结果

        //intent识别结果

        //答案生成 TODO
    }
}
