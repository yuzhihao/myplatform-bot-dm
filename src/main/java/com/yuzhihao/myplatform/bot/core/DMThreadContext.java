package com.yuzhihao.myplatform.bot.core;

import com.yuzhihao.myplatform.bot.core.pojo.enums.DMThreadContextEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程共享变量context 访问单例类
 */
public class DMThreadContext {
    private static final Logger LOGGER = LoggerFactory.getLogger(DMThreadContext.class);

    private static volatile DMThreadContext instance;

    private static final ThreadLocal<Map<DMThreadContextEnum,Object>> context =
            ThreadLocal.withInitial(() -> new HashMap<DMThreadContextEnum,Object>());

    public static DMThreadContext getInstance(){
        DMThreadContext result = DMThreadContext.instance;
        if (result==null){
            synchronized (DMThreadContext.class){
                result = DMThreadContext.instance;
                if (result == null){
                    result = (DMThreadContext.instance = new DMThreadContext());
                }
            }
        }
        return result;
    }

    public Object get(final DMThreadContextEnum key){
        return DMThreadContext.context.get().get(key);
    }

    public void set(final DMThreadContextEnum key, final Object value){
        if (value!=null){
            DMThreadContext.context.get().put(key,value);
        }
    }
}
