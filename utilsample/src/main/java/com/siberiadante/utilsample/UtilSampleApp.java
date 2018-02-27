package com.siberiadante.utilsample;

import android.app.Application;

import com.siberiadante.androidutil.SDAndroidLib;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created: SiberiaDante
 * Describe：
 * CreateTime: 2017/12/25
 * UpDateTime:
 * Email: 2654828081@qq.com
 * GitHub: https://github.com/SiberiaDante
 * Blog: http://www.cnblogs.com/shen-hua/
 */

public class UtilSampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SDAndroidLib.initLib(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
