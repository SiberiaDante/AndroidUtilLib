package com.sample.ui.activity.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.sample.R;
import com.siberiadante.util.ScreenUtil;
import com.siberiadante.util.ToastUtil;
import com.siberiadante.view.EditDialog;
import com.siberiadante.view.BottomPopupWindow;
import com.siberiadante.view.EnsureDialog;
import com.siberiadante.view.TitleBar;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = DialogActivity.class.getSimpleName();
    private EnsureDialog ensureDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ScreenUtil.setStatusTranslucent(this);
        initView();
        initData();
    }

    private void initView() {
        findViewById(R.id.btn_general_dialog_one).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_two).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_three).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_four).setOnClickListener(this);
        findViewById(R.id.btn_bottom_popup_widow).setOnClickListener(this);
        findViewById(R.id.btn_edit_dialog).setOnClickListener(this);
        TitleBar titleBar = ((TitleBar) findViewById(R.id.titleBar_dialog_activity));
        initTitle(titleBar);
    }

    private void initTitle(TitleBar titleBar) {
        titleBar.setImmersive(true);
        titleBar.setTitle("各种Dialog组件封装");
        titleBar.setSubTitle("SiberiaDante");
        titleBar.setSubTitleColor(getResources().getColor(R.color.gray));
        titleBar.setLeftImage(R.mipmap.back);
        titleBar.setLeftText("返回");
        titleBar.setRightImage(R.mipmap.search);
        titleBar.setDivideBackground(getResources().getColor(R.color.colorPrimary));

        titleBar.setTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.showTextLong("点击了标题");
            }
        });
        titleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogActivity.this.finish();
            }
        });

        titleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.toast("点击了右侧");
            }
        });
    }

    private void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_general_dialog_one:
                showEnsureDialogOne();
                break;
            case R.id.btn_general_dialog_two:
                showEnsureDialogTwo();
                break;
            case R.id.btn_general_dialog_three:
                showEnsureDialogThree();
                break;
            case R.id.btn_general_dialog_four:
                showEnsureDialogFour();
                break;
            case R.id.btn_bottom_popup_widow:
                showBottomPopupWindow();
                break;
            case R.id.btn_edit_dialog:
                showEditDialog();
                break;

        }
    }


    /**
     * EditDialog
     */
    private void showEditDialog() {
        final EditDialog dialog = new EditDialog(this).builder();
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
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    /**
     * BottomPopupWindow
     */
    private void showBottomPopupWindow() {
        new BottomPopupWindow(this).builder()
                .setTitle("选择").setCancelable(false).setCanceled(true)
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

    /**
     * EnsureDialog
     */
    private void showEnsureDialogOne() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogTwo() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", getResources().getColor(R.color.black))//可以不设置标题颜色，默认系统颜色
                .setSubTitle("这是一个副标题")
                .setCancelable(false)
                .setNegativeButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogThree() {
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
                .setPositiveButton("确认", getResources().getColor(R.color.red), new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {
                        ensureDialog.dismiss();

                    }
                });
        ensureDialog.show();

    }

    private void showEnsureDialogFour() {
        ensureDialog = new EnsureDialog(this).builder()
                .setGravity(Gravity.CENTER)//默认居中，可以不设置
                .setTitle("这里是一个标题", R.color.black)//可以不设置标题颜色，默认系统颜色
                .setCancelable(false)
                .setCenterButton("取消", new View.OnClickListener() {//可以选择设置颜色和不设置颜色两个方法
                    @Override
                    public void onClick(View view) {

                    }
                })
        ;
        ensureDialog.show();
    }

}
