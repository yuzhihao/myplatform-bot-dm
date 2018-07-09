package com.yuzhihao.myplatform.bot.core.utils;

import com.yuzhihao.myPlatform.common.dataModel.ApiResponseBody;

public class ApiUtils {

    public static ApiResponseBody responseError(Exception e){
        return new ApiResponseBody(e);
    }
}
