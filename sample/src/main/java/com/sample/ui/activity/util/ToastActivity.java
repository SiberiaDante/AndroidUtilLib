package com.sample.ui.activity.util;

import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.SDToast;

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
                SDToast.toast("常规通用Toast");
                break;
            case R.id.btn_show_text_translucent:
                SDToast.toastTranslucent("背景透明啊有没有");
                break;
            case R.id.btn_show_bottom:
                SDToast.toastBottomLong("底部较长时间Toast");
                break;
            case R.id.btn_show_top:
                SDToast.toastTopLong("顶部较长时间Toast");
                break;
            case R.id.btn_show_center:
                SDToast.toastCenterLong("中间较长时间Toast");
                break;
            case R.id.btn_show_lines:
                List<String> stringList = new ArrayList<>();
                stringList.add("天王盖地虎");
                stringList.add("宝塔镇河妖");
                stringList.add("糗百一入深似海");
                stringList.add("从此纯洁是路人");
                SDToast.showLinesText(stringList, ContextCompat.getColor(this, R.color.white), 18, ContextCompat.getColor(this, R.color.black));
                LogUtil.d("-------------333-----------：" + ContextCompat.getColor(this, R.color.white));
                break;
            case R.id.btn_show_layout:
                SDToast.showView(R.layout.dialog_ensure_layout);
                break;
            case R.id.btn_toast_normal:
                SDToast.normal("这是一个正常的Toast");
                break;
            case R.id.btn_toast_error:
//                SDToast.error("这是一个错误提示信息");
                SDToast.error("这是一个错误提示信息",Toast.LENGTH_SHORT);
                break;
            case R.id.btn_toast_success:
                SDToast.success("这是一个成功提示信息");
                break;
            case R.id.btn_toast_cancel:
                SDToast.cancelAll();
                break;
            case R.id.btn_toast_reset:
                SDToast.resetToast();
                break;

        }
    }
}
