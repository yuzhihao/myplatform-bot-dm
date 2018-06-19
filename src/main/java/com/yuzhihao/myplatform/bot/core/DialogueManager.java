package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.executor.DefautExecutor;
import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.*;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import com.yuzhihao.myplatform.bot.core.pojo.results.TransitionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 对话管理类
 *
 * @author yuzhihao
 */

@Service
public class DialogueManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueManager.class);

    private MiddlewareManager middlewareManager;

    private Map<Long,Bot> botMap;

    private Map<Long,StateNode> nodeMap;

    public DialogueManager(){
        // 初始化 所有 bot
        LOGGER.info("init bots");
        // 初始化 所有 scene
        LOGGER.info("init scenes");
        // 初始化 所有相关 stateNodes
        LOGGER.info("init stateNodes");
        // 初始化 middlewareManager
        LOGGER.info("init middlewareManagers");
        // 初始化 所有 Executor
        LOGGER.info("init executors");
    }


    public AnswerInfo ask(AskParam askParam){
        //预处理
        middlewareManager.preProcess(askParam);
        //节点逻辑
        message();
        //后处理
        middlewareManager.afterProcess(askParam);
        //返回结果
        return (AnswerInfo) DMThreadContext.getInstance().get(DMThreadContextEnum.ANSWER_INFO);
    }

    private void message(){
        StateNode state = (StateNode) DMThreadContext.getInstance().get(DMThreadContextEnum.STATE_NODE_CURRENT);
        DialogueContext context = (DialogueContext) DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT);
        // 跳转节点状态并返回此轮最终节点
        TransitionResult stepResult = step(context,state);
        // 执行节点
        AnswerInfo answerInfo = executeNode(stepResult.getNode());
        DMThreadContext.getInstance().set(DMThreadContextEnum.ANSWER_INFO, answerInfo);
    }

    /**
     *
     * @param context
     * @param state
     * @return
     */
    public TransitionResult step(DialogueContext context, StateNode state){
        // 先判断上层节点是否有满足条件的跳转
        for(Transition transition:state.getTransitions()){
            if(transition.acceptAllConditions(context)){
                StateNode toNode = transition.getTo();
                return step(context, toNode);
            }
        }
        // 上层没得跳转后找下层节点
        if(!state.isLeaf()){
            return step(context, state.getSub());
        }
        // 最终找到叶子节点
        return new TransitionResult(state);
    }

    /**
     * 执行节点
     * @param node
     * @return
     */
    public AnswerInfo executeNode(StateNode node){
        /*DefautExecutor executor = null;
        switch(node.getExecuteType()){
            case FAQ:
                executor = new DefautExecutor();
                break;
            case KBQA:
                break;
            default:
                break;
        }*/
        for (Executor executor: node.getExecutors()){
            executor.execute();
        }
        // 获取执行结果
        return new AnswerInfo();
        //return executor.execute();
    }
}
