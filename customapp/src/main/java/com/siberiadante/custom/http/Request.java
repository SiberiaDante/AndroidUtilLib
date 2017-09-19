package com.siberiadante.custom.http;

import com.siberiadante.custom.bean.LoginResponse;
import com.siberiadante.custom.bean.NewsData;
import com.siberiadante.custom.bean.base.WrapResult;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class Request {
    private static ApiService apiService = RetrofitManager.getInstance().createReq(ApiService.class);
    private ObservableTransformer transformer = RetrofitManager.getInstance().BaseTransformer();

    public static Request getInstance() {
        return RequestHolder.request;
    }

    private static class RequestHolder {
        private static final Request request = new Request();
    }

    public Observable<WrapResult<LoginResponse>> getLoginParams(String username, String psd) {
        RequestBody requestBody = Params.getLoginParams(username, psd);
        return apiService.getLoginApiB(requestBody).compose(transformer);
    }

}
