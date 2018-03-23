package com.siberiadante.utilsample.listener;

/**
 * Created: SiberiaDante
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 * CreateTime: 2018/3/23
 * UpDateTime:
 * Describe:
 */
public interface RequestPermissionCallBack {
    /**
     * 同意授权
     */
    void granted();

    /**
     * 取消授权
     */
    void denied();
}
