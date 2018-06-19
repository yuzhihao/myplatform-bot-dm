package com.yuzhihao.myplatform.bot.core.pojo;

import com.yuzhihao.myplatform.bot.core.interfaces.Condition;
import com.yuzhihao.myplatform.bot.core.pojo.StateNode;

import java.util.List;

public class Transition {

    List<Condition> conditions;
    StateNode to;

    public StateNode getTo(){
        return this.to;
    }

    public boolean acceptAllConditions(DialogueContext context){
        for(Condition condition: conditions){
            if(!condition.accept(context)){
                return false;
            }
        }
        return true;
    }
}
