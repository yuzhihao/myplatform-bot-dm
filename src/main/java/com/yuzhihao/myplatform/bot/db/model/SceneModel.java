package com.yuzhihao.myplatform.bot.db.model;

/**
 * Scene
 */
public class SceneModel extends BaseModel{
    private Long id;
    private String name;
    private Long botId;

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

    public Long getBotId() {
        return botId;
    }

    public void setBotId(Long botId) {
        this.botId = botId;
    }
}
