package com.siberiadante.utilsample.http;


import com.siberiadante.utilsample.activity.practice.mvp.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * CreateTime: 2018/6/4
 * UpDateTime:
 * Describe:
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> getLoginApi(@Field("username") String username,
                                      @Field("password") String password);
}