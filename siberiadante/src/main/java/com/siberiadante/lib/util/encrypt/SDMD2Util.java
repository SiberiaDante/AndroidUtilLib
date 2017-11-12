package com.siberiadante.lib.util.encrypt;


import com.siberiadante.lib.util.encrypt.base.SDBaseEncrypt;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/11/8
 * @UpDateTime:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDMD2Util {


    /**
     * MD2加密
     *
     * @param data 明文字符串
     * @return 16进制密文32位
     */
    public static String hashEncrypt32(final String data) {
        return hashEncrypt32(data.getBytes());
    }

    /**
     * MD2加密
     *
     * @param data 明文字节数组
     * @return 16进制密文32位
     */
    public static String hashEncrypt32(final byte[] data) {
        return SDBaseEncrypt.bytes2HexString(hashEncrypt(data));
    }

    /**
     * MD2加密
     *
     * @param data 明文字节数组
     * @return 密文字节数组
     */
    public static byte[] hashEncrypt(final byte[] data) {
        return SDBaseEncrypt.hashTemplate(data, "MD2");
    }
}
