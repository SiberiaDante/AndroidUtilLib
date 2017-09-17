package com.siberiadante.custom.ui.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siberiadante.custom.R;
import com.siberiadante.custom.presenter.DownloadPresenter;
import com.siberiadante.custom.view.impl.IDownloadView;

public class DownloadActivity extends AppCompatActivity implements IDownloadView {

    private DownloadPresenter downloadPresenter;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        downloadPresenter = new DownloadPresenter(this);
        downloadPresenter.download("www...");
    }

    @Override
    public void showProgressBar(boolean isShow) {

        if (isShow) {
            dialog.show();
        } else {
            dialog.cancel();
        }
    }

    @Override
    public void showProcessProgress(int progress) {


    }

    @Override
    public void setView(String result) {

    }

    @Override
    public void showFail() {

    }
}
