package com.yuzhihao.myplatform.bot.core.interfaces;

/**
 * 中间件 interface
 * 包含事前事后两个处理方法
 *
 * @author yuzhihao
 */
public interface Middleware {

    void preProcess();

    void afterProcess();
}
