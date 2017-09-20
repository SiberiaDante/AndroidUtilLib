# SiberiaDanteLib
#### 旨在打造一款属于Android开发的强大工具库(部分代码资料来源网络，如有侵权，联系[本人](https://github.com/SiberiaDante/SiberiaDanteLib/blob/d7af8c2c6ec7ccfd9ddce8044efeea717ecb2944/ABOUTME.md)删除。持续更新维护中……）
#### 项目包含library和sample，每个library中的工具类都在sample中作了测试，使用中也可以参考sample.
#### 所有util、view本人都经过亲测，可用，如遇到bug，烦请提交[Issuses](https://github.com/SiberiaDante/SiberiaDanteLib/issues)，万分感谢
#### 欢迎关注：
* [Github 地址：https://github.com/SibreiaDante/SiberiaDanteLib]
* [博客园:http://www.cnblogs.com/shen-hua/]
* [email:994537867@qq.com] [siberiadante@gmail.com]
* 关注我的微信公众号: [tstongxiao]
## 推荐
### [Android开发必备经典收藏集（整理中）]
### [TitleLayout——通用万能标题栏]
### [CustomDialog——通用万能Dialog]
## gradle依赖方法
```
dependencies {
    compile 'com.github.SibreiaDante:SiberiaDanteLib:1.0.3'
	}
```
### 说明
* 使用之前需要在Application中初始化SiberiaDanteLib.initLib(context);
* 开启Debug模式：SiberiaDanteLib.setDebug(true);
## view
* [EditDialog] :仿IOS弹出可编辑dialog([使用:sample/activity/DialogActivity])
* [BottomPopupWindow] :仿IOS底部弹出可拓展dialog([使用:sample/activity/DialogActivity])
* [EnsureDialog] 常规提示确认dialog([使用:sample/activity/DialogActivity])
* [PicassoCircleTransfer] :Picasso加载图片时将图片转换为圆形工具
* [QQStepView] :自定义View实现仿QQ运动步数功能([使用:sample/activity/QQStepViewActivity])
* [TitleBar] :常规的titleBar的封装，一般的titleBar均可([使用:TitleBar使用说明])
## widget
* [CenterAlignImageSpan] :图文混排对齐
* [HexagonView] :正六边形
* [JustifyTextView] :适用文字对齐，错乱修正等；原文地址：https://github.com/ufo22940268/android-justifiedtextview
* [PhotoViewPager] :可左右滑动照片查看器(案例：[使用:sample/activity/PhotoViewActivity])
* [RoundImage] :圆形ImageView控件,直接在布局中使用([使用:sample/res/layout/fragment_view.xml])
* [RoundFrameLayout] :可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [RoundLinearLayout] :可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [RoundRelativeLayout] :可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [RoundTextView] :可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [SuperTextView]：超酷炫的TextView，可以设置出各种特效文字(原文地址：http://www.jianshu.com/p/1b91e11e441d)
* [TabRadioButton] :可设置图片尺寸的RadioButton，适用于图文结合的RadioButton

## util(工具类详细说明文档看[这里])
* [ActivityUtil] :页面工具类
* [AppUtil] :获取应用、手机、安卓系统等信息,支持7.0的安装异常，需测试
* [ClearUtil] :清除缓存、数据等相关应用
* [CloseUtil] :关闭相关工具类
* [CrashHandler]
* [DateUtil] ：时间、日期转换
* [EncryptUtil] :加密算法相关工具类
* [FileUtil] :文件处理相关工具类
* [IntentUtil] ：Intent相关工具类
* [LogUtil] ：日志打印控制工具类
* [NetWorkUtil] :网络连接、类型等
* [NumberUtil] :数字工具类
* [ProcessUtil]
* [ScreenUtil] :屏幕相关工具类
* [SDCardUtil] ：SD卡以及存储相关工具类
* [ShellUtils]
* [SPUtil] ：SharedPreference的封装，用来储存数据([使用:sample/src/constants/AppInfo.java])
* [StringUtil] :字符处理相关工具类
* [ToastUtil] :toast吐司工具类(看下代码自己就可以用Toast写出各种各样的界面）
* [TransitionTools] :dp、px转换

* 参考资料：https://github.com/Blankj/AndroidUtilCode
<!--  View-->
[EditDialog]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/EditDialog.java
[BottomPopupWindow]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/BottomPopupWindow.java
[EnsureDialog]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/EnsureDialog.java
[PicassoCircleTransfer]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/PicassoCircleTransfer.java
[QQStepView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/QQStepView.java
[TitleBar]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/TitleBar.java

<!--  widget-->
[JustifyTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/JustifyTextView.java
[PhotoViewPager]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/PhotoViewPager.java
[RoundImage]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/RoundImage.java
[RoundFrameLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/RoundFrameLayout.java
[RoundLinearLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/RoundLinearLayout.java
[RoundRelativeLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/RoundRelativeLayout.java
[RoundTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/RoundTextView.java
[SuperTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SuperTextView.java
[TabRadioButton]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/TabRadioButton.java

<!--  sample-->
[使用:sample/activity/DialogActivity]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/sample/src/main/java/com/sample/ui/activity/view/DialogActivity.java
[使用:sample/activity/PhotoViewActivity]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/sample/src/main/java/com/sample/ui/activity/view/PhotoViewActivity.java
[使用:sample/activity/QQStepViewActivity]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/sample/src/main/java/com/sample/ui/activity/view/QQStepViewActivity.java
[使用:sample/res/layout/fragment_view.xml]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/sample/src/main/res/layout/fragment_view.xml
[使用:TitleBar使用说明]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/note/TitleBar.md
[使用:sample/src/constants/AppInfo.java]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/sample/src/main/java/com/sample/constants/AppInfo.java





<!--  util-->
[ActivityUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/ActivityUtil.java
[AppUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/AppUtil.java
[ClearUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/ClearUtil.java
[CloseUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/CloseUtil.java
[DateUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/DateUtil.java
[EncryptUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/EncryptUtil.java
[FileUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/FileUtil.java
[IntentUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/IntentUtil.java
[LogUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/LogUtil.java
[NetWorkUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/NetWorkUtil.java
[NumberUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/lib/util/NumberUtil.java
[ScreenUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/ScreenUtil.java
[StringUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/StringUtil.java
[TransitionTools]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/TransitionTools.java
[ToastUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/ToastUtil.java

[这里]:https://github.com/SiberiaDante/SiberiaDanteLib


<!--  微信公众号图片&&top&&mine-->
[tstongxiao]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/sample/src/main/assets/images/qrcode.jpg

<!--  推荐-->
[Android开发必备经典收藏集（整理中）]:http://www.jianshu.com/p/a49081da249a
[TitleLayout——通用万能标题栏]:https://github.com/SiberiaDante/TitleLayout
[CustomDialog——通用万能Dialog]:https://github.com/SiberiaDante/CustomDialog