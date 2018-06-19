package com.yuzhihao.myplatform.bot.core.pojo;

import com.yuzhihao.myplatform.bot.core.executor.DefautExecutor;
import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.enums.ExecuteTypeEnum;

import java.util.List;

/**
 * 状态节点
 * @author yuzhihao
 */
public class StateNode {
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 所属bot id
     */
    private Long botId;
    /**
     * 所属场景id
     */
    private Long sceneId;
    /**
     * 子节点
     */
    private StateNode child;
    /**
     * 节点类型
     */
    private ExecuteTypeEnum executeType;
    /**
     * 执行器
     */
    private List<Executor> executors;
    /**
     * 深度
     */
    private int depth;
    /**
     * 是否跳转过
     */
    private boolean jumped = false;

    private List<Transition> transitions;

    public List<Transition> getTransitions() {
        return transitions;
    }

    public StateNode getSub() {
        return this.child;
    }

    public boolean isLeaf(){
        return this.child == null;
    }

    public void executeNode(){
        //TODO 执行相关操作，比如回答用户

    }


    public ExecuteTypeEnum getExecuteType() {
        return executeType;
    }

    public void setExecuteType(ExecuteTypeEnum executeType) {
        this.executeType = executeType;
    }

    public List<Executor> getExecutors() {
        return executors;
    }

    public void setExecutors(List<Executor> executors) {
        this.executors = executors;
    }
}
