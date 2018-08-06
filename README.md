# SiberiaDanteLib
>#### 旨在打造一款属于Android快速开发的强大工具库
>#### 项目包含library和sample，每个library中的工具类都在sample中作了测试，如遇到bug，烦请提交[Issuses](https://github.com/SiberiaDante/SiberiaDanteLib/issues)，万分感谢.使用中也可以参考sample.

[![](https://jitpack.io/v/SiberiaDante/AndroidUtilLib.svg)](https://jitpack.io/#SiberiaDante/AndroidUtilLib)

```
compile 'com.github.SiberiaDante:AndroidUtilLib:***'
```
初始化
```
 SDAndroidLib.initLib(context);//初始化
 SDAndroidLib.setDebug(true);//开启Debug模式
```

### 文档更新跟不上，具体使用参考 utilsample

SD-Util
```
SDActivityUtil                      Activity相关处理工具类
SDAppUtil                           获取应用、手机、安卓系统等信息,安装应用等
SDBitmapUtil                        图片处理相关工具类
SDCacheUtil                         缓存相关工具类
SDCleanUtil                         清除缓存、数据、文件、数据库等相关工具类
SDCloseUtil                         关闭流等相关工具类
CrashHandler                        Crash异常处理等相关工具类
SDDataUtil                          对象处理相关类
SDDateUtil                          时间、日期转换
SDDeviceUtil                        手机设备相关处理类
SDDrawableUtil                      drawable 相关处理工具类
SDEncryptUtil                       加密算法相关工具类
SDFileUtil                          文件处理相关工具类
SDFormatUtil                        格式化相关处理工具类
SDIntentUtil                        Intent相关工具类
SDJumpUtil                          页面跳转、打开浏览器、发送短信、设置面板等工具类
SDKeyBoardUtil                      键盘相关工具类
SDLogUtil                           日志打印控制工具类
SDMathUtil                          数学公式计算工具类
SDNetWorkUtil                       判断网络连接、获取网络类型等
SDNumberUtil                        数字工具类
SDObjectUtil                        对象处理工具类
SDPhotoUtils                        调用系统相机、相册、裁剪等工具类
SDProcessUtil
SDRegexUtil                         正则验证相关工具类
SDScreenUtil                        获取屏幕宽高、设置状态栏、导航栏、全屏、截图等相关工具类
SDShellUtil
SDSnackBarUtil
SDSPUtil                            SharedPreference的封装，用来储存数据
SDStorageUtil                       SD卡处理以及存储相关工具类
SDStringUtil                        字符处理相关工具类
SDTimerUtil                         计时相关工具类
SDToastUtil                         toast吐司工具类
SDTransitionUtil                    数据、数值转换相关类
```
加解密、校验相关工具类
```
SD3DesUtil
SDAESUtil
SDBase64Util
SDDESUtil
SDEncryptUtil
SDMD2Util
SDMD5Util
SDRSAUtil
SDSHA1Util
SDSHA224Util
SDSHA256Util
SDSHA384Util
SDSHA512Util
```
动画相关
```
SDZoomImageView         缩放一张图片的动画
SDSkipLoadView          跳跃动画
SDRotateLayoutImageView 旋转一张图片的动画
SDCircleTranslationX    仿百度圆加载动画
SDCircleMove            仿百度圆加载动画
```
Dialog相关
```
SDBottomItemDialog          仿IOS底部弹出可拓展多个item的dialog     
SDCustomDialog              通用可自定义的dialog,可以传入任何自定义的布局
SDEditDialog                仿IOS弹出可编辑dialog
SDEnsureDialog              常规提示确认dialog
```

自定义View
```
SDStepView          仿QQ运动步数功能
```

RecyclerView 分隔线
```
SDDrawableDecoration        RecyclerView 分隔线，可传入一个Drawable对象作为分割线
SDNormalDecoration          RecyclerView 分隔线,可设置颜色和高度
```
SD-Widget相关类
```
SDLineEditText              自定义下划线的EditText
SDCashierInputFilter        格式化EditText只能输入金额格式的数字
SDFlowTagLayout             自适应的标签流式布局，适用于搜索历史、标签等
SDShapeFrameLayout          简化FrameLayout shape 画背景
SDAvatarListLayout          头像列表叠加组件
SDCircleImageView           圆形ImageView，可设置描边相关等
SDNotifyImageView           带通知圆点的ImageView
SDRoundImageView            可以设置ImageView 圆角、圆等
SDFullyGridLayoutManager    解决ScrollView嵌套RecyclerView的问题
SDFullyLinearLayoutManager  解决ScrollView嵌套RecyclerView的问题
SDFullyStaggeredGridLayoutManager   解决ScrollView嵌套RecyclerView的问题
SDShapeLinearLayout         简化LinearLayout shape 画背景
SDDrawableRadioButton       可设置图片大小的RadioButton
SDNotifyRadioButton         带通知圆点的RadioButton
SDShapeRelativeLayout       简化RelativeLayout shape 画背景
SDHexagonView               正六边形TextView
SDLetterIndexView           字母索引组件
SDRatingBarView             评分组件
SDTitleLayout               通用的标题栏，支持动态修改、沉浸式等
SDVerificationCodeView      验证码/密码方框格式输入控件
SDAdaptiveTextView          解决TextView的内容中包含中英文导致自动换行bug
SDFoldTextView
SDShapeTextView             简化TextView shape 画背景
SDLetterSpaceTextView
SuperTextView
SDCenterAlignImageSpan      图文混排对齐的ImageSpan
```

标题栏[【详细使用方法和介绍点这里查看】](https://github.com/SiberiaDante/TitleLayout)
```
SDTitleLayout       常规的能够满足开发需求的标题栏的封装，并支持Java代码设置
```


## [版本更新说明]
* v1.1.4(未发布)
    * SDLineEditText：增加下划线高度、下划线paddingTop
    * SDTitleLayout：修复设置左右图片Padding造成的问题
    * SDBottomItemDialog:支持Item颜色、字体大小设置；支持底部取消按钮隐藏；支持Item超过7条时滚动显示或者全部显示
* v1.1.3
    * SDVerificationCodeView：验证码/密码输入框
    * SDTitleLayout 增加动态设置背景颜色，增加相应子View是否可点击等
* v1.1.2
    * SDCashierInputFilter：格式化EditText金额输入规则
    * SDFlowTagLayout：自适应的标签流式布局，适用于搜索历史、标签等
* v1.1.1
    * 增加SDPhotoUtil:拍照、相册操作、裁剪相关工具类
    * 增加组件SDRoundImageView：支持设置ImageView圆角、圆形
    * SDNormalDecoration增加支持设置左右间距
* v1.1.0
    大版本更新，重构项目结构等
* 1.0.8
    * 更新SDActivityUtil
    * 更新SDDateUtil
    * 更新SDNumberUtil
    * 更新SDScreenUtil
    * 更新SDStringUtil
    * 增加SDPhoneUtil
    * 增加SDRegexUtil
    * 增加SDRegexConstants
    * 增加SDSkipLoadView
    * 增加SDShapeChangeView
    * 增加SDRatingBarView
    * 增加SDLetterIndexView
* 1.0.7
    * 增加SDBitmapUtil
    * 增加SDCustomDialog
    * 增加SDLogUtil


