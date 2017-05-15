package com.siberiadante.util;

import android.os.Environment;

/**
 * Created by SiberiaDante on 2017/5/15.
 */

public class SDCardUtil {
    /**
     * 判断SD卡是否可用
     *
     * @return true : 可用<br>false : 不可用
     */
    public static boolean isSDCardEnable() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }
}
