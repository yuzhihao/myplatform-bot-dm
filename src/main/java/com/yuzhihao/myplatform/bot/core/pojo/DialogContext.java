package com.yuzhihao.myplatform.bot.core.pojo;

import com.yuzhihao.myplatform.bot.core.pojo.results.EntityResult;
import com.yuzhihao.myplatform.bot.core.pojo.results.IntentResult;
import com.yuzhihao.myplatform.bot.core.pojo.results.NLUResult;

import java.io.Serializable;
import java.util.List;

/**
 * 对话上下文对象
 * @author yuzhihao
 */
public class DialogContext implements Serializable{
    private List<Question> questionList;
    private NLUResult nluResult;
    private EntityResult entityResult;
    private IntentResult intentResult;

    public NLUResult getNluResult() {
        return nluResult;
    }

    public void setNluResult(NLUResult nluResult) {
        this.nluResult = nluResult;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public IntentResult getIntentResult() {
        return intentResult;
    }

    public void setIntentResult(IntentResult intentResult) {
        this.intentResult = intentResult;
    }

    public EntityResult getEntityResult() {
        return entityResult;
    }

    public void setEntityResult(EntityResult entityResult) {
        this.entityResult = entityResult;
    }
}
