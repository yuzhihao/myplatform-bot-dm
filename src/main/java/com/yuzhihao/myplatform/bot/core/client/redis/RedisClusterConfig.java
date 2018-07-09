package com.yuzhihao.myplatform.bot.core.client.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.lang.Nullable;

@Configuration
public class RedisClusterConfig {

    //private JedisCluster jedisCluster;
    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new RedisConnectionFactory() {
            @Nullable
            @Override
            public DataAccessException translateExceptionIfPossible(RuntimeException e) {
                return null;
            }

            @Override
            public RedisConnection getConnection() {
                return null;
            }

            @Override
            public RedisClusterConnection getClusterConnection() {
                return null;
            }

            @Override
            public boolean getConvertPipelineAndTxResults() {
                return false;
            }

            @Override
            public RedisSentinelConnection getSentinelConnection() {
                return null;
            }
        };
    }
}
