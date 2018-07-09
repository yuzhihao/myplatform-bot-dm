package com.yuzhihao.myplatform.bot.core.client.redis;

import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    /**
     * 单机版配置
     * @return
     */
    @Bean
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory(){
        return  new JedisConnectionFactory(getRedisConfig());
    }

    @Bean
    public RedisTemplate redisTemplate() {
        JedisConnectionFactory factory = jedisConnectionFactory();
        RedisTemplate  template = new StringRedisTemplate(factory);
        return template;
    }
}
