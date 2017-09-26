<h1>目录</h1>
<h4>
    <a href="#sdcustomdialog">SDCustomDialog</a>
</h4>
<h4>
    <a href="#sdnicedialog">SDNiceDialog</a>
</h4>
<h4>
    <a href="#sdbottomdialog">SDBottomDialog</a>
</h4>
<h4>
    <a href="">SDEditDialog</a>
</h4>
<h4>
    <a href="">SDEnsureDialog</a>
</h4>
<h4>
    <a href="">SDEnsureSubDialog</a>
</h4>

<h3>
    <a name="sdcustomdialog" id="sdcustomdialog">一、SDCustomDialog</a>
</h3>
* 使用中，只需要传入自定义的Dialog布局和需要给Dialog设置点击事件的控件即可，如：

```
final SDCustomDialog customDialog = new SDCustomDialog(this, R.layout.dialog_layout, new int[]{R.id.dialog_sure, R.id.dialog_cancel});
        customDialog.setOnCenterItemClickListener(new SDCustomDialog.OnCustomDialogItemClickListener() {
            @Override
            public void OnCustomDialogItemClick(SDCustomDialog dialog, View view) {
                switch (view.getId()) {
                    case R.id.dialog_cancel:
                        customDialog.dismiss();
                        SDToast.toast("取消按钮被点击了");
                        break;
                    case R.id.dialog_sure:
                        customDialog.dismiss();
                        SDToast.toast("确定按钮被点击了");
                        break;
                }
            }
        });
        customDialog.show();
```
* 想要支持更多自定义设置，使用如下构造，了解更多请阅读源码
```
   /**
     * 属性说明
     *
     * 第一个属性 context
     * 第二个属性 layoutResID    自己定义的布局
     * 第三个属性 listenedItems  需要设置点击事件的资源id
     * 第四个属性 animationResId dialog 弹出动画，如果不使用自己的，则传0
     * 第五个属性 isDismiss      按钮点击后是否默认取消dialog {@code true}取消 {@code false} 不取消
     * 第六个属性 position       dialog 显示位置，默认CENTER,不设置时可以传0
     */
final SDCustomDialog customDialog = new SDCustomDialog(this, R.layout.dialog_layout, new int[]{R.id.dialog_sure, R.id.dialog_cancel}, 0, true, Gravity.CENTER);
        customDialog.setOnCenterItemClickListener(new SDCustomDialog.OnCustomDialogItemClickListener() {
            @Override
            public void OnCustomDialogItemClick(SDCustomDialog dialog, View view) {
                switch (view.getId()) {
                    case R.id.dialog_cancel:
                        customDialog.dismiss();
                        SDToast.toast("取消按钮被点击了");
                        break;
                    case R.id.dialog_sure:
                        customDialog.dismiss();
                        SDToast.toast("确定按钮被点击了");
                        break;
                }

            }
        });
        customDialog.show();
```

<h3>
    <a name="sdnicedialog" id="sdnicedialog">二、SDNiceDialog</a>
</h3>
*基本使用：传入dialog布局即可，可通过holder.getView()获取子控件做相应的处理

```
SDNiceDialog.init()
                .setLayoutId(R.layout.friend_set_layout)
                .setConvertListener(new ViewConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                        holder.getView(R.id.tv_friend_label).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                SDToast.toast("设置备注和标签按钮被点击");
                                dialog.dismiss();
                            }
                        });

                    }
                })
                .setShowBottom(true)
                .setHeight(310)
                .show(getSupportFragmentManager());
```
* 其他属性说明
```
          .setDimAmount(0.3f)     //调节灰色背景透明度[0-1]，默认0.5f
          .setShowBottom(true)     //是否在底部显示dialog，默认flase
          .setMargin()     //dialog左右两边到屏幕边缘的距离（单位：dp），默认0dp
          .setWidth()     //dialog宽度（单位：dp），默认为屏幕宽度，-1代表WRAP_CONTENT
          .setHeight()     //dialog高度（单位：dp），默认为WRAP_CONTENT
          .setOutCancel(false)     //点击dialog外是否可取消，默认true
          .setAnimStyle(R.style.EnterExitAnimation)     //设置dialog进入、退出的动画style(底部显示的dialog有默认动画)
          .show(getSupportFragmentManager());     //显示dialog
```
<h3>
    <a name="" id="">三、SDBottomDialog</a>
</h3>
<h3>
    <a name="" id="">四、SDEditDialog</a>
</h3>
<h3>
    <a name="" id="">五、SDEnsureDialog</a>
</h3>
<h3>
    <a name="" id="">六、SDEnsureSubDialog</a>
</h3>

