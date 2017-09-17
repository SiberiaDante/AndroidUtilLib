package com.siberiadante.custom.presenter;

import com.siberiadante.custom.model.DownloadModel;
import com.siberiadante.custom.model.impl.IDownloadModel;
import com.siberiadante.custom.presenter.impl.IDownloadPresenter;
import com.siberiadante.custom.view.impl.IDownloadView;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/17
 * @UpDate:
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class DownloadPresenter implements IDownloadPresenter {
    private IDownloadView iDownloadView;
    private IDownloadModel iDownloadModel;

    public DownloadPresenter(IDownloadView iDownloadView) {
        this.iDownloadView = iDownloadView;
        this.iDownloadModel = new DownloadModel(this);
    }

    @Override
    public void download(String url) {
        iDownloadView.showProgressBar(true);
        iDownloadModel.downloadUrl(url);

    }

    @Override
    public void downloadProgress(int progress) {
        iDownloadView.showProcessProgress(progress);

    }

    @Override
    public void downloadSuccess(String result) {
        iDownloadView.showProgressBar(false);

    }

    @Override
    public void downloadFail() {

        iDownloadView.showProgressBar(false);
        iDownloadView.showFail();
    }
}
