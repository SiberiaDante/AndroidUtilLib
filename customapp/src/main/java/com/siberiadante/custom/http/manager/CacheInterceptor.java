package com.siberiadante.custom.http.manager;

import com.siberiadante.lib.util.SDNetWorkUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class CacheInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        int maxAge = 60 * 60; // 有网络时 设置缓存超时时间1小时
        int maxStale = 60 * 60 * 24 * 28; // 无网络时，设置超时为4周
        Request request = chain.request();
        if (SDNetWorkUtil.isNetWorkConnected()) {
            request = request.newBuilder()
                    .addHeader("HXM", "are_you_ok")
                    .cacheControl(CacheControl.FORCE_NETWORK)
                    .build();
        } else {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)//无网络时只从缓存中读取,仅当缓存存在时
                    .build();
        }

        Response response = chain.proceed(request);
        if (SDNetWorkUtil.isNetWorkConnected()) {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, max-age=" + maxAge)
                    .build();
        } else {
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
        return response;
    }

}
