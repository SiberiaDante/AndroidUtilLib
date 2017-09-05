# SiberiaDanteLib
#### 旨在打造一款属于Android开发的强大工具库(持续更新维护中……）
#### 项目包含library和sample，每个library中的工具类都在sample中作了测试，使用中也可以参考sample.
#### 所有util、view本人都经过亲测，可用，如遇到bug，烦请提交[Issuses](https://github.com/SiberiaDante/SiberiaDanteLib/issues)，万分感谢
#### 欢迎关注：
* [Github 地址：https://github.com/SibreiaDante/SiberiaDanteLib]
* [博客园:http://www.cnblogs.com/shen-hua/]
* [email:994537867@qq.com] [siberiadante@gmail.com]
* 关注我的微信公众号: [tstongxiao]
![微信公众号图片](/sample/src/main/assets/images/qrcode.jpg)
### [Android开发必备经典收藏集（整理中）]
## gradle依赖方法
* Step 1.Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
	 ...
	 maven { url 'https://jitpack.io' }
	}
}
```
* Step 2. Add the dependency

```
dependencies {
    compile 'com.github.SibreiaDante:SiberiaDanteLib:1.0.2'
	}
```
## maven依赖方法
* Step 1.Add the JitPack repository to your build file
```
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
```
* Step 2.Add the dependency
```
<dependency>
    <groupId>com.github.SibreiaDante</groupId>
    <artifactId>SiberiaDanteLib</artifactId>
    <version>1.0.2</version>
</dependency>
```
## module依赖方法
下载SiberiaDante，以module的方式导入项目，在build.gradle中添加代码：compile project(':siberiadante')
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
* [CenterAlignImageSpan] :
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

## util
* [ActivityUtil] :页面工具类
    * launchActivity(String packageName, String activityName)：启动一个activity（不需要传值）
    * launchActivity(String packageName, String activityName, Bundle bundle)：启动一个activity（需要传值）
    * isActivityExists(String packageName, String activityName)：判断activity是否存在
    * getLauncherActivity(String packageName)：获取应用的启动activity
* [AppUtil] :获取应用、手机、安卓系统等信息,支持7.0的安装异常，需测试
    * getAppPackageName() ：获取应用包名
    * isInstalledApp()：判断该应用是否安装
    * isInstalledApp(String packageName):判断APP是否安装
    * getAppVersionName():获取应用的版本名
    * getAppVersionName(String packageName)：获取应用的版本名
    * getAppVersionCode()：获取应用的版本号
    * getAndroidSystemVersion()：获取安卓手机系统版本号
    * getMobilePhoneTypeInfo():获取手机型号信息
    * getAndroidSystemVersion():获取安卓系统版本号
    * getMobilePhoneTypeInfo()：获取手机型号信息
    * getDeviceId()：获取手机设备的唯一标识
    * launchApp(String packageName):打开APP
    * launchApp(Activity activity, String packageName, int requestCode)：打开APP，设置请求code
    * openAppDetailsSettings()：打开当前应用的设置面板
    * openAppDetailsSettings(String packageName)：根据包名打开应用的设置面板
    * getAppName():获取应用名称
    * getAppName(String packageName) ：根据包名获取应用名称
    * getAppIcon()：获取应用图标
    * getAppIcon(String packageName)：根据包名获取应用图标
    * getAppPath()：获取APP路径
    * getAppPath(String packageName)：根据包名获取APP路径
    * isSystemApp():判断应用是否为系统应用
    * isSystemApp(String packageName)：根据包名判断是否为系统应用
    * isAppDebug() ：判断应用是否为debug版本
    * isAppDebug(String packageName)：根据包名判断是否为debug版本
    * isAppRoot()：判断应用是否具有root权限
    * unInstallApp(String packageName):卸载APP
    * unInstallApp(Activity activity, String packageName, int requestCode):卸载APP，设置请求码
    * uninstallAppSilent(String packageName, boolean isKeepData)：后台卸载APP---------<href>测试失败</href>
    * getAppSignature():获取应用签名
    * getAppSignature(String packageName)：根据包名获取应用签名
    * getAppSignatureSHA1():获取应用签名的SHA1
    * getAppSignatureSHA1(String packageName):根据包名获取应用签名SHA1
    * isAppInForeground():判断应用是否处于前台
    * isAppInForeground(String packageName)：根据包名判断应用是否处于前台
* [ClearUtil] :清除缓存、数据等相关应用
    * clearInternalCache():清除应用内部缓存
    * clearInternalFiles():清除应用内部文件
    * clearInternalDbs():清除应用内部数据库
    * clearInternalDbByName(String dbName):根据数据库名清除数据库
    * clearInternalSP():清除应用内部SharedPreferences
    * clearExternalCache():清除外部缓存
    * clearCustomCache(String dirPath)：清除自定义路径下的文件
    * clearCustomCache(File dir)：清除自定义路径下的文件
* [CloseUtil]
* [CrashHandler]
* [DateUtil] ：时间、日期转换
    * getSDFTime(String str, String format):支持输出各种格式的日期、时间
    * date2TimeStamp(String date_str, String format):日期格式字符串转换成时间戳
    * getTimeStamp():取得当前时间戳（精确到秒）
* [EncryptUtil] :加密算法相关工具类
    * encryptMD5StrLow32(String str)：生成MD5 32位小写密文
    * encryptMD5StrUp32(String str):生成MD5 32位大写
* [FileUtil] :文件处理相关工具类
    * getFileByPath(String filePath)：根据路径获取文件
    * isFileExists(String filePath)：根据路径判断文件是否存在
    * isFileExists(File file)：根据文件判断文件是否存在
    * rename(String filePath, String newName):重命名文件
    * rename(File file, String newName)：重命名文件
    * isDir(String dirPath):根据路径判断是否为目录/文件夹
    * isDir(File file)：根据文件判断是否为目录/文件夹
    * isFile(String filePath)：根据路径判断是否为文件
    * isFile(File file)：根据文件判断是否为文件
    * createOrIsExistsDir(String dirPath):根据路径判断目录是否存在，存在返回true，不存在则创建目录
    * createOrIsExistsDir(File file)：根据目录判断目录是否存在，存在返回true，不存在则创建目录
    * createOrIsExistsFile(String filePath)：根据路径判断文件是否存在，存在返回true，不存在则创建文件
    * createOrIsExistsFile(File file)：根据文件判断文件是否存在，存在返回true，不存在则创建文件
    * createFileByDeleteOldFile(String filePath):判断文件是否存在，存在则先删除，再创建
    * createFileByDeleteOldFile(File file) ：判断文件是否存在，存在则先删除，再创建
* [IntentUtil]
* [LogUtil] ：日志打印控制工具类
* [NetWorkUtil] :网络连接、类型等
    * isNetWorkConnected()：判断网络是否连接
    * isWifiConnected()：判断是否无线连接
    * is4GConnected()：判断是否4G连接
    * getNetworkState()：获取连接网络的状态类型
    * openNetworkSettings():打开网络设置面板
* [NumberUtil] :数字工具类
    * isNumeric(String str):是否全为数字
* [ProcessUtil]
* [ScreenUtil] :屏幕相关工具类
    * getDensity(Activity activity)：dp/px转换的倍率
    * getScreenWidthPx(Activity activity)：取屏幕的宽 单位：px
    * getScreenHeightPx(Activity activity)：获取屏幕的高 单位：px
    * getScreenWidthDp(Activity activity)：获取屏幕的宽 单位：dp
    * getScreenHeightDp(Activity activity)：获取屏幕的高 单位：dp
    * setStatusTranslucent(Activity activity):设置状态栏透明
    * setNavigationTranslucent(Activity activity)：设置导航栏透明
    * setTranslucent(Activity activity)：设置导航栏和状态栏同时透明
    * setFullScreen(Activity activity) ：设置页面全屏
    * getStatusBarHeight()：计算手机状态栏的高度
* [SDCardUtil]
* [ShellUtils]
* [SPUtil] ：SharedPreference的封装，用来储存数据([使用:sample/src/constants/AppInfo.java])
* [StringUtil] :字符处理相关工具类
    * toSBC(String text):半角转换为全角
    * removeSpecialString(String str):去除特殊字符或将所有中文标号替换为英文标号
    * isHaveString(String str1, String str2)：str1 中是否包含str2
* [ToastUtil] :toast吐司工具类(看下代码自己就可以用Toast写出各种各样的界面）
    * toast(String content):常用的单例Toast
    * showSingletonLong(String content)：Toast文本，单例，长时间
    * showSingletonShort(String content)：Toast文本，单例，短时间
    * showTextShort(String content)：Toast文本，非单例，短时间
    * showTextLong(String content)：Toast文本，非单例，长时间
    * showSingletonText(String content,int duration,int position ):Toast文本，自定义时长、位置
    * showSNBacText(String content, int duration, int position)：Toast 无背景透明的文本
    * showSingletonImageCenter(int resId, int duration): Toast一张图片，单例，居中
    * showImageCenter(int resId,int duration)：Toast一张图片，非单例，居中
    * showSingletonImage(int resId, int duration, int position):Toast一张图片，单例，自定义位置
    * showImage(int resId, int duration, int position)：Toast一张图片，非单例，自定义位置
    * showImage(Bitmap bitmap, int duration, int position):Toast一张图片，非单例，自定义位置
    * showITSingleton(int resId, String content, int duration, int position)：Toast图文，单例，自定义时长，自定义位置
    * showIT(int resId, String content, int duration, int position)：Toast图文，非单例，自定义时长，自定义位置
    * showLines(List<String> contents, int size):Toast 多行文本 非单例
    * showSingletonLines(List<String> contents, int size):Toast 多行文本 单例
    * showLayout(View view, int duration, int position):Toast 自定义布局 非单例
    * howSingletonLayout(View view, int duration, int position):Toast 自定义布局 单例
    * showThread(String url)：异步线程下载图片并Toast
    * cancel():取消一个Toast，当弹出多个toast时，只会在最后一次toast被创建时取消
    * cancelAll():取消创建的所有的toast
* [TransitionTools] :dp、px转换
    * getDensity():屏幕设备屏幕dip
    * dip2px( float dipValue): dp转px
    * dp2px( float dpValue): dp转px-API方法转
    * px2dip( float pxValue): px转dp
    * px2sp( float pxValue)：px转sp
    * sp2px( float spValue): sp转px


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




<!--  微信公众号图片&&top&&mine-->
[tstongxiao]:https://github.com/SiberiaDante/SiberiaDanteLib/blob/master/sample/src/main/assets/images/qrcode.jpg
[Android开发必备经典收藏集（整理中）]:http://www.jianshu.com/p/a49081da249a