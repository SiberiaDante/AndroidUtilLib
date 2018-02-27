package com.siberiadante.androidutil.util;

import android.os.Build;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2018/1/5
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class SDObjectUtil {

    /**
     * 判断对象是否为空
     *
     * @param obj 对象
     * @return {@code true}: 为空<br>{@code false}: 不为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String && obj.toString().length() == 0) {
            return true;
        }
        if (obj.getClass().isArray() && Array.getLength(obj) == 0) {
            return true;
        }
        if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        }
        if (obj instanceof SparseArray && ((SparseArray) obj).size() == 0) {
            return true;
        }
        if (obj instanceof SparseBooleanArray && ((SparseBooleanArray) obj).size() == 0) {
            return true;
        }
        if (obj instanceof SparseIntArray && ((SparseIntArray) obj).size() == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            if (obj instanceof SparseLongArray && ((SparseLongArray) obj).size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断两个对象是否相等
     *
     * @param o1
     * @param o2
     * @return
     */
    public static boolean isEquals(Object o1, Object o2) {
        if (o1 != null) {
            return o1 == o2 || o1.equals(o2);
        } else return o2 == null;
    }
}
