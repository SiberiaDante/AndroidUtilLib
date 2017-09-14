package com.sample.ui.activity.util;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDCardUtil;

public class SDCardUtilActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard_util);
        final TextView t = (TextView) findViewById(R.id.tv_sdscrd_content);
        final StringBuilder builder = new StringBuilder();
        builder.append("---SD卡是否正常挂载---" + SDCardUtil.isSDCardMounted());
        builder.append("\n");
        builder.append("---getExternalStorageState---" + SDCardUtil.getExternalStorageState());
        builder.append("\n");
        builder.append("---getSDCardBaseDir---" + SDCardUtil.getSDCardBaseDir());
        builder.append("\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---getSDCardSizeMB---" + SDCardUtil.getSDCardSizeMB() + " MB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---getSDCardSizeKB---" + SDCardUtil.getSDCardSizeKB() + " KB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---getSDCardSizeB---" + SDCardUtil.getSDCardSizeB() + " B");
            builder.append("\n");
        }
        t.setText(builder.toString());
    }
}
