package com.sample.ui.activity.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.sample.R;
import com.sample.ui.activity.BaseActivity;
import com.siberiadante.lib.util.ScreenUtil;
import com.siberiadante.lib.util.SDToast;
import com.siberiadante.lib.view.dialog.SDCustomDialog;
import com.siberiadante.lib.view.dialog.SDEditDialog;
import com.siberiadante.lib.view.BottomPopupWindow;
import com.siberiadante.lib.view.dialog.SDEnsureDialog;
import com.siberiadante.lib.view.dialog.NiceDialog;
import com.siberiadante.lib.view.dialog.SDEnsureSubDialog;
import com.siberiadante.lib.view.titlebar.SDTitleBar;
import com.siberiadante.lib.view.base.nicedialog.BaseNiceDialog;
import com.siberiadante.lib.view.base.nicedialog.ViewConvertListener;
import com.siberiadante.lib.view.base.nicedialog.ViewHolder;

public class DialogActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = DialogActivity.class.getSimpleName();
    private SDEnsureDialog ensureDialog;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ScreenUtil.setStatusTranslucent(this);
        initView();
        initData();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    private void initView() {
        findViewById(R.id.btn_general_dialog_one).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_two).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_three).setOnClickListener(this);
        findViewById(R.id.btn_general_dialog_four).setOnClickListener(this);
        findViewById(R.id.btn_bottom_popup_widow).setOnClickListener(this);
        findViewById(R.id.btn_edit_dialog).setOnClickListener(this);
        findViewById(R.id.btn_share_dialog).setOnClickListener(this);
        findViewById(R.id.btn_friend_setting).setOnClickListener(this);
        findViewById(R.id.btn_comment_dialog).setOnClickListener(this);
        findViewById(R.id.btn_red_package_dialog).setOnClickListener(this);
        findViewById(R.id.btn_loading_dialog).setOnClickListener(this);
        findViewById(R.id.btn_custom_dialog).setOnClickListener(this);
        findViewById(R.id.btn_notice_dialog).setOnClickListener(this);
//        findViewById(R.id.btn_ensure_dialog_1).setOnClickListener(this);
        SDTitleBar SDTitleBar = ((SDTitleBar) findViewById(R.id.titleBar_dialog_activity));
        initTitle(SDTitleBar);
    }

    private void initTitle(SDTitleBar SDTitleBar) {
        SDTitleBar.setImmersive(true);
        SDTitleBar.setTitle("各种Dialog组件封装");
        SDTitleBar.setSubTitle("SiberiaDante");
        SDTitleBar.setSubTitleColor(ContextCompat.getColor(this, R.color.gray));
        SDTitleBar.setLeftImage(R.mipmap.back);
        SDTitleBar.setLeftText("返回");
        SDTitleBar.setRightImage(R.mipmap.search);
        SDTitleBar.setDivideBackground(ContextCompat.getColor(this, R.color.colorPrimary));
        SDTitleBar.setTitleListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SDToast.toast("点击了标题");
            }
        });
        SDTitleBar.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogActivity.this.finish();
            }
        });
        SDTitleBar.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SDToast.toast("点击了右侧");
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
            case R.id.btn_share_dialog:
                showShareDialog();
                break;
            case R.id.btn_friend_setting:
                showFriendSettingDialog();
                break;
            case R.id.btn_comment_dialog:
                showCommentDialog();
                break;
            case R.id.btn_red_package_dialog:
                showRedPackageDialog();
                break;
            case R.id.btn_loading_dialog:
                showLoadingDialog();
                break;
            case R.id.btn_custom_dialog:
                showCustomDialog();
                break;
            case R.id.btn_notice_dialog:
                showNoticeDialog();
                break;

        }
    }


    private void showNoticeDialog() {
        final SDEnsureSubDialog sdEnsureSubDialog = new SDEnsureSubDialog(this);//提示弹窗
        sdEnsureSubDialog.setTitle("SiberiaDante");
        sdEnsureSubDialog.setContent(getString(R.string.about_me));
        sdEnsureSubDialog.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sdEnsureSubDialog.cancel();
            }
        });
        sdEnsureSubDialog.show();
    }

    /**
     * SDEditDialog
     */
    private void showEditDialog() {
        final SDEditDialog dialog = new SDEditDialog(this).builder();
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
                SDToast.toast("输入内容为：" + msg);
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
     * SDEnsureDialog
     */
    private void showEnsureDialogOne() {
        ensureDialog = new SDEnsureDialog(this).builder()
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
        ensureDialog = new SDEnsureDialog(this).builder()
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
        ensureDialog = new SDEnsureDialog(this).builder()
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
        ensureDialog = new SDEnsureDialog(this).builder()
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

    /**
     * share dialog
     */
    private void showShareDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.share_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.wechat, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SDToast.toast("分享成功");
                            }
                        });
                    }
                })
                .setDimAmount(0.3f)
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    /**
     * friend setting dialog
     */
    private void showFriendSettingDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.friend_set_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {

                    }
                })
                .setShowBottom(true)
                .setHeight(310)
                .show(getSupportFragmentManager());
    }

    /**
     * comment dialog
     */
    private void showCommentDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.comment_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        final EditText editText = holder.getView(R.id.edit_input);
                        editText.post(new Runnable() {
                            @Override
                            public void run() {
                                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                imm.showSoftInput(editText, 0);
                            }
                        });
                    }
                })
                .setShowBottom(true)
                .show(getSupportFragmentManager());
    }

    /**
     * red package dialog
     */
    private void showRedPackageDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.ad_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.setOnClickListener(R.id.close, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });
                    }
                })
                .setWidth(210)
                .setOutCancel(false)
                .setAnimStyle(R.style.EnterExitAnimation)
                .show(getSupportFragmentManager());
    }

    /**
     * loading dialog
     */
    private void showLoadingDialog() {
        NiceDialog.init()
                .setLayoutId(R.layout.loading_layout)
                .setWidth(100)
                .setHeight(100)
                .setDimAmount(0)
                .show(getSupportFragmentManager());
    }

    private void showCustomDialog() {
        final SDCustomDialog customDialog = new SDCustomDialog(this, R.layout.dialog_layout, new int[]{R.id.dialog_sure}, 0, true, Gravity.CENTER);
        customDialog.setOnCenterItemClickListener(new SDCustomDialog.OnCenterItemClickListener() {
            @Override
            public void OnCenterItemClick(SDCustomDialog dialog, View view) {
//                customDialog.dismiss();
                SDToast.toast("确定按钮被点击了");
            }
        });
        customDialog.show();
    }

}
