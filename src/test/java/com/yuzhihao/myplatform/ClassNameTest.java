package com.yuzhihao.myplatform;

import com.yuzhihao.myplatform.bot.core.middleware.pre.DomainRecgonizeMiddleware;

public class ClassNameTest {

    public static void main(String [] args){
        DomainRecgonizeMiddleware domainRecgonizeMiddleware = new DomainRecgonizeMiddleware();
        domainRecgonizeMiddleware.getBotMiddlewareConfig();
    }
}
