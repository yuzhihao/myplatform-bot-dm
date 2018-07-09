package com.yuzhihao.myplatform.bot.service;

import com.yuzhihao.myPlatform.common.utils.JacksonUtils;
import com.yuzhihao.myplatform.bot.core.DMThreadContext;
import com.yuzhihao.myplatform.bot.core.DialogueManager;
import com.yuzhihao.myplatform.bot.core.client.redis.RedisServiceImpl;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import com.yuzhihao.myplatform.bot.core.pojo.Session;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DialogueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueService.class);

    @Autowired
    private DialogueManager dialogueManager;

    @Autowired
    private RedisServiceImpl redisService;

    public AnswerInfo ask(AskParam askParam){
        // Param check
        askParam.checkParam();
        // Get session by id or new
        Session session = Optional.ofNullable(loadSession(askParam.getBotId(),
                askParam.getSessionId())).orElse(new Session());
        askParam.setSessionId(String.valueOf(session.getId()));
        // dialog
        AnswerInfo answerInfo = dialogueManager.ask(askParam, session);
        // save session
        saveSession(askParam.getBotId(), askParam.getSessionId(), session);
        return answerInfo;
    }

    /**
     * 从缓存中加载 session
     * @param sessionId
     * @return
     */
    public Session loadSession(String botId, String sessionId){
        Session session = JacksonUtils.toPojo(redisService.get(
                String.format("bot:%s:session:%s", botId, sessionId)), Session.class);
        return session;
    }

    /**
     * 更新session到缓存
     * @param session
     */
    public void saveSession(String botId, String sessionId, Session session){
        redisService.set(String.format("bot:%s:session:%s", botId, sessionId),JacksonUtils.toJsonStr(session));
    }

}
