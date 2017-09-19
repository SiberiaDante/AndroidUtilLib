package com.siberiadante.custom.http;

import com.siberiadante.custom.constant.Constants;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/8
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

class Params {

    static RequestBody getLoginParams(String username, String psd) {
        HashMap<String, String> map = new HashMap<>();
        map.put("access_token", Constants.ACCESS_TOKEN);
        map.put("method", Constants.METHOD_POST);
        map.put("username", username);
        map.put("password", psd);
        map.put("type", "mobile");
        return paramsData(map);
    }

    static RequestBody paramsData(HashMap<String, String> map) {
        return RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), map.toString());
    }


}
