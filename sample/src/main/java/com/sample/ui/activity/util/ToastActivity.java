package com.sample.ui.activity.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sample.R;
import com.siberiadante.lib.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {
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


        findViewById(R.id.btn_show_lines).setOnClickListener(this);
        findViewById(R.id.btn_toast_cancel).setOnClickListener(this);
        findViewById(R.id.btn_toast_reset).setOnClickListener(this);



        findViewById(R.id.btn_toast_normal).setOnClickListener(this);
        findViewById(R.id.btn_toast_error).setOnClickListener(this);
        findViewById(R.id.btn_toast_error_pic).setOnClickListener(this);
        findViewById(R.id.btn_toast_success).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_text:
                ToastUtil.toast("长时间吐司一段文本内容,单例模式哦");
                break;
            case R.id.btn_show_text_translucent:
                ToastUtil.toastTranslucent("背景透明啊有没有");
                break;
            case R.id.btn_show_image_text:
                ToastUtil.showIT(R.mipmap.image, "这是一个美女哦", Toast.LENGTH_LONG, Gravity.CENTER);
                break;
            case R.id.btn_show_lines:
                List<String> stringList = new ArrayList<>();
                stringList.add("天王盖地虎");
                stringList.add("宝塔镇河妖");
                stringList.add("糗百一入深似海");
                stringList.add("从此纯洁是路人");
                ToastUtil.showLines(stringList, 20);
                break;
//            case R.id.btn_show_layout:
//                LayoutInflater inflater = getLayoutInflater();
//                View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.llToast));
//                ToastUtil.showLayout(layout, Toast.LENGTH_LONG, Gravity.TOP);
//                break;
//            case R.id.btn_show_thread:
////                ToastUtil.showThread(url);
//                break;

            case R.id.btn_toast_cancel:
                ToastUtil.cancelAll();
                break;
            case R.id.btn_toast_reset:
                ToastUtil.resetToast();
                break;
            case R.id.btn_toast_normal:
                ToastUtil.normal("这是一个正常的Toast");
                break;
            case R.id.btn_toast_error:
                ToastUtil.error("这是一个错误提示信息");
                break;
            case R.id.btn_toast_success:
                ToastUtil.success("这是一个成功提示信息");
                break;

        }
    }
}
