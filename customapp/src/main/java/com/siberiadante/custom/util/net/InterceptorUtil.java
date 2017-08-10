package com.siberiadante.custom.util.net;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/1
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class InterceptorUtil {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public static String getRspData(ResponseBody responseBody) throws Exception {
        final long contentLength = responseBody.contentLength();
        final BufferedSource source = responseBody.source();
        source.request(Long.MAX_VALUE);//Buffer the entire body.
        final Buffer buffer = source.buffer();
        Charset charset = UTF8;
        final MediaType contentType = responseBody.contentType();
        if (null != contentType) {
            charset = contentType.charset(UTF8);

        }
        if (contentLength != 0) {
            return new JSONObject(buffer.clone().readString(charset)).toString();  //because response content contain quotation mark
        }
        return null;
    }

    public static String getReqData(RequestBody requestBody) throws IOException {
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return buffer.readString(UTF8);
    }

    public static Response changeRspData(Response response, String rspData) {
        MediaType contentType = response.body().contentType();
        ResponseBody body = ResponseBody.create(contentType, rspData);
        return response.newBuilder().body(body).build();
    }
}
