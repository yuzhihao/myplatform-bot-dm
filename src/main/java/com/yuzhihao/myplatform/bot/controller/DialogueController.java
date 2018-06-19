package com.yuzhihao.myplatform.bot.controller;

import com.yuzhihao.myPlatform.common.dataModel.ApiResponseBody;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import com.yuzhihao.myplatform.bot.service.DialogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dialogue")
public class DialogueController  {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueController.class);

    @Autowired
    private DialogueService dialogueService;

    public ApiResponseBody ask(@RequestParam AskParam askParam){
        AnswerInfo answerInfo = dialogueService.ask(askParam);
        return new ApiResponseBody(answerInfo);
    }
}
