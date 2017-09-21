package com.siberiadante.lib.util;

import com.siberiadante.lib.SiberiaDanteLib;
import com.siberiadante.lib.exception.SiberiaDanteLibException;

import java.io.File;

/**
 * @Created SiberiaDante
 * @Describe： 清除缓存、数据等相关应用
 * @Time: 2017/5/15
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class SDClearUtil {
    public SDClearUtil() {
        new SiberiaDanteLibException();
    }

    /**
     * 清除内部缓存
     * <p>/data/data/com.xxx.xxx/cache</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearInternalCache() {
        return SDFileUtil.deleteFilesInDir(SiberiaDanteLib.getContext().getCacheDir());
    }

    /**
     * 清除内部文件
     * <p>/data/data/com.xxx.xxx/files</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearInternalFiles() {
        return SDFileUtil.deleteFilesInDir(SiberiaDanteLib.getContext().getFilesDir());
    }

    /**
     * 清除内部数据库
     * <p>/data/data/com.xxx.xxx/databases</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearInternalDbs() {
        return SDFileUtil.deleteFilesInDir(SiberiaDanteLib.getContext().getFilesDir().getParent() + File.separator + "databases");
    }

    /**
     * 根据名称清除数据库
     * <p>/data/data/com.xxx.xxx/databases/dbName</p>
     *
     * @param dbName 数据库名称
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearInternalDbByName(String dbName) {
        return SiberiaDanteLib.getContext().deleteDatabase(dbName);
    }

    /**
     * 清除内部ShrendPrefrences
     * <p>/data/data/com.xxx.xxx/shared_prefs</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearInternalSP() {
        return SDFileUtil.deleteFilesInDir(SiberiaDanteLib.getContext().getFilesDir().getParent() + File.separator + "shared_prefs");
    }

    /**
     * 清除外部缓存
     * <p>/storage/emulated/0/android/data/com.xxx.xxx/cache</p>
     *
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearExternalCache() {
        return SDStorageUtil.isSDCardMounted() && SDFileUtil.deleteFilesInDir(SiberiaDanteLib.getContext().getExternalCacheDir());
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dirPath 目录路径
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearCustomCache(String dirPath) {
        return SDFileUtil.deleteFilesInDir(dirPath);
    }

    /**
     * 清除自定义目录下的文件
     *
     * @param dir 目录
     * @return {@code true}: 清除成功<br>{@code false}: 清除失败
     */
    public static boolean clearCustomCache(File dir) {
        return SDFileUtil.deleteFilesInDir(dir);
    }
}
