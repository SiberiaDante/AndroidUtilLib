package com.sample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.sample.R;
import com.siberiadante.util.ToastUtil;
import com.siberiadante.widget.AlertEditDialog;
import com.siberiadante.widget.BottomPopupWindow;
import com.siberiadante.widget.EnsureDialog;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private EnsureDialog ensureDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.btn_general_dialog).setOnClickListener(this);
        findViewById(R.id.btn_bottom_popup_widow).setOnClickListener(this);
        findViewById(R.id.btn_edit_dialog).setOnClickListener(this);
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_general_dialog:
                showEnsureDialog();
                break;
            case R.id.btn_bottom_popup_widow:
                showBottomPopupWindow();
                break;
            case R.id.btn_edit_dialog:
                showEditDialog();
                break;
        }
    }

    private void showEditDialog() {
        final AlertEditDialog dialog = new AlertEditDialog(this).builder();
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
                ToastUtil.showTextLong("输入内容为：" + msg);
            }
        });
        dialog.show();
    }

    private void showBottomPopupWindow() {
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


    private void showEnsureDialog() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setIncon(R.mipmap.tip_icon)//不设置图标，默认没有图标
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.Red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }
}
