package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDCacheUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDCacheUtilActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdcache_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle("SDCacheUtil");
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
}
