package com.yuzhihao.myplatform.bot;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan()
public class DialogueApplicationConfig  {
    private static final Logger LOGGER = LoggerFactory.getLogger(DialogueApplicationConfig.class);

    /**
     * 全局缓存方案
     * @param preload
     * @return
     */
    @Bean
    public Cache<String, Object> localCache(@Value("${server.dm.preload:}") final String[] preload){
        final Cache<String,Object> cache = CacheBuilder.newBuilder().maximumSize(100L).build();
        for (final String botName : preload){
            //根据botName 初始化
        }
        return cache;
    }


}
