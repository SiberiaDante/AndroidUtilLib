package com.sample.ui.activity.util;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.SDLogUtil;
import com.siberiadante.lib.util.SDToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ToastActivity extends BaseActivity implements View.OnClickListener {
    public static final String url = "http://img.67.com/upload/images/2016/05/26/aGV5YW96aG91MTQ2NDI0Njk3NQ==.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        initView();
    }

    private void initView() {

        findViewById(R.id.btn_show_text).setOnClickListener(this);
        findViewById(R.id.btn_show_text_translucent).setOnClickListener(this);
        findViewById(R.id.btn_show_bottom).setOnClickListener(this);
        findViewById(R.id.btn_show_top).setOnClickListener(this);
        findViewById(R.id.btn_show_center).setOnClickListener(this);
        findViewById(R.id.btn_show_layout).setOnClickListener(this);


        findViewById(R.id.btn_show_lines).setOnClickListener(this);
        findViewById(R.id.btn_toast_cancel).setOnClickListener(this);
        findViewById(R.id.btn_toast_reset).setOnClickListener(this);


        findViewById(R.id.btn_toast_normal).setOnClickListener(this);
        findViewById(R.id.btn_toast_error).setOnClickListener(this);
        findViewById(R.id.btn_toast_success).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_text:
                SDToastUtil.toast("常规通用Toast");
                break;
            case R.id.btn_show_text_translucent:
                SDToastUtil.toastTranslucent("背景透明啊有没有");
                break;
            case R.id.btn_show_bottom:
                SDToastUtil.toastBottomLong("底部较长时间Toast");
                break;
            case R.id.btn_show_top:
                SDToastUtil.toastTopLong("顶部较长时间Toast");
                break;
            case R.id.btn_show_center:
                SDToastUtil.toastCenterLong("中间较长时间Toast");
                break;
            case R.id.btn_show_lines:
                List<String> stringList = new ArrayList<>();
                stringList.add("天王盖地虎");
                stringList.add("宝塔镇河妖");
                stringList.add("糗百一入深似海");
                stringList.add("从此纯洁是路人");
                SDToastUtil.showLinesText(stringList, ContextCompat.getColor(this, R.color.white), 18, ContextCompat.getColor(this, R.color.black));
                SDLogUtil.d("-------------333-----------：" + ContextCompat.getColor(this, R.color.white));
                break;
            case R.id.btn_show_layout:
                SDToastUtil.showView(R.layout.sd_dialog_ensure_layout);
                break;
            case R.id.btn_toast_normal:
                SDToastUtil.normal("这是一个正常的Toast");
                break;
            case R.id.btn_toast_error:
//                SDToastUtil.error("这是一个错误提示信息");
                SDToastUtil.error("这是一个错误提示信息",Toast.LENGTH_SHORT);
                break;
            case R.id.btn_toast_success:
                SDToastUtil.success("这是一个成功提示信息");
                break;
            case R.id.btn_toast_cancel:
                SDToastUtil.cancelAll();
                break;
            case R.id.btn_toast_reset:
                SDToastUtil.resetToast();
                break;

        }
    }
}
