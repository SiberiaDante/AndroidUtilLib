package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDCleanUtil;
import com.siberiadante.androidutil.util.SDCacheUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SDCleanUtilActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.btn_clean_all_cache)
    Button btnCleanAllCache;
    @BindView(R.id.btn_clean_inner_cache)
    Button btnCleanInnerCache;
    @BindView(R.id.btn_clean_inner_file)
    Button btnCleanInnerFile;
    @BindView(R.id.btn_clean_inner_db)
    Button btnCleanInnerDb;
    @BindView(R.id.btn_clean_inner_sp)
    Button btnCleanInnerSp;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdclean_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDCleanUtil");
        initCacheData();
    }

    private void initCacheData() {
        final StringBuilder builder = new StringBuilder();
        String totalCacheSize = null;
        try {
            totalCacheSize = SDCacheUtil.getTotalCacheSize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.append("获取当前APP缓存：").append(totalCacheSize);
        tvContent.setText(builder);
    }

    @OnClick({R.id.btn_clean_all_cache, R.id.btn_clean_outer_cache, R.id.btn_clean_inner_cache, R.id.btn_clean_inner_file, R.id.btn_clean_inner_db, R.id.btn_clean_inner_sp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_clean_all_cache:
                SDCleanUtil.clearAllCache();
                break;
            case R.id.btn_clean_inner_cache:
                SDCleanUtil.cleanInternalCache();
                break;

            case R.id.btn_clean_inner_file:
                SDCleanUtil.cleanInternalFiles();
                break;
            case R.id.btn_clean_inner_db:
                SDCleanUtil.cleanInternalDbs();
                break;
            case R.id.btn_clean_inner_sp:
                SDCleanUtil.cleanInternalSP();
                break;
            case R.id.btn_clean_outer_cache:
                SDCleanUtil.cleanExternalCache();
                break;
        }
        initCacheData();
    }
}
