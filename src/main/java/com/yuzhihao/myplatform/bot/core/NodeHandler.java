package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.*;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.results.TransitionResult;

import java.util.Map;

/**
 * 节点处理类
 */
public class NodeHandler {

    private Map<Long,Bot> botMap;

    private Map<Long,StateNode> nodeMap;

    public void initNodesTransition(Map<Long,Scene> sceneMap, Map<Long,StateNode> nodeMap){

    }

    /**
     * 节点跳转
     * @param context
     * @param state
     * @return
     */
    public TransitionResult step(final DialogContext context, StateNode state){
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
    public AnswerInfo executeNode(StateNode node, DialogContext context){
        for (Executor executor: node.getExecutors()){
            executor.execute(context);
        }
        if (node.isPark()){
            // 设置 currentNode TODO
        }
        // 获取执行结果
        return new AnswerInfo();
        //return executor.execute();
    }
}
