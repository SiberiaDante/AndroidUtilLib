package com.siberiadante.utilsample.activity.util;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siberiadante.androidutil.util.SDDateUtil;
import com.siberiadante.androidutil.util.SDToastUtil;
import com.siberiadante.androidutil.util.SDTimerUtil;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created:： SiberiaDante
 * @Date： 2018/01/01
 * Describe：
 * @github： https://github.com/SiberiaDante
 * @博客园： http://www.cnblogs.com/shen-hua/
 */
public class SDTimerUtilActivity extends BaseActivity {

    @BindView(R.id.btn_fast_click)
    Button btnFastClick;
    private int count = 1;

    @Override
    public int setLayoutId() {
        return R.layout.activity_timer_util;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        actionBar.setTitle(R.string.sd_timer_util);
    }


    @OnClick({R.id.btn_fast_click})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fast_click:
                if (SDTimerUtil.isNotFastClick()) {
                    SDToastUtil.toast("第 " + count++ + " 次点击：" + SDDateUtil.getSDFTimeYMdHms());
                }
                break;
        }
    }
}
