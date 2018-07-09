package com.yuzhihao.myplatform.bot.core.executor;

import com.yuzhihao.myplatform.bot.core.interfaces.Executor;
import com.yuzhihao.myplatform.bot.core.pojo.DialogContext;

import java.util.Map;

/**
 * 执行器：Slot填充
 */
public class SlotFillingExecutor implements Executor {
    @Override
    public void setUp(Map<String,Object> params) {

    }

    @Override
    public void execute(DialogContext context) {
        // 填充slot
    }
}
