package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.conditions.IntentNotNullCondition;
import com.yuzhihao.myplatform.bot.core.executor.AskbackExecutor;
import com.yuzhihao.myplatform.bot.core.executor.DefautExecutor;
import com.yuzhihao.myplatform.bot.core.interfaces.Condition;
import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.*;
import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import com.yuzhihao.myplatform.bot.core.pojo.param.AskParam;
import com.yuzhihao.myplatform.bot.core.pojo.results.TransitionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 对话管理类
 *
 * @author yuzhihao
 */


public class DialogueManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueManager.class);

    private MiddlewareManager middlewareManager;

    private Map<Long,Bot> botMap;

    private Map<Long,StateNode> nodeMap;

    public void test_init(){
        botMap = new HashMap<Long,Bot>();
        Bot bot = new Bot();
        Scene scene = new Scene();
        bot.setId(1L);
        bot.setName("cmb");
        List<Scene> scenes = new ArrayList();
        bot.setScenes(new LinkedList<>());
        botMap.put(1L,new Bot());

        Bot botModel = new Bot();
        botModel.setId(1L);
        botModel.setName("cmb");
        Scene sceneModel = new Scene();
        sceneModel.setId(1L);
        sceneModel.setBotId(1L);
        sceneModel.setName("assurance");
        StateNode s1 = new StateNode();
        s1.setId(1L);
        s1.setBotId(1L);
        s1.setSceneId(1L);
        s1.setName("ambigugous");
        s1.setInital(true);
        StateNode s2 = new StateNode();
        s2.setId(2L);
        s2.setBotId(1L);
        s2.setSceneId(1L);
        s2.setName("distinct");

        Transition s1s2 = new Transition();
        Condition s1s2condi = new IntentNotNullCondition();
        List<Condition> condis = new ArrayList();
        condis.add(s1s2condi);
        s1s2.setConditions(condis);
        s1s2.setTo(s2);
        List<Transition> trans = new ArrayList();
        trans.add(s1s2);
        s1.setTransitions(trans);

        List<Executor> executors1 = new ArrayList();
        executors1.add(new AskbackExecutor());
        s1.setExecutors(executors1);
        List<Executor> executors2 = new ArrayList();
        executors2.add(new DefautExecutor());
        s2.setExecutors(executors2);


    }

    /**
     * 从本地json文件加载机器人
     */
    public void initFromLocal(){
        String botJson = ConfigLoader.loadJsonFromFile("dialogue/target/classes/json_template/bot.json");
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
        }
    }
    
    public DialogueManager(){
        // 初始化 所有 bot
        LOGGER.info("init bots");
        // 初始化 所有 scene
        LOGGER.info("init scenes");
        // 初始化 所有相关 stateNodes
        LOGGER.info("init stateNodes");
        // 初始化 middlewareManager
        LOGGER.info("init middlewareManagers");
        middlewareManager = new MiddlewareManager();
        // 初始化 所有 Executor
        LOGGER.info("init executors");
        // 测试
        test_init();
    }

    public AnswerInfo ask(AskParam askParam){
        //预处理
        middlewareManager.preProcess(askParam);
        //节点逻辑
        nodeProcess();
        //后处理
        middlewareManager.afterProcess(askParam);
        //返回结果
        return (AnswerInfo) DMThreadContext.getInstance().get(DMThreadContextEnum.ANSWER_INFO);
    }

    private void nodeProcess(){
        StateNode state = (StateNode) DMThreadContext.getInstance().get(DMThreadContextEnum.STATE_NODE_CURRENT);
        DialogContext context = (DialogContext) DMThreadContext.getInstance().get(DMThreadContextEnum.CONTEXT);
        // 跳转节点状态并返回此轮最终节点
        TransitionResult stepResult = step(context,state);
        // 执行节点
        AnswerInfo answerInfo = executeNode(stepResult.getNode(),context);
        DMThreadContext.getInstance().set(DMThreadContextEnum.ANSWER_INFO, answerInfo);
    }

    /**
     *
     * @param context
     * @param state
     * @return
     */
    public TransitionResult step(DialogContext context, StateNode state){
        // 先判断上层节点是否有满足条件的跳转
        for(Transition transition:state.getTransitions()){
            if(transition.acceptAllConditions(context)){
                StateNode toNode = transition.getTo();
                return step(context, toNode);
            }
        }
        // 上层没得跳转后找下层节点
        if(!state.isLeaf()){
            return step(context, state.getSub());
        }
        // 最终找到叶子节点
        return new TransitionResult(state);
    }

    /**
     * 执行节点
     * @param node
     * @return
     */
    public AnswerInfo executeNode(StateNode node, DialogContext context){
        for (Executor executor: node.getExecutors()){
            executor.execute(context);
        }
        if (node.isPark()){
            // 设置 currentNode TODO
        }
        // 获取执行结果
        return new AnswerInfo();
        //return executor.execute();
    }
}
