package com.siberiadante.custom.view.impl;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface IDownloadView {

    /**
     * 下载进度条
     *
     * @param isShow
     */
    void showProgressBar(boolean isShow);

    /**
     * 下载进度显示
     *
     * @param progress
     */
    void showProcessProgress(int progress);

    /**
     * 下载结果
     *
     * @param result
     */
    void setView(String result);

    /**
     * 下载失败
     */
    void showFail();


}
