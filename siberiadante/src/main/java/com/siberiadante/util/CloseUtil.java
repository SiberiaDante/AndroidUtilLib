package com.siberiadante.util;

import com.siberiadante.exception.SiberiaDanteLibException;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by SiberiaDante on 2017/5/15.
 */

public class CloseUtil {
    public CloseUtil() {
        new SiberiaDanteLibException();
    }

    /**关闭过个IO
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
