package com.yuzhihao.myplatform.bot.core.pojo;

import java.util.List;

/**
 * 场景 保存场景下所有node的状态
 */
public class Scene {
    private Long id;
    private String name;
    private Long botId;

    private List<StateNode> nodes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StateNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<StateNode> nodes) {
        this.nodes = nodes;
    }

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }
}
