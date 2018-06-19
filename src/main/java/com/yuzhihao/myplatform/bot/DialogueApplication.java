package com.yuzhihao.myplatform.bot;

import com.yuzhihao.myplatform.bot.core.DialogueManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DialogueApplication  {
    public static void main(String[] args){
        SpringApplication.run(DialogueApplication.class,args);

    }

    @Bean
    public DialogueManager getDialogueManager(){
        return new DialogueManager();
    }
}
