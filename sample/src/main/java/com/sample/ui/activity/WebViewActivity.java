package com.sample.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sample.R;
import com.siberiadante.util.ScreenUtil;
import com.siberiadante.view.TitleBar;

public class WebViewActivity extends BaseActivity {

    private String url;
    private WebView mWebView;
    private TitleBar mTitleBar;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ScreenUtil.setStatusTranslucent(this);
        initIntent();
        initView();
    }

    private void initIntent() {
        final Intent intent = getIntent();
        url = intent.getStringExtra("url");
        title = intent.getStringExtra("title");
    }

    private void initView() {
        mTitleBar = (TitleBar) findViewById(R.id.title_bar_web_view);
        setTitleBar(mTitleBar);
        mWebView = (WebView) findViewById(R.id.wv_web_view);
        setWebView();

    }

    private void setWebView() {
        final WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
                return true;
            }
        });
    }

    private void setTitleBar(TitleBar mTitleBar) {
        mTitleBar.setImmersive(true);
        mTitleBar.setTitle(title);
        mTitleBar.setLeftText("返回");
        mTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebViewActivity.this.finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
