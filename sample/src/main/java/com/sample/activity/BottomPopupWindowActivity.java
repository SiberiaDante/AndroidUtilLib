package com.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.R;
import com.siberiadante.widget.BottomPopupWindow;

public class BottomPopupWindowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_popup_window);
        initView();
    }

    private void initView() {
        final Button mBtnPopupWindow = (Button) findViewById(R.id.btn_bottom_popup_window);

        mBtnPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        new BottomPopupWindow(this).builder()
                .setTitle("选择").setCancelable(false).setCanceledOnTouchOutside(true)
                .addSheetItem("相机", BottomPopupWindow.SheetItemColor.Blue, new BottomPopupWindow.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //需要对相机进行运行时权限的申请
                    }
                })
                .addSheetItem("相册", BottomPopupWindow.SheetItemColor.Blue, new BottomPopupWindow.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {
                        //调用手机相册的方法,该方法在下面有具体实现
                    }
                }).show();
    }
}
