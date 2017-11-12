package com.sample.ui.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sample.R;
import com.sample.constants.Constants;
import com.sample.ui.activity.BaseActivity;
import com.sample.ui.activity.SecondActivity;
import com.siberiadante.lib.util.SDActivityUtil;
import com.siberiadante.lib.util.SDLogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityUtilActivity extends BaseActivity {

    private static final String TAG = ActivityUtilActivity.class.getSimpleName();
    @BindView(R.id.btn_start_other_activity)
    Button btnStartOtherActivity;
    @BindView(R.id.start_browser)
    Button startBrowser;
    @BindView(R.id.tv_activity_test)
    TextView mTvContent;
    @BindView(R.id.activity_util_test)
    LinearLayout activityUtilTest;

    @Override
    public int setLayoutId() {
        return R.layout.activity_util_test;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        SDLogUtil.d("-------------" + SecondActivity.class.getName());

        StringBuilder builder = new StringBuilder();
        builder.append("1.SecondActivity是否存在---" + SDActivityUtil.isActivityExists("com.sample", SecondActivity.class.getName()) + "\n");
        builder.append("2.当前APP的启动Activity是---" + SDActivityUtil.getLauncherActivity("com.sample") + "\n");
        builder.append("3.包名为com.shuinsen.zhiri的APP的启动Activity是---" + SDActivityUtil.getLauncherActivity("com.shuinsen.zhiri") + "\n");
        mTvContent.setText(builder);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_start_other_activity, R.id.start_browser})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start_other_activity:
                SDActivityUtil.startActivity( SecondActivity.class);
                break;
            case R.id.start_browser:
                SDActivityUtil.startBrowser(Constants.URL_SIBERIA_DANTE_LIB);
                break;
        }
    }
}
