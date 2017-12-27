package com.siberiadante.androidutil.encrypt;



import com.siberiadante.androidutil.util.SDCloseUtil;
import com.siberiadante.androidutil.encrypt.base.SDBaseEncrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @Created SiberiaDante
 * @Describe： 内含方法
 * Hash MD5加密：
 * 加密字符串
 * 加密字符串 带盐
 * 加密字节数组
 * 加密文件
 * Hmac MD5加密：
 * 加密字符串
 * 加密字节数组
 * @CreateTime: 2017/11/8
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */
/*

 */
public class SDMD5Util {

    /**
     * MD5加密字符串
     *
     * @param data 明文字符串
     * @return 32位大写密文
     */
    public static String hashEncode32(final String data) {
        return hashEncode32(data.getBytes());
    }

    /**
     * MD5加密字符串
     *
     * @param data 明文字符串
     * @return 16位大写密文
     */
    public static String hashEncode16(final String data) {
        return hashEncode16(data.getBytes());
    }

    /**
     * MD5加密字符串 带盐
     *
     * @param data 明文字符串
     * @param salt 盐
     * @return 32位大写密文
     */
    public static String hashEncode32(final String data, final String salt) {
        return SDBaseEncrypt.bytes2HexString(hashEncode((data + salt).getBytes()));
    }

    /**
     * MD5加密字符串 带盐
     *
     * @param data 明文字符串
     * @param salt 盐
     * @return 16位大写密文
     */
    public static String hashEncode16(final String data, final String salt) {
        return SDBaseEncrypt.bytes2HexString(hashEncode((data + salt).getBytes())).substring(8, 24);
    }

    /**
     * MD5加密字节数组
     *
     * @param data 明文字节数组
     * @return 32位大写密文
     */
    public static String hashEncode32(final byte[] data) {
        return SDBaseEncrypt.bytes2HexString(hashEncode(data));
    }

    /**
     * MD5加密字节数组
     *
     * @param data 明文字节数组
     * @return 16位大写密文
     */
    public static String hashEncode16(final byte[] data) {
        return SDBaseEncrypt.bytes2HexString(hashEncode(data)).substring(8, 24);
    }

    /**
     * MD5加密字节数组 带盐
     *
     * @param data 明文字节数组
     * @param salt 盐字节数组
     * @return 32位大写加盐密文
     */
    public static String hashEncode32(final byte[] data, final byte[] salt) {
        if (data == null || salt == null) return null;
        byte[] dataSalt = new byte[data.length + salt.length];
        System.arraycopy(data, 0, dataSalt, 0, data.length);
        System.arraycopy(salt, 0, dataSalt, data.length, salt.length);
        return SDBaseEncrypt.bytes2HexString(hashEncode(dataSalt));
    }

    /**
     * MD5加密字节数组 带盐
     *
     * @param data 明文字节数组
     * @param salt 盐字节数组
     * @return 16位大写加盐密文
     */
    public static String hashEncode16(final byte[] data, final byte[] salt) {
        if (data == null || salt == null) return null;
        byte[] dataSalt = new byte[data.length + salt.length];
        System.arraycopy(data, 0, dataSalt, 0, data.length);
        System.arraycopy(salt, 0, dataSalt, data.length, salt.length);
        return SDBaseEncrypt.bytes2HexString(hashEncode(dataSalt)).substring(8, 24);
    }

    /**
     * MD5加密
     *
     * @param data 明文字节数组
     * @return 密文字节数组
     */
    public static byte[] hashEncode(final byte[] data) {
        return SDBaseEncrypt.hashTemplate(data, "MD5");
    }

    /**
     * MD5加密文件
     *
     * @param filePath 文件路径
     * @return 文件的16进制32位大写密文
     */
    public static String hashEncodeFile(final String filePath) {
        File file = SDBaseEncrypt.isSpace(filePath) ? null : new File(filePath);
        return hashEncodeFile(file);
    }

    /**
     * MD5加密文件
     *
     * @param file 文件
     * @return 文件的16进制32位大写密文
     */
    public static String hashEncodeFile(final File file) {
        return SDBaseEncrypt.bytes2HexString(hashEncodeFile2Byte(file));
    }

    /**
     * MD5加密文件
     *
     * @param filePath 文件路径
     * @return 文件的MD5校验码
     */
    public static byte[] hashEncodeFile2Byte(final String filePath) {
        File file = SDBaseEncrypt.isSpace(filePath) ? null : new File(filePath);
        return hashEncodeFile2Byte(file);
    }


    /**
     * MD5加密文件
     *
     * @param file 文件
     * @return 文件的MD5校验码
     */
    public static byte[] hashEncodeFile2Byte(final File file) {
        if (file == null) return null;
        FileInputStream fis = null;
        DigestInputStream digestInputStream;
        try {
            fis = new FileInputStream(file);
            MessageDigest md = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(fis, md);
            byte[] buffer = new byte[256 * 1024];
            while (true) {
                if (!(digestInputStream.read(buffer) > 0)) break;
            }
            md = digestInputStream.getMessageDigest();
            return md.digest();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            SDCloseUtil.closeIO(fis);
        }
    }
// ___________________________________________________________________
// HmacMD5加密: 2017/11/8

    /**
     * HmacMD5加密
     *
     * @param data 明文字符串
     * @param key  秘钥
     * @return 16进制密文
     */
    public static String hmacEncode32(final String data, final String key) {
        return hmacEncode32(data.getBytes(), key.getBytes());
    }

    /**
     * HmacMD5加密
     *
     * @param data 明文字节数组
     * @param key  秘钥
     * @return 16进制密文
     */
    public static String hmacEncode32(final byte[] data, final byte[] key) {
        return SDBaseEncrypt.bytes2HexString(hmacEncode(data, key));
    }

    /**
     * HmacMD5加密
     *
     * @param data 明文字节数组
     * @param key  秘钥
     * @return 密文字节数组
     */
    public static byte[] hmacEncode(final byte[] data, final byte[] key) {
        return SDBaseEncrypt.hmacTemplate(data, key, "HmacMD5");
    }
}
