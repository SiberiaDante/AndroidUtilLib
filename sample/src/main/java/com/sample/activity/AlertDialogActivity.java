package com.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sample.R;
import com.siberiadante.util.ToastUtil;
import com.siberiadante.widget.AlertEditDialog;

public class AlertDialogActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dailog);
        final Button mBtnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        mBtnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertEditDialog dialog = new AlertEditDialog(AlertDialogActivity.this).builder();
                dialog.setTitle("可编辑Dialog");
                dialog.setCancelable(false);
                dialog.setNegativeButton("取消", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
                dialog.setPositiveButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String msg = dialog.getMsg();
                        ToastUtil.showTextLong("输入内容为："+msg);
                    }
                });
                dialog.show();
            }
        });
    }
}
