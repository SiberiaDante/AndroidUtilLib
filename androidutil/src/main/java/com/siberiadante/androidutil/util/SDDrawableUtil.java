package com.siberiadante.androidutil.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.siberiadante.androidutil.SDAndroidLib;

import static com.siberiadante.androidutil.util.SDBitmapUtil.bitmap2Bytes;
import static com.siberiadante.androidutil.util.SDBitmapUtil.bitmap2StrByBase64;
import static com.siberiadante.androidutil.util.SDBitmapUtil.bytes2Bitmap;
import static com.siberiadante.androidutil.util.SDBitmapUtil.drawable2Bitmap;

/**
 * @Created SiberiaDante
 * @Describe：
 * @CreateTime: 2017/11/27
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDDrawableUtil {
    /**
     * drawable转byteArr
     *
     * @param drawable drawable对象
     * @return drawable对象字节数组
     */
    public static byte[] drawable2Bytes(Drawable drawable) {
        return drawable == null ? null : bitmap2Bytes(drawable2Bitmap(drawable), Bitmap.CompressFormat.JPEG, 100);
    }

    /**
     * drawable转byteArr
     *
     * @param drawable drawable对象
     * @param quality
     * @return drawable对象字节数组
     */
    public static byte[] drawable2Bytes(Drawable drawable, int quality) {
        return drawable == null ? null : bitmap2Bytes(drawable2Bitmap(drawable), Bitmap.CompressFormat.JPEG, quality);
    }

    /**
     * drawable转byteArr
     *
     * @param drawable drawable对象
     * @param format   格式
     * @return drawable对象字节数组
     */
    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat format) {
        return drawable == null ? null : bitmap2Bytes(drawable2Bitmap(drawable), format, 100);
    }

    /**
     * drawable转byteArr
     *
     * @param drawable drawable对象
     * @param format
     * @param quality
     * @return drawable对象字节数组
     */
    public static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat format, int quality) {
        return drawable == null ? null : bitmap2Bytes(drawable2Bitmap(drawable), format, quality);
    }

    /**
     * drawable转base64
     *
     * @param drawable drawable对象
     * @return drawable对象字节数组
     */
    public static String drawable2Base64(Drawable drawable) {
        return drawable == null ? null : bitmap2StrByBase64(drawable2Bitmap(drawable), Bitmap.CompressFormat.JPEG, 100);
    }

    /**
     * drawable转base64
     *
     * @param drawable drawable对象
     * @param quality
     * @return drawable对象字节数组
     */
    public static String drawable2Base64(Drawable drawable, int quality) {
        return drawable == null ? null : bitmap2StrByBase64(drawable2Bitmap(drawable), Bitmap.CompressFormat.JPEG, quality);
    }

    /**
     * drawable转base64
     *
     * @param drawable drawable对象
     * @param format   格式
     * @return drawable对象字节数组
     */
    public static String drawable2Base64(Drawable drawable, Bitmap.CompressFormat format) {
        return drawable == null ? null : bitmap2StrByBase64(drawable2Bitmap(drawable), format, 100);
    }

    /**
     * drawable转base64
     *
     * @param drawable drawable对象
     * @param format
     * @param quality
     * @return drawable对象字节数组
     */
    public static String drawable2Base64(Drawable drawable, Bitmap.CompressFormat format, int quality) {
        return drawable == null ? null : bitmap2StrByBase64(drawable2Bitmap(drawable), format, quality);
    }
    /**
     * byteArr转drawable
     *
     * @param bytes 字节数组
     * @return drawable
     */
    public static Drawable bytes2Drawable(byte[] bytes) {
        return bytes2Drawable(bytes, 0);
    }

    /**
     * byteArr转drawable
     *
     * @param bytes  字节数组
     * @param offset decode的位移量，一般为0
     * @return drawable
     */
    public static Drawable bytes2Drawable(byte[] bytes, int offset) {
        return bitmap2Drawable(bytes2Bitmap(bytes, offset));
    }

    /**
     * bitmap转drawable
     *
     * @param bitmap bitmap对象
     * @return drawable
     */
    public static Drawable bitmap2Drawable(final Bitmap bitmap) {
        return bitmap == null ? null : new BitmapDrawable(SDAndroidLib.getContext().getResources(), bitmap);
    }
}
