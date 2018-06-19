package com.yuzhihao.myplatform.bot.core.pojo.results;

import com.yuzhihao.myplatform.bot.core.pojo.StateNode;

public  class TransitionResult {
    private double score;
    private StateNode node;

    public TransitionResult(StateNode n){
        this(n,1);
    }

    public TransitionResult(StateNode n, double s){
        this.score = s;
        this.node = n;
    }

    public StateNode getNode() {
        return node;
    }

    public void setNode(StateNode node) {
        this.node = node;
    }
}