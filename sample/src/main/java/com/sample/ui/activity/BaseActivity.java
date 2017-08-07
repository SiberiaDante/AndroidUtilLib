package com.sample.ui.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.event.AppExitEven;
import com.siberiadante.util.ScreenUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtil.setStatusTranslucent(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 退出应用时调用SendExitEvent
     */
    public void sendExitEvent() {
        EventBus.getDefault().post(new AppExitEven());
    }

    @Subscribe
    public void onEventMainThread(AppExitEven event) {
        finish();
    }
}
