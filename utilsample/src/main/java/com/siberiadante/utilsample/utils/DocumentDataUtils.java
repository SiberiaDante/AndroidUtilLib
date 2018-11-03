package com.siberiadante.utilsample.utils;

import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.bean.document.DocumentList;

import java.util.ArrayList;
import java.util.List;

/**
 * create date: 2018/11/3
 */
public class DocumentDataUtils {
    private static List<DocumentList> documentLists = new ArrayList<>();

    static {
        buildDocumentData();
    }

    public static void buildDocumentData() {
        for (int i = 0; i < 100; i++) {
            documentLists.add(new DocumentList(i, "Test Document---" + i));
        }
        SDLogUtil.d("-----------" + documentLists.size());
    }


    public static List<DocumentList> getDocumentData(int page, int count) {
        List<DocumentList> mDocList = new ArrayList<>();
        //0-10    10-20
        //0-10  1-10
        for (int i = page * count; i < (page + 1) * count && i < 100; i++) {
            mDocList.add(documentLists.get(i));
        }
        SDLogUtil.d("-----------" + mDocList.size());
        return mDocList;
    }
}
