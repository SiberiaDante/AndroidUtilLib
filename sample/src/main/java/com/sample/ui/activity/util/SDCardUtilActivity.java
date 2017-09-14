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
        builder.append("---判断SD卡是否可用---" + SDCardUtil.isSDCardMounted());
        builder.append("\n");
        builder.append("---getExternalStorageState---" + SDCardUtil.getExternalStorageState());
        builder.append("\n");
        builder.append("---获取SD卡的根目录---" + SDCardUtil.getSDCardBaseDir());
        builder.append("\n");
        builder.append("---获取SD卡的根目录---" + SDCardUtil.getSDCardPath());
        builder.append("\n");
        builder.append("---获取SD卡的信息---" + SDCardUtil.getSDCardInfo());
        builder.append("\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---\n" + SDCardUtil.getSDCardSizeMB() + " MB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---" + SDCardUtil.getSDCardSizeKB() + " KB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---" + SDCardUtil.getSDCardSizeB() + " B");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的剩余空间大小---" + SDCardUtil.getSDCardFreeSizeMB()+ " MB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的可用空间大小---" + SDCardUtil.getSDCardAvailableSizeMB()+ " MB");
            builder.append("\n");
        }
        builder.append("---获取SD卡data路径---" + SDCardUtil.getDataPath());
        builder.append("\n");
        t.setText(builder.toString());
    }
}
