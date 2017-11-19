package com.siberiadante.lib.util;



import java.io.Closeable;
import java.io.IOException;

/**
 * @Created SiberiaDante
 * @Describe： 关闭相关工具类
 * @Time: 2017/5/15
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */
public class SDCloseUtil {
    public SDCloseUtil() {
        throw new UnsupportedOperationException("not init SDAndroidLib");
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
