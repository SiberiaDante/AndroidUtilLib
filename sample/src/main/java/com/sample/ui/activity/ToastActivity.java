package com.sample.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.sample.R;
import com.siberiadante.util.ToastUtil;

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
        Button mBtnShowTextS = (Button) findViewById(R.id.btn_show_singleton_text);
        Button mBtnShowLines = (Button) findViewById(R.id.btn_show_lines);
        Button mBtnShowImage = (Button) findViewById(R.id.btn_show_image);
        Button mBtnShowIT = (Button) findViewById(R.id.btn_show_image_text);
        Button mBtnShowLayout = (Button) findViewById(R.id.btn_show_layout);
        Button mBtnShowCancel = (Button) findViewById(R.id.btn_toast_cancel);
        Button mBtnShowThread = (Button) findViewById(R.id.btn_show_thread);

        mBtnShowTextS.setOnClickListener(this);
        mBtnShowLines.setOnClickListener(this);
        mBtnShowImage.setOnClickListener(this);
        mBtnShowIT.setOnClickListener(this);
        mBtnShowLayout.setOnClickListener(this);
        mBtnShowCancel.setOnClickListener(this);
        mBtnShowThread.setOnClickListener(this);
    }

    private void testToast() {
        ToastUtil.showTextLong("长时间吐司一段文本内容");
        ToastUtil.showTextShort("短时间吐司一段文本内容");
        ToastUtil.showSingletonLong("长时间吐司一段文本内容,单例模式哦");
        ToastUtil.showSingletonShort("短时间吐司一段文本内容,单例模式哦");
        ToastUtil.showImageCenter(R.mipmap.ic_launcher, Toast.LENGTH_SHORT);//居中显示一张图片,非单例模式
        ToastUtil.showSingletonImageCenter(R.mipmap.ic_launcher, Toast.LENGTH_LONG);//居中显示一张图片,单例模式
        ToastUtil.showImage(R.mipmap.ic_launcher, Toast.LENGTH_LONG, Gravity.BOTTOM | Gravity.LEFT);//自定义显示图片位置
        ToastUtil.showIT(R.mipmap.ic_launcher, "SiberiaDanteLib", Toast.LENGTH_LONG, Gravity.CENTER);//自行显示图文消息
        ToastUtil.cancel();
        ToastUtil.cancelAll();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_show_singleton_text:
                ToastUtil.showSingletonLong("长时间吐司一段文本内容,单例模式哦");

                break;

            case R.id.btn_show_image:
                ToastUtil.showImage(R.mipmap.image, Toast.LENGTH_LONG, Gravity.CENTER);

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
            case R.id.btn_show_layout:
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.llToast));
                ToastUtil.showLayout(layout, Toast.LENGTH_LONG, Gravity.TOP);
                break;
            case R.id.btn_show_thread:
                ToastUtil.showThread(url);
                break;

            case R.id.btn_toast_cancel:
                ToastUtil.cancelAll();

                break;
        }
    }
}
