package com.yuzhihao.myplatform.bot.core.pojo;

import java.util.List;

/**
 * 机器人pojo类
 *
 * @author yuzhihao
 * @date 20180606
 */
public class Bot {
    private Long id;
    private String name;
    private List<Scene> scenes;

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

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
