package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siberiadante.androidutil.util.SDProcessUtil;
import com.siberiadante.androidutil.util.SDLogUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDProcessUtilActivity extends BaseActivity {

    private static final String TAG = SDProcessUtilActivity.class.getSimpleName();
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.btn_get_foreground_process)
    Button btnGetForegroundProcess;
    @BindView(R.id.btn_kill_app_process)
    Button btnKillAPPProcess;
    @BindView(R.id.btn_kill_backstage_process)
    Button btnKillBackstageProcess;
    @BindView(R.id.btn_get_backstage_process)
    Button btnGetBackstageProcess;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdprocess_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }


    @OnClick({R.id.btn_get_foreground_process, R.id.btn_kill_app_process, R.id.btn_kill_backstage_process, R.id.btn_get_backstage_process})
    public void onViewClicked(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        switch (view.getId()) {
            case R.id.btn_get_foreground_process:
                tvContent.setText(SDProcessUtil.getForegroundProcessName());
                break;
            case R.id.btn_kill_app_process:
                final boolean processes = SDProcessUtil.killBackgroundProcesses(getPackageName());
                SDLogUtil.d(TAG, "-----------:" + processes);
                break;
            case R.id.btn_kill_backstage_process:
                final Set<String> killAllBackgroundProcesses = SDProcessUtil.killAllBackgroundProcesses();
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append("当前杀死进程有：").append("\n");
                for (String process : killAllBackgroundProcesses) {
                    stringBuilder.append(process).append("\n");
                }
                tvContent.setText(stringBuilder);
                break;
            case R.id.btn_get_backstage_process:
                stringBuilder.delete(0, stringBuilder.length());
                final Set<String> allBackgroundProcesses = SDProcessUtil.getAllBackgroundProcesses();
                for (String allBackgroundProcess : allBackgroundProcesses) {
                    stringBuilder.append(allBackgroundProcess).append("\n");
                }
                tvContent.setText(stringBuilder);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
