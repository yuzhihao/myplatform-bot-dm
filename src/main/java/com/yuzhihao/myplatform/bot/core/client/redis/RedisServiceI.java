package com.yuzhihao.myplatform.bot.core.client.redis;

public interface RedisServiceI {
    void set(String key,String value);
    String get(String key);
}
