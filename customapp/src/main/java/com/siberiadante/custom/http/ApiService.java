package com.siberiadante.custom.http;

import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.NewsData;
import com.siberiadante.custom.bean.QuestionData;
import com.siberiadante.custom.bean.base.WrapResult;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("api/question_list")
    Observable<WrapResult<List<QuestionData>>> questionApi(@Field("access_token") String access_token, @Field("method") String method);

    @FormUrlEncoded
    @POST("api/news")
    Observable<WrapResult<List<NewsData>>> newsApi(@Field("access_token") String access_token,
                                                   @Field("method") String method,
                                                   @Field("page") String page,
                                                   @Field("count") String count);

    @FormUrlEncoded
    @POST("api/authorization")
    Observable<WrapResult<LoginResponse>> getLoginApi(@FieldMap Map<String, String> map);

    @POST("api/authorization")
    Observable<WrapResult<LoginResponse>> getLoginApiB(@Body RequestBody body);
}
