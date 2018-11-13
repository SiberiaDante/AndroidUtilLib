package com.siberiadante.utilsample.http;

import java.util.HashMap;

/**
 * create date: 2018/8/1
 */
public class Params {


    public static HashMap<String, String> getDealAnswerParams(String forum_id, String content_id, String from_uid, String type) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("forum_id", forum_id);
        hashMap.put("content_id", content_id);
        hashMap.put("from_uid", from_uid);
        hashMap.put("type", type);
        return hashMap;
    }


}
