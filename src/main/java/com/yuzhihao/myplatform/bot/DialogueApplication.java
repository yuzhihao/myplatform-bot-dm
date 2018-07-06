package com.yuzhihao.myplatform.bot;

import com.yuzhihao.myplatform.bot.core.DialogueManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
@EnableMongoRepositories
public class DialogueApplication  {
    public static void main(String[] args){
        SpringApplication.run(DialogueApplication.class,args);

    }

    @Bean
    public DialogueManager dialogueManager(){
        return new DialogueManager();
    }
}
