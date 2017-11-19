package com.siberiadante.lib.util.encrypt;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Created： SiberiaDante
 * @Date： 2017/11/8
 * @Describe： <a href="https://github.com/SiberiaDante/ResourceCollection/blob/59f58757fcbdda9f025c83f7fe392db78faf2ed7/DataEncryption/Base64.md">分分钟完全掌握Base64编码</a>
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */

public class SDBase64Util {
    /**
     * Base64编码
     *
     * @param data 要编码的字符串
     * @return Base64编码后的字符串
     */
    public static String encode(String data) {
        return Base64.encodeToString(data.getBytes(), Base64.DEFAULT);
    }

    /**
     * Base64编码
     *
     * @param input 要编码的字节数组
     * @return Base64编码后的字符串
     */
    public static byte[] encode(byte[] input) {
        return Base64.encode(input, Base64.NO_WRAP);
    }

    /**
     * 对文件进行Base64编码
     *
     * @param filePath 文件路劲
     * @return Base64编码后的字符串
     */
    public static String encodeFile(String filePath) {
        return encodeFile(new File(filePath));
    }

    /**
     * Base64编码后的字符串
     *
     * @param file 文件
     * @return Base64编码后的字符串
     */
    public static String encodeFile(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
            fileInputStream.close();
            return Base64.encodeToString(bytes, Base64.DEFAULT);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * Base64解码
     * @param data 编码的字符串
     * @return 解码后的字符串
     */
    public static String decode(String data) {
        return new String(Base64.decode(data.getBytes(), Base64.DEFAULT));
    }

    /**
     * Base64解码
     *
     * @param input 要解码的字符串
     * @return Base64解码后的字符串
     */
    public static byte[] decode(byte[] input) {
        return Base64.decode(input, Base64.DEFAULT);
    }
}
