package com.yuzhihao.myplatform.bot.core.utils;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.yuzhihao.myplatform.bot.core.interfaces.Executor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;

public class ConfigLoader {


   /**
     * 指定路径加载本地json文件
     * @param path
     * @return
     */
    public static String loadJsonFromFile(String path){
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String s = null;
            while((s =reader.readLine())!=null){
                sb.append(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Executor getExecutorByName(String classname){
        Executor executor = null;
        try {
            Class clazz = Class.forName(classname);
            Constructor constructor = clazz.getConstructor();
            executor = (Executor) clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executor;
    }


    //public static MiddlewareManager initMiddlewareManager(){return null;}
}
