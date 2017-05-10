package com.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.sample.R;
import com.siberiadante.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
    }
    private void testToast(){
        ToastUtil.showTextLong("长时间吐司一段文本内容");
        ToastUtil.showTextShort("短时间吐司一段文本内容");
        ToastUtil.showSingletonLong("长时间吐司一段文本内容,单例模式哦");
        ToastUtil.showSingletonShort("短时间吐司一段文本内容,单例模式哦");
        ToastUtil.showImageCenter(R.mipmap.ic_launcher, Toast.LENGTH_SHORT);//居中显示一张图片,非单例模式
        ToastUtil.showSingletonImageCenter(R.mipmap.ic_launcher,Toast.LENGTH_LONG);//居中显示一张图片,单例模式
        ToastUtil.showImage(R.mipmap.ic_launcher,Toast.LENGTH_LONG, Gravity.BOTTOM|Gravity.LEFT);//自定义显示图片位置
        ToastUtil.showIT(R.mipmap.ic_launcher,"SiberiaDanteLib",Toast.LENGTH_LONG,Gravity.CENTER);//自行显示图文消息
    }
}
