package com.sample.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sample.R;

/**
 * Created by ZCL on 2016/11/30.
 */

public class ToastSample {
    private Context context;

    public void ToastImage(Context context) {
        Toast toast = new Toast(context);
        ImageView imageView = new ImageView(context);//创建图片控件
        imageView.setImageResource(R.mipmap.ic_launcher);//给控件设置图片
        toast.setView(imageView);//把图片绑定到Toast上
        toast.setDuration(Toast.LENGTH_LONG);//Toast显示的时间;
        //设置图片显示的位置：三个参数
        //第一个：位置，可以用|添加并列位置，第二个：相对于X的偏移量，第三个：相对于Y轴的偏移量
        //注意一点：第二和第三个参数是相对于第一个参数设定的位置偏移的
        toast.setGravity(Gravity.TOP | Gravity.RIGHT, 0, 100);
        toast.show();//显示Toast
    }

    public void ToastImageandText() {
        Toast toast = new Toast(context);
        LinearLayout linearLayout = new LinearLayout(context);//创建线性布局
        linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直
        ImageView imageView = new ImageView(context);//创建图片控件
        imageView.setImageResource(R.mipmap.ic_launcher);//给控件设置图片
        TextView textView = new TextView(context);//创建文本控件
        textView.setText("神话丿小王子是不是很帅");//设置文本内容
        linearLayout.addView(imageView);//添加图片控件到布局中
        linearLayout.addView(textView);//添加文本控件到布局中。注意添加顺序会影响图片在前还是为本在前
        toast.setView(linearLayout);//把布局绑定到Toast上
        toast.setDuration(Toast.LENGTH_LONG);//Toast显示的时间;
        //参数同前面
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();//显示Toast
    }
}
