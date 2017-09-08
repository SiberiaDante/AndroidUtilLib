package com.siberiadante.custom.http.manager;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class NetException {


    public static class ResponseThrowable extends Exception {
        public int code;
        public String message;

        public ResponseThrowable(Throwable cause) {
            super(cause);
        }

        public ResponseThrowable(Throwable throwable, int code) {
            super(throwable);
            this.code = code;

        }
    }


    /*
    异常处理
     */
    public static ResponseThrowable throwable(Throwable e) {
        ResponseThrowable ex = null;
        if (e instanceof HttpException) {

            return ex;
        } else {
            return ex;
        }
    }

    /**
     * 约定异常
     */
    class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = 1006;

        /**
         * 证书未找到
         */
        public static final int SSL_NOT_FOUND = 1007;

        public static final int RUNTIME = 2017;

    }
}
