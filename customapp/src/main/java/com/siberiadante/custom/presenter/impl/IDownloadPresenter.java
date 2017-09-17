package com.siberiadante.custom.presenter.impl;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public interface IDownloadPresenter {
    /**
     * 下载执行
     *
     * @param url
     */
    void download(String url);

    /**
     * 下载进度
     *
     * @param progress
     */
    void downloadProgress(int progress);

    /**
     * 下载成功
     *
     * @param result
     */
    void downloadSuccess(String result);

    /**
     * 下载失败
     */
    void downloadFail();
}
