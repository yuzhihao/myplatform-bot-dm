package com.yuzhihao.myplatform.bot.service;

import com.yuzhihao.myplatform.bot.core.DialogueManager;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueService.class);

    @Autowired
    private DialogueManager dialogueManager;

    public AnswerInfo ask(AskParam askParam){

        return new AnswerInfo();
    }

}
