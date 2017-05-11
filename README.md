# SiberiaDanteLib
### 旨在打造一款属于自己的强大工具库，Come on！！！
### 所有util、view本人都经过亲测，可用，如遇到bug，烦请告知修复，万分感谢
* Add it in your root build.gradle at the end of repositories:

`allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}`

* Step 2. Add the dependency

`dependencies {
compile 'com.github.SibreiaDante:SiberiaDanteLib:v1.0.1'
	}`
## 说明
* 使用之前需要在Application中初始化
    SiberiaDanteLib.initLib(context);
* 内置三方框架如下（自己项目中无须再次添加）
	* picasso图片加载框架:    compile 'com.squareup.picasso:picasso:2.5.2'
	* PhotoView:             compile 'com.github.chrisbanes:PhotoView:2.0.0'
* 内置已申明权限

## util
* [NetWorkUtil] :网络连接、类型等
    * isNetWorkConnected()：判断网络是否连接
    * isWifiConnected()：判断是否无线连接
    * is4GConnected()：判断是否4G连接
    * getNetworkState()：获取连接网络的状态类型
    * openNetworkSettings():打开网络设置面板
* [TransitionTools] :dp、px转换
* [DateUtil] ：时间、日期转换
    * getSDFTime(String str, String format):支持输出各种格式的日期、时间
    * date2TimeStamp(String date_str, String format):日期格式字符串转换成时间戳
    * getTimeStamp():取得当前时间戳（精确到秒）
* [ToastUtil] :toast吐司工具类(看下代码自己就可以用Toast写出各种各样的界面）
    * showSingletonLong(String content)：Toast文本，单例，长时间
    * showSingletonShort(String content)：Toast文本，单例，短时间
    * showTextShort(String content)：Toast文本，非单例，短时间
    * showTextLong(String content)：Toast文本，非单例，长时间
    * showSingletonImageCenter(int resId, int duration): Toast一张图片，单例，居中
    * showImageCenter(int resId,int duration)：Toast一张图片，非单例，居中
    * showSingletonImage(int resId, int duration, int position):Toast一张图片，单例，自定义位置
    * showImage(int resId, int duration, int position)：Toast一张图片，非单例，自定义位置
    * showITSingleton(int resId, String content, int duration, int position)：Toast图文，单例，自定义时长，自定义位置
    * showIT(int resId, String content, int duration, int position)：Toast图文，非单例，自定义时长，自定义位置
    * cancel():取消一个Toast，当弹出多个toast时，只会在最后一次toast被创建时取消
    * cancelAll():取消创建的所有的toast

* [AppUtil] :获取应用、手机、安卓系统等信息
* [FileUtil] :获取应用缓存、获取文件大小、清除应用缓存、格式化文件单位等
* [ScreenUtil] :获取屏幕的宽高
* [ActivityUtil] :页面工具类
    * launchActivity(String packageName, String activityName)：启动一个activity（不需要传值）
    * launchActivity(String packageName, String activityName, Bundle bundle)：启动一个activity（需要传值）
    * isActivityExists(String packageName, String activityName)：判断activity是否存在
## view
* [TabRadioButton] :可设置图片尺寸
* [PicassoCircleTransfer] :Picasso加载图片时将图片转换为圆形
* [PhotoViewPager] ：可左右滑动照片查看器(案例：sample/activity/PhotoViewActivity)
## src/main.note
* note-one
    * [友盟多渠道打包]
* note-two
    * [Android常用的系统广播]

#

[NetWorkUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/NetWorkUtil.java
[TransitionTools]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/TransitionTools.java
[DateUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/DateUtil.java
[ToastUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/ToastUtil.java
[AppUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/AppUtil.java
[FileUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/FileUtil.java
[ScreenUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/ScreenUtil.java
[ActivityUtil]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/util/ActivityUtil.java


[TabRadioButton]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/view/TabRadioButton.java
[PicassoCircleTransfer]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/view/PicassoCircleTransfer.java
[PhotoViewPager]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/java/com/siberiadante/view/PhotoViewPager.java


[友盟多渠道打包]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/note/note-one
[Android常用的系统广播]:https://github.com/SibreiaDante/SiberiaDanteLib/blob/master/siberiadante/src/main/note/note-two