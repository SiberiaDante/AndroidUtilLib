package com.siberiadante.utilsample.activity;

import android.os.Bundle;
import android.widget.TextView;


import com.siberiadante.androidutil.util.SDActivityUtil;
import com.siberiadante.utilsample.MainActivity;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;

public class SDActivityUtilActivity extends BaseActivity {

    private static final String TAG = SDActivityUtilActivity.class.getSimpleName();
    @BindView(R.id.tv_activity_test)
    TextView mTvContent;

    @Override
    public int setLayoutId() {
        return R.layout.activity_activity_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_activity_util);
        boolean activityExists = SDActivityUtil.isActivityExists("com.siberiadante.utilsample", MainActivity.class.getName());
        String launcherActivity = SDActivityUtil.getLauncherActivity("com.sample");
        StringBuilder builder = new StringBuilder();
        builder.append("1.MainActivity是否存在---" + activityExists + "\n");
        builder.append("2.当前APP的启动Activity是---" + launcherActivity + "\n");
        builder.append("3.包名为com.shuinsen.zhiri的APP的启动Activity是---" + SDActivityUtil.getLauncherActivity("com.shuinsen.zhiri") + "\n");
        mTvContent.setText(builder);
    }

    public void initData() {

    }


}
