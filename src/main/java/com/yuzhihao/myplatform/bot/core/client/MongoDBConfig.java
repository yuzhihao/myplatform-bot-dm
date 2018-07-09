package com.yuzhihao.myplatform.bot.core.client;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient(){
        return new MongoClient();
    }

    @Bean
    public MongoDbFactory mongoDbFactory(){
        return new SimpleMongoDbFactory(mongoClient(),"bot");
    }

    @Bean
    public MongoTemplate botMongoTemplate(){
        return new MongoTemplate(mongoDbFactory());
    }
}
