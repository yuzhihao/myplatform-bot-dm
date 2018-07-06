package com.yuzhihao.myplatform.bot.core.pojo;

import com.yuzhihao.myplatform.bot.core.interfaces.Condition;

import java.util.List;

public class Transition {

    private List<Condition> conditions;
    private StateNode to;

    public StateNode getTo(){
        return this.to;
    }

    public boolean acceptAllConditions(DialogContext context){
        for(Condition condition: conditions){
            if(!condition.accept(context)){
                return false;
            }
        }
        return true;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setTo(StateNode to) {
        this.to = to;
    }
}
