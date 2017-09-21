package com.sample.ui.activity.util;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.LogUtil;
import com.siberiadante.lib.util.ToastUtil;

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
                ToastUtil.toast("常规通用Toast");
                break;
            case R.id.btn_show_text_translucent:
                ToastUtil.toastTranslucent("背景透明啊有没有");
                break;
            case R.id.btn_show_bottom:
                ToastUtil.toastBottomLong("底部较长时间Toast");
                break;
            case R.id.btn_show_top:
                ToastUtil.toastTopLong("顶部较长时间Toast");
                break;
            case R.id.btn_show_center:
                ToastUtil.toastCenterLong("中间较长时间Toast");
                break;
            case R.id.btn_show_lines:
                List<String> stringList = new ArrayList<>();
                stringList.add("天王盖地虎");
                stringList.add("宝塔镇河妖");
                stringList.add("糗百一入深似海");
                stringList.add("从此纯洁是路人");
                ToastUtil.showLinesText(stringList, ContextCompat.getColor(this, R.color.white), 18, ContextCompat.getColor(this, R.color.black));
                LogUtil.d("-------------333-----------：" + ContextCompat.getColor(this, R.color.white));
                break;
            case R.id.btn_show_layout:
                ToastUtil.showView(R.layout.dialog_ensure_layout);
                break;
            case R.id.btn_toast_normal:
                ToastUtil.normal("这是一个正常的Toast");
                break;
            case R.id.btn_toast_error:
//                ToastUtil.error("这是一个错误提示信息");
                ToastUtil.error("这是一个错误提示信息",Toast.LENGTH_SHORT);
                break;
            case R.id.btn_toast_success:
                ToastUtil.success("这是一个成功提示信息");
                break;
            case R.id.btn_toast_cancel:
                ToastUtil.cancelAll();
                break;
            case R.id.btn_toast_reset:
                ToastUtil.resetToast();
                break;

        }
    }
}
