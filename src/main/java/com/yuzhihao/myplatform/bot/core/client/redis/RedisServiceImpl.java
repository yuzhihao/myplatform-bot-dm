package com.yuzhihao.myplatform.bot.core.client.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisServiceI{

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(final String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(final String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }



}
