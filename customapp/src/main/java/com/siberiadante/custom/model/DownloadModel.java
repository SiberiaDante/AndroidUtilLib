package com.siberiadante.custom.model;

import com.siberiadante.custom.model.impl.IDownloadModel;
import com.siberiadante.custom.presenter.impl.IDownloadPresenter;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class DownloadModel implements IDownloadModel {

    private IDownloadPresenter downloadPresenter;

    public DownloadModel(IDownloadPresenter downloadPresenter) {
        this.downloadPresenter = downloadPresenter;
    }

    @Override
    public void downloadUrl(String url) {

    }
}
