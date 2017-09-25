# SiberiaDanteLib
>#### 旨在打造一款属于Android开发的强大工具库(部分代码资料来源网络，如有侵权，联系[本人](https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-Me.md)删除。持续更新维护中……）
>#### 项目包含library和sample，每个library中的工具类都在sample中作了测试，如遇到bug，烦请提交[Issuses](https://github.com/SiberiaDante/SiberiaDanteLib/issues)，万分感谢.使用中也可以参考sample.

[下载体验sample-apk](https://github.com/SiberiaDante/SiberiaDanteLib/tree/399733e8cfbd337d4e7562cc52cefec48890f545/doc/assets/sample/sample-debug.apk)
## 推荐
>* [Android开发必备经典收藏集（整理中）]
>* [TitleLayout——通用万能标题栏]
>* [CustomDialog——通用万能Dialog]

## gradle依赖方法
```
dependencies {
    compile 'com.github.SibreiaDante:SiberiaDanteLib:v1.0.3'
	}
```
## 使用说明

 * 使用之前需要在Application中初始化SiberiaDanteLib.initLib(context);
 * 开启Debug模式：SiberiaDanteLib.setDebug(true);
## [详细文档说明请看Wiki](https://github.com/SiberiaDante/SiberiaDanteLib/wiki)

> [版本更新说明](https://github.com/SiberiaDante/SiberiaDanteLib/blob/d30aec89d5a4972db5ee018a0f9127641b18f8a0/doc/VERSION_UPDATE.md)

## SD-view
### <a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-SD-Dialog">SD-Dialog</a>

<table>
    <tr style="color:red">
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

### <a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-SD-TitleBar">SD-TitleBar</a>
<table >
    <tr>
        <th colspan="2" style="color:red">标题栏</th>
    </tr>
    <tr>
        <td>SDTitleBar</td>
        <td>常规的titleBar的封装</td>
    </tr>
    <tr>
        <td>SDTitleLayout</td>
        <td>常规的能够满足开发需求的标题栏的封装</td>
    </tr>
</table>

### <a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-SD-View">其他SD-View相关</a>
<table >
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

## <a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-SD-Widget">SD-Widget</a>

<table>
    <tr style="color:red">
        <th>SD-Widget相关类</th>
        <th>SD-Widget相关类简要说明</th>
    </tr>
    <tr>
        <td>SDCenterAlignImageSpan</td>
        <td>图文混排对齐</td>
    </tr>
    <tr>
        <td>SDHexagonView</td>
        <td>正六边形TextView</td>
    </tr>
    <tr>
        <td>SDJustifyTextView</td>
        <td>适用文字对齐，错乱修正等；原文地址：https://github.com/ufo22940268/android-justifiedtextview</td>
    </tr>
    <tr>
        <td>SDLetterSpaceTextView</td>
        <td>可设置文字间距的TextView</td>
    </tr>
    <tr>
        <td>SDRadioButton</td>
        <td>可设置图片大小的RadioButton</td>
    </tr>
    <tr>
        <td>SDRoundFrameLayout</td>
        <td>可在布局中直接设置shape相关的属性（背景颜色、角度等）</td>
    </tr>
    <tr>
        <td>SDRoundImage</td>
        <td>圆形ImageView控件,直接在布局中使用</td>
    </tr>
    <tr>
        <td>SDRoundLinearLayout</td>
        <td>可在布局中直接设置shape相关的属性（背景颜色、角度等）</td>
    </tr>
    <tr>
        <td>SDRoundRelativeLayout</td>
        <td>可在布局中直接设置shape相关的属性（背景颜色、角度等）</td>
    </tr>
    <tr>
        <td>SDRoundTextView</td>
        <td>可在布局中直接设置shape相关的属性（背景颜色、角度等）</td>
    </tr>
    <tr>
        <td>SuperTextView</td>
        <td>超酷炫的TextView，可以设置出各种特效文字</td>
    </tr>
</table>

## <a href="https://github.com/SiberiaDante/SiberiaDanteLib/wiki/About-SD-Util">SD-Util</a>

<table>
    <tr style="color:red">
        <th>SD-Util相关类</th>
        <th>SD-Util相关类简要说明</th>
    </tr>
    <tr>
        <td>SDActivityUtil</td>
        <td>页面跳转、传值、启动应用等工具类</td>
    </tr>
    <tr>
        <td>SDAppUtil</td>
        <td>获取应用、手机、安卓系统等信息,安装应用等</td>
    </tr>
    <tr>
        <td>SDBitmapUtil</td>
        <td>图片处理相关工具类</td>
    </tr>
    <tr>
        <td>SDClearUtil</td>
        <td>清除缓存、数据、文件、数据库等相关工具类</td>
    </tr>
    <tr>
        <td>SDCloseUtil</td>
        <td>关闭流等相关工具类</td>
    </tr>
    <tr>
        <td>CrashHandler</td>
        <td>Crash异常处理等相关工具类</td>
    </tr>
    <tr>
        <td>SDDateUtil</td>
        <td>时间、日期转换</td>
    </tr>
    <tr>
        <td>SDEncryptUtil</td>
        <td>加密算法相关工具类</td>
    </tr>
    <tr>
        <td>SDFileUtil</td>
        <td>文件处理相关工具类</td>
    </tr>
    <tr>
        <td>SDIntentUtil</td>
        <td>Intent相关工具类</td>
    </tr>
    <tr>
        <td>SDKeyBoardUtil</td>
        <td></td>
    </tr>
    <tr>
        <td>SDLogUtil</td>
        <td>日志打印控制工具类</td>
    </tr>
    <tr>
        <td>SDMathUtil</td>
        <td></td>
    </tr>
    <tr>
        <td>SDNetWorkUtil</td>
        <td>判断网络连接、获取网络类型等</td>
    </tr>
    <tr>
        <td>SDNumberUtil</td>
        <td>数字工具类</td>
    </tr>
    <tr>
        <td>SDProcessUtil</td>
        <td></td>
    </tr>
    <tr>
        <td>SDScreenUtil</td>
        <td>获取屏幕宽高、设置状态栏、导航栏、全屏、截图等相关工具类</td>
    </tr>
    <tr>
        <td>SDShellUtil</td>
        <td></td>
    </tr>
    <tr>
        <td>SDSnackBarUtil</td>
        <td></td>
    </tr>
    <tr>
        <td>SDSPUtil</td>
        <td>SharedPreference的封装，用来储存数据</td>
    </tr>
    <tr>
        <td>SDStorageUtil</td>
        <td>SD卡处理以及存储相关工具类</td>
    </tr>
    <tr>
        <td>SDStringUtil</td>
        <td>字符处理相关工具类</td>
    </tr>
    <tr>
        <td>SDToast</td>
        <td>toast吐司工具类</td>
    </tr>
    <tr>
        <td>SDTransitionUtil</td>
        <td>dp、px、sp等转换相关工具类</td>
    </tr>
    <tr>
        <td>SpannableStringUtil</td>
        <td></td>
    </tr>
</table>

 参考:https://github.com/Blankj/AndroidUtilCode

<!--  推荐-->
[Android开发必备经典收藏集（整理中）]:http://www.jianshu.com/p/a49081da249a
[TitleLayout——通用万能标题栏]:https://github.com/SiberiaDante/TitleLayout
[CustomDialog——通用万能Dialog]:https://github.com/SiberiaDante/CustomDialog