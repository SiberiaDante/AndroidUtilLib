package com.siberiadante.utilsample.activity.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDStorageUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDStorageUtilActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdstorage_util;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void initView(Bundle savedInstanceState) {
        final StringBuilder builder = new StringBuilder();
        builder.append("判断SD卡是否可用:").append(SDStorageUtil.isSDCardMounted()).append("\n")
                .append("判断SDCard是否可拆卸:").append(SDStorageUtil.isSDCarfRemovable()).append("\n")
                .append("获取SD卡的根目录:").append(SDStorageUtil.getSDCardBaseDir()).append("\n")
                .append("获取SD卡的完整空间大小返回MB:").append(SDStorageUtil.getSDCardSizeMB()).append("\n")
                .append("获取SD卡的完整空间大小返回KB:").append(SDStorageUtil.getSDCardSizeKB()).append("\n")
                .append("获取SD卡的完整空间大小返回B:").append(SDStorageUtil.getSDCardSizeB()).append("\n")
                .append("获取SD卡的剩余空间大小返回MB:").append(SDStorageUtil.getSDCardFreeSizeMB()).append("\n")
                .append("获取SD卡的剩余空间大小返回KB:").append(SDStorageUtil.getSDCardFreeSizeKB()).append("\n")
                .append("获取SD卡的剩余空间大小返回B:").append(SDStorageUtil.getSDCardFreeSizeB()).append("\n")
                .append("获取SD卡的可用空间大小返回MB:").append(SDStorageUtil.getSDCardAvailableSizeMB()).append("\n")
                .append("获取SD卡的可用空间大小返回KB:").append(SDStorageUtil.getSDCardAvailableSizeKB()).append("\n")
                .append("获取SD卡的可用空间大小返回B:").append(SDStorageUtil.getSDCardAvailableSizeB()).append("\n")
                .append("获取SD卡路径:").append(SDStorageUtil.getSDCardPath()).append("\n")
                .append("获取SD卡data路径:").append(SDStorageUtil.getDataPath()).append("\n")
                .append("获取下载文件存储路径:").append(SDStorageUtil.getDownloadCachePath()).append("\n")
                .append("获取当前程序路径(应用在内存上的目录):").append(SDStorageUtil.getCurrentAppStoragePath()).append("\n")
                .append("应用的在内存上的缓存目录:").append(SDStorageUtil.getCurrentAppCachePath()).append("\n")
                .append("应用在外部存储上的目录:").append(SDStorageUtil.getCurrentAppExternalStoragePath()).append("\n")
                .append("应用的在外部存储上的缓存目录:").append(SDStorageUtil.getCurrentAppExternalCachePath()).append("\n")
                .append("获取该程序的安装包路径:").append(SDStorageUtil.getCurrentAppPackageResourcePath()).append("\n")
//                .append("获取程序默认数据库路径(需输入数据库名）:").append(SDStorageUtil.getCurrentAppDatabasePath("")).append("\n")
                .append("获取SD卡信息:").append(SDStorageUtil.getSDCardInfo()).append("\n");
        tvContent.setText(builder.toString());

    }


}
