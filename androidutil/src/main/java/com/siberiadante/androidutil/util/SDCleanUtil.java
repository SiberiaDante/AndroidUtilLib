package com.siberiadante.androidutil.util;


import android.os.Environment;

import com.siberiadante.androidutil.SDAndroidLib;

import java.io.File;

import static com.siberiadante.androidutil.util.SDFileUtil.deleteDir;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * 博客园:http://www.cnblogs.com/shen-hua/
 * CreateTime: 2017/5/15
 * UpDateTime:
 * Describe：清除缓存、数据等相关应用
 */
public class SDCleanUtil {
    public SDCleanUtil() {
        throw new UnsupportedOperationException("not init lib---" + SDCleanUtil.class.getName());
    }

    /**
     * 清除缓存
     */
    public static boolean clearAllCache() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            SDFileUtil.deleteDir(SDAndroidLib.getContext().getExternalCacheDir());
        }
        return deleteDir(SDAndroidLib.getContext().getCacheDir());
    }

    /**
     * 清除内部缓存
     * <p>/data/data/com.xxx.xxx/cache</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalCache() {
        return SDFileUtil.deleteFilesInDir(SDAndroidLib.getContext().getCacheDir());
    }

    /**
     * 清除内部文件
     * <p>/data/data/com.xxx.xxx/files</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalFiles() {
        return SDFileUtil.deleteFilesInDir(SDAndroidLib.getContext().getFilesDir());
    }

    /**
     * 清除内部数据库
     * <p>/data/data/com.xxx.xxx/databases</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalDbs() {
        return SDFileUtil.deleteFilesInDir(SDAndroidLib.getContext().getFilesDir().getParent() + File.separator + "databases");
    }

    /**
     * 根据名称清除数据库
     * <p>/data/data/com.xxx.xxx/databases/dbName</p>
     *
     * @param dbName 数据库名称
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalDbByName(String dbName) {
        return SDAndroidLib.getContext().deleteDatabase(dbName);
    }

    /**
     * 清除内部ShrendPrefrences
     * <p>/data/data/com.xxx.xxx/shared_prefs</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanInternalSP() {
        return SDFileUtil.deleteFilesInDir(SDAndroidLib.getContext().getFilesDir().getParent() + File.separator + "shared_prefs");
    }

    /**
     * 清除外部缓存
     * <p>/storage/emulated/0/android/data/com.xxx.xxx/cache</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanExternalCache() {
        return SDStorageUtil.isSDCardMounted() && SDFileUtil.deleteFilesInDir(SDAndroidLib.getContext().getExternalCacheDir());
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dirPath 目录路径
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanCustomCache(String dirPath) {
        return SDFileUtil.deleteFilesInDir(dirPath);
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dir 目录
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean cleanCustomCache(File dir) {
        return SDFileUtil.deleteFilesInDir(dir);
    }

}
