package com.siberiadante.custom.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.siberiadante.custom.bean.base.WrapResult;
import com.siberiadante.custom.constant.AppConfig;
import com.siberiadante.custom.constant.Constants;
import com.siberiadante.custom.http.manager.NetException;
import com.siberiadante.lib.util.SDStringUtil;
import com.siberiadante.lib.util.SDToast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
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
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (AppConfig.isDebug) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel((HttpLoggingInterceptor.Level.NONE));
        }
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new RsqCheckInterceptor());//添加检查拦截器
        if (AppConfig.isDebug) {
            //添加Retrofit打日志
            builder.addInterceptor(interceptor);
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


    /**
     * 线程切换,错误反馈
     *
     * @param <T>
     * @return
     */
    public <T> ObservableTransformer<T, T> BaseTransformer() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .filter(new Predicate<T>() {
                            @Override
                            public boolean test(@NonNull T t) throws Exception {
                                if (((WrapResult) t).getCode() != 200) {
                                    final String errorMsg = ((WrapResult) t).getInfo();
                                    if (SDStringUtil.isEmpty(errorMsg)) {
                                        SDToast.toast("服务器内部错误");
                                    } else {
                                        SDToast.toast(errorMsg);
                                    }
                                }
                                return ((WrapResult) t).getCode() == 200;
                            }
                        }).onErrorResumeNext(new HttpResponseFunc<T>())
                        ;
            }
        };
    }

    /**
     * 将Throwable转化为ResponseThrowable
     *
     * @param <T>
     */
    private class HttpResponseFunc<T> implements Function<Throwable, Observable<T>> {
        @Override
        public Observable<T> apply(@NonNull Throwable throwable) throws Exception {

            return Observable.error(NetException.throwable(throwable));
        }
    }
}
