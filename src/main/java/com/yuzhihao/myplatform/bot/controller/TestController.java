package com.yuzhihao.myplatform.bot.controller;

import com.yuzhihao.myPlatform.common.dataModel.ApiResponseBody;
import com.yuzhihao.myPlatform.common.utils.JacksonUtils;
import com.yuzhihao.myplatform.bot.core.client.redis.RedisServiceImpl;
import com.yuzhihao.myplatform.bot.core.pojo.AnswerInfo;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import com.yuzhihao.myplatform.bot.core.pojo.results.NLUResult;
import com.yuzhihao.myplatform.bot.core.utils.ApiUtils;
import com.yuzhihao.myplatform.bot.db.model.BotModel;
import com.yuzhihao.myplatform.bot.db.model.SceneModel;
import com.yuzhihao.myplatform.bot.db.model.StateNodeModel;
import com.yuzhihao.myplatform.bot.service.DialogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 方便测试的controler
 */
@RestController
@RequestMapping("test")
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueController.class);

    @Autowired
    private DialogueService dialogueService;

    @RequestMapping(value="/ask", method= RequestMethod.GET)
    public ApiResponseBody ask(){
        try{
            AskParam askParam = new AskParam();
            askParam.setQuestion("您好");
            askParam.setSessionId("");
            AnswerInfo answerInfo = dialogueService.ask(askParam);
            return new ApiResponseBody(answerInfo);
        }
        catch (Exception e){
            return ApiUtils.responseError(e);
        }
    }

    @Autowired
    MongoTemplate botMongoTemplate;

    @RequestMapping(value="/mongo", method= RequestMethod.GET)
    public ApiResponseBody mongo(){
        try{
            BotModel botModel = new BotModel();
            botModel.setId(1L);
            botModel.setName("cmb");
            SceneModel sceneModel = new SceneModel();
            sceneModel.setId(1L);
            sceneModel.setBotId(1L);
            sceneModel.setName("assurance");
            StateNodeModel s1 = new StateNodeModel();
            s1.setId(1L);
            s1.setBotId(1L);
            s1.setSceneId(1L);
            s1.setName("ambigugous");
            StateNodeModel s2 = new StateNodeModel();
            s2.setId(2L);
            s2.setBotId(1L);
            s2.setSceneId(1L);
            s2.setName("distinct");

            botMongoTemplate.insert(botModel);
            botMongoTemplate.insert(sceneModel);
            List<BotModel> result = botMongoTemplate.findAll(BotModel.class);
            return new ApiResponseBody(result);
        }
        catch (Exception e){
            return ApiUtils.responseError(e);
        }
    }


    @Autowired
    RedisServiceImpl redisService;

    @RequestMapping(value="/redis", method= RequestMethod.GET)
    public ApiResponseBody redis(){
        try{
            DialogContext context = new DialogContext();
            NLUResult nlu = new NLUResult();
            context.setNluResult(nlu);
            redisService.set("yuzhihao-test", JacksonUtils.toJsonStr(context));
            DialogContext result = JacksonUtils.toPojo(redisService.get("yuzhihao-test"),DialogContext.class);

            return new ApiResponseBody(result);
        }
        catch (Exception e){
            LOGGER.error("redis test error:",e);
            return ApiUtils.responseError(e);
        }
    }

}
