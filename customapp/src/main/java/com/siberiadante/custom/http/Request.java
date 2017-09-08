package com.siberiadante.custom.http;

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
        return new Request();
    }

    public Observable<WrapResult<List<NewsData>>> getNewsData(int page, int count) {
        RequestBody requestBody = Params.getNews(page, count);
        return apiService.newsApiT(requestBody).compose(transformer);
    }
}
