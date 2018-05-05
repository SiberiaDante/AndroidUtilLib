package com.siberiadante.androidutil.util;


import java.io.Closeable;
import java.io.IOException;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园:http://www.cnblogs.com/shen-hua/
 * CreateTime: 2017/5/15
 * UpDateTime:
 * Describe：关闭相关工具类
 */
public class SDCloseUtil {
    public SDCloseUtil() {
        throw new UnsupportedOperationException("not init ~~~");
    }

    /**
     * 关闭多个IO流
     *
     * @param closeables io,io,io,...
     */
    public static void closeIO(Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
