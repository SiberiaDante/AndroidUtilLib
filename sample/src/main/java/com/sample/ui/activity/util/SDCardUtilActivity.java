package com.sample.ui.activity.util;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDStorageUtil;

public class SDCardUtilActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard_util);
        final TextView t = (TextView) findViewById(R.id.tv_sdscrd_content);
        final StringBuilder builder = new StringBuilder();
        builder.append("---判断SD卡是否可用---" + SDStorageUtil.isSDCardMounted());
        builder.append("\n");
        builder.append("---判断SDCard是否可拆卸---" + SDStorageUtil.isSDCarfRemovable());
        builder.append("\n");
        builder.append("---getExternalStorageState---" + SDStorageUtil.getExternalStorageState());
        builder.append("\n");
        builder.append("---获取SD卡的根目录---" + SDStorageUtil.getSDCardBaseDir());
        builder.append("\n");
        builder.append("---获取SD卡的根目录---" + SDStorageUtil.getSDCardPath());
        builder.append("\n");
        builder.append("---获取SD卡data路径---" + SDStorageUtil.getDataPath());
        builder.append("\n");
        builder.append("---获取SD卡的信息---" + SDStorageUtil.getSDCardInfo());
        builder.append("\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---\n" + SDStorageUtil.getSDCardSizeMB() + " MB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---" + SDStorageUtil.getSDCardSizeKB() + " KB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的完整空间大小---" + SDStorageUtil.getSDCardSizeB() + " B");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的剩余空间大小---" + SDStorageUtil.getSDCardFreeSizeMB() + " MB");
            builder.append("\n");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.append("---获取SD卡的可用空间大小---" + SDStorageUtil.getSDCardAvailableSizeMB() + " MB");
            builder.append("\n");
        }

        builder.append("---获取SD卡私有Cache目录的路径---" + SDStorageUtil.getSDCardPrivateCacheDir());
        builder.append("\n");
        builder.append("---判断路径文件是否存在---" + SDStorageUtil.isFileExist(SDStorageUtil.getDataPath()));
        builder.append("\n");
        builder.append("---获取当前程序路径 应用在内存上的目录---" + SDStorageUtil.getCurrentAppStoragePath());
        builder.append("\n");
        builder.append("---应用的在内存上的缓存目录---" + SDStorageUtil.getCurrentAppCachePath());
        builder.append("\n");
        builder.append("---应用在外部存储上的目录---" + SDStorageUtil.getCurrentAppExternalStoragePath());
        builder.append("\n");
        builder.append("---应用的在外部存储上的缓存目录---" + SDStorageUtil.getCurrentAppExternalCachePath());
        builder.append("\n");
        builder.append("---获取该程序的安装包路径---" + SDStorageUtil.getCurrentAppPackageResourcePath());
        builder.append("\n");
        builder.append("---获取程序默认数据库路径---" + SDStorageUtil.getCurrentAppDatabasePath("sample"));
        builder.append("\n");
        builder.append("---获取下载文件存储路径---" + SDStorageUtil.getDownloadCachePath());
        builder.append("\n");


        t.setText(builder.toString());
    }
}
