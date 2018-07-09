package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.pojo.*;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import com.yuzhihao.myplatform.bot.core.pojo.results.TransitionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * 对话管理类
 *
 * @author yuzhihao
 */


public class DialogueManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueManager.class);

    private MiddlewareManager middlewareManager;

    private NodeHandler nodeHandler = new NodeHandler();

    private Map<Long,Bot> botMap;

    private Map<Long,StateNode> nodeMap;

    private Map<Long,Scene> sceneMap;

    /**
     * 从本地json文件加载机器人
     */
    public void initFromLocal(){
        /*String botJson = ConfigLoader.loadJsonFromFile("dialogue/target/classes/json_template/bot.json");
        for (Bot bot: JacksonUtils.toList(botJson,Bot.class)){
            (botMap = new HashMap<Long,Bot>()).put(bot.getId(),bot);
        }
        String sceneJson = ConfigLoader.loadJsonFromFile("dialogue/target/classes/json_template/scene.json");
        for (Scene scene: JacksonUtils.toList(sceneJson,Scene.class)){
            (sceneMap =  new HashMap<Long,Scene>()).put(scene.getId(),scene);
        }
        String nodeJson = ConfigLoader.loadJsonFromFile("dialogue/target/classes/json_template/stateNode.json");
        for (StateNode node:JacksonUtils.toList(nodeJson,StateNode.class)){
            (nodeMap = new HashMap<Long,StateNode>()).put(node.getId(),node);
        }*/
    }
    
    public DialogueManager(){
        LOGGER.info("从本地json初始化配置");
        initFromLocal();
        nodeHandler = new NodeHandler();
        LOGGER.info("初始化 节点跳转关系");
        nodeHandler.initNodesTransition(sceneMap,nodeMap);
        LOGGER.info("初始化 中间件");
        middlewareManager = new MiddlewareManager();
    }


    /**
     * 入口
     * @param askParam
     * @return
     */
    public AnswerInfo ask(AskParam askParam, Session session){
        //输入参数处理
        handleInput(askParam, session);
        //预处理
        middlewareManager.preProcess(askParam);
        //节点逻辑
        nodeProcess();
        //后处理
        middlewareManager.afterProcess(askParam);
        //session.setDialogContext((DialogContext) DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT));
        //返回结果
        return (AnswerInfo) DMThreadContext.getInstance().get(DMThreadContextEnum.ANSWER_INFO);
    }
    public void nodeProcess(){
        StateNode state = (StateNode) DMThreadContext.getInstance().get(DMThreadContextEnum.STATE_NODE_CURRENT);
        DialogContext context = (DialogContext) DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT);
        // 跳转节点状态并返回此轮最终节点
        TransitionResult stepResult = nodeHandler.step(context,state);
        // 执行节点
        AnswerInfo answerInfo = nodeHandler.executeNode(stepResult.getNode(),context);
        DMThreadContext.getInstance().set(DMThreadContextEnum.ANSWER_INFO, answerInfo);
    }

    /**
     * 输入参数处理
     * @param askParam
     */
    public void handleInput(AskParam askParam, Session session){
        DMThreadContext threadCxt = DMThreadContext.getInstance();
        threadCxt.set(DMThreadContextEnum.SESSION_ID,askParam.getSessionId());
        threadCxt.set(DMThreadContextEnum.USER_ID,askParam.getUserId());
        threadCxt.set(DMThreadContextEnum.QUESTION,askParam.getQuestion());
        threadCxt.set(DMThreadContextEnum.CONTEXT, session.getDialogContext());
        threadCxt.set(DMThreadContextEnum.BOT,botMap.get(askParam.getBotId()));
    };




}
