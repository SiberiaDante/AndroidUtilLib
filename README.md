# SiberiaDanteLib
>#### 旨在打造一款属于Android开发的强大工具库(部分代码资料来源网络，如有侵权，联系[本人](https://github.com/SiberiaDante/SiberiaDanteLib/blob/d30aec89d5a4972db5ee018a0f9127641b18f8a0/doc/ABOUTME.md)删除。持续更新维护中……）
>#### 项目包含library和sample，每个library中的工具类都在sample中作了测试，使用中也可以参考sample.
>#### sample已内置Fragment懒加载、侧滑返回等许多主流技术
>#### 所有util、view本人都经过亲测，可用，如遇到bug，烦请提交[Issuses](https://github.com/SiberiaDante/SiberiaDanteLib/issues)，万分感谢

[体验sample-apk](https://github.com/SiberiaDante/SiberiaDanteLib/tree/d30aec89d5a4972db5ee018a0f9127641b18f8a0/sample/sample-debug.apk)
## 推荐
>* [Android开发必备经典收藏集（整理中）]
>* [TitleLayout——通用万能标题栏]
>* [CustomDialog——通用万能Dialog]

## gradle依赖方法
```
dependencies {
    compile 'com.github.SibreiaDante:SiberiaDanteLib:v1.0.2'
	}
```
## 使用说明

 * 使用之前需要在Application中初始化SiberiaDanteLib.initLib(context);
 * 开启Debug模式：SiberiaDanteLib.setDebug(true);

> [版本更新说明](https://github.com/SiberiaDante/SiberiaDanteLib/blob/d30aec89d5a4972db5ee018a0f9127641b18f8a0/doc/VERSION_UPDATE.md)

## view
### Dialog相关

<table>
    <tr>
        <th colspan="2" style="color:red">Dialog相关View具体使用请点这里</th>
    </tr>
    <tr>
        <th>Dialog相关封装</th>
        <th>简单说明</th>
    </tr>
    <tr>
        <td>SDNiceDialog</a></td>
        <td>只需要传入布局id,可实现子View事件的监听、设置Dialog相关属性等</td>
    </tr>
    <tr>
        <td>SDBottomDialog</td>
        <td>仿IOS底部弹出可拓展多个item的dialog</td>
    </tr>
    <tr>
        <td>SDCustomDialog</td>
        <td>通用可自定义的dialog,可以传入任何自定义的布局</td>
    </tr>
    <tr>
        <td>SDEditDialog</td>
        <td>仿IOS弹出可编辑dialog</td>
    </tr>
    <tr>
        <td>SDEnsureDialog</td>
        <td>常规提示确认dialog</td>
    </tr>
    <tr>
        <td>SDEnsureSubDialog</td>
        <td>常规提示确认dialog,带标题，可设置log</td>
    </tr>
</table>

### 标题栏相关
<table border="1">
    <tr>
        <th colspan="2" style="color:red" ><a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-Title">标题栏详细说明请点这里</a></th>
    </tr>
    <tr>
        <td>SDTitleBar></td>
        <td>常规的titleBar的封装</td>
    </tr>
    <tr>
        <td>SDTitleLayout</td>
        <td>常规的能够满足开发需求的标题栏的封装</td>
    </tr>
</table>

### 其他View相关
<table border="1">
    <tr>
        <th colspan="2" style="color:red">其他View相关</th>
    </tr>
    <tr>
        <td>PicassoCircleTransfer</td>
        <td>Picasso加载图片时将图片转换为圆形工具</td>
    </tr>
    <tr>
        <td>QQStepView</td>
        <td> 自定义View实现仿QQ运动步数功能</td>
    </tr>
    <tr>
        <td></td>
        <td></td>
    </tr>
</table>

## widget
* [SDCenterAlignImageSpan]     图文混排对齐
* [SDHexagonView]             正六边形TextView
* [SDLetterSpaceTextView] 可设置文字间距的TextView
* [SDRoundFrameLayout] 可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [SDRoundImage] 圆形ImageView控件,直接在布局中使用
* [SDRoundLinearLayout] 可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [SDRoundRelativeLayout] 可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [SDRoundTextView] 可在布局中直接设置shape相关的属性（背景颜色、角度等）
* [SDRadioButtom] 可设置图片大小的RadioButton
* [SuperTextView]超酷炫的TextView，可以设置出各种特效文字(原文地址：http://www.jianshu.com/p/1b91e11e441d)
* [TabRadioButton] 可设置图片尺寸的RadioButton，适用于图文结合的RadioButton
* [JustifyTextView] 适用文字对齐，错乱修正等；原文地址：https://github.com/ufo22940268/android-justifiedtextview
* [PhotoViewPager] 可左右滑动照片查看器

## util(工具类详细说明文档看[Document_Util])
* [SDActivityUtil]                  页面工具类
* [SDAppUtil]                       获取应用、手机、安卓系统等信息,支持7.0的安装异常，需测试
* [SDClearUtil]                     清除缓存、数据等相关应用
* [SDCloseUtil]                     关闭相关工具类
* [CrashHandler]
* [SDDateUtil]                      时间、日期转换
* [SDEncryptUtil]                     加密算法相关工具类
* [SDFileUtil]                      文件处理相关工具类
* [SDIntentUtil]                    Intent相关工具类
* [SDKeyBoardUtil]
* [SDLogUtil]                       日志打印控制工具类
* [SDMathUtil]
* [SDNetWorkUtil]                   网络连接、类型等
* [SDNumberUtil]                    数字工具类
* [SDProcessUtil]
* [SDScreenUtil]                    屏幕相关工具类
* [SDShellUtil]
* [SDSnackBarUtil]
* [SDSPUtil]SharedPreference的封装，用来储存数据([使用:sample/src/constants/AppInfo.java])
* [SDStorageUtil]SD卡以及存储相关工具类
* [SDStringUtil] :字符处理相关工具类
* [SDToast] toast吐司工具类(看下代码自己就可以用Toast写出各种各样的界面）
* [SDTransitionUtil] dp、px转换
* [SpannableStringUtil]

 参考:https://github.com/Blankj/AndroidUtilCode

<!--  View-->

[PicassoCircleTransfer]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/PicassoCircleTransfer.java
[QQStepView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/view/QQStepView.java

<!--  widget-->
[JustifyTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/JustifyTextView.java
[PhotoViewPager]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/PhotoViewPager.java
[SuperTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SuperTextView.java

[SDCenterAlignImageSpan]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDCenterAlignImageSpan.java
[SDHexagonView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDHexagonView.java
[SDLetterSpaceTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDLetterSpaceTextView.java
[SDRadioButton]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRadioButton.java
[SDRoundFrameLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRoundFrameLayout.java
[SDRoundImage]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRoundImage.java
[SDRoundLinearLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRoundLinearLayout.java
[SDRoundRelativeLayout]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRoundRelativeLayout.java
[SDRoundTextView]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/widget/SDRoundTextView.java

<!--  util-->
[SDActivityUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDActivityUtil.java
[SDAppUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDAppUtil.java
[SDClearUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDClearUtil.java
[SDCloseUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDCloseUtil.java
[SDCrashHandler]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDCrashHandler.java
[SDDateUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDDateUtil.java
[SDEncryptUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDEncryptUtil.java
[SDFileUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDFileUtil.java
[SDIntentUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDIntentUtil.java
[SDKeyBoardUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDKeyBoardUtil.java
[SDLogUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDLogUtil.java
[SDMathUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDMathUtil.java
[SDNetWorkUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDNetWorkUtil.java
[SDNumberUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/lib/util/SDNumberUtil.java
[SDProgressUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/lib/util/SDProgressUtil.java
[SDScreenUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDScreenUtil.java
[SDShellUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDShellUtil.java
[SDSnackBarUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDSnackBarUtil.java
[SDSPUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDSPUtil.java
[SDStorageUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDStorageUtil.java
[SDStringUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDStringUtil.java
[SDToast]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDToast.java
[SDTransitionUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SDTransitionUtil.java
[SpannableStringUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/lib/util/SpannableStringUtil.java



<!--  推荐-->
[Android开发必备经典收藏集（整理中）]:http://www.jianshu.com/p/a49081da249a
[TitleLayout——通用万能标题栏]:https://github.com/SiberiaDante/TitleLayout
[CustomDialog——通用万能Dialog]:https://github.com/SiberiaDante/CustomDialog