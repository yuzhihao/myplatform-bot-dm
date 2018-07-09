package com.yuzhihao.myplatform.bot.db.model;

public class BotModel {
    private Long id;
    private String name;

    public BotModel(){}

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
}
