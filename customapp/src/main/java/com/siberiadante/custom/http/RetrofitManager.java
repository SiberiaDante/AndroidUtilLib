package com.siberiadante.custom.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.siberiadante.custom.constant.AppConfig;
import com.siberiadante.custom.constant.Constants;
import com.siberiadante.custom.http.interceptor.RsqCheckInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class RetrofitManager {
    private static RetrofitManager mRetrofitManager;
    private Retrofit mRetrofit;

    public RetrofitManager() {
        initRetrofit();
    }


    public static synchronized RetrofitManager getInstance() {
        if (null == mRetrofitManager) {
            mRetrofitManager = new RetrofitManager();
        }
        return mRetrofitManager;
    }


    private void initRetrofit() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new RsqCheckInterceptor());//添加检查拦截器
        if (AppConfig.isDebug) {
            //添加Retrofit打日志
            builder.addInterceptor(httpLoggingInterceptor);
        }
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        final OkHttpClient client = builder.build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

    }

    public <T> T createReq(Class<T> req) {
        return mRetrofit.create(req);
    }

}
