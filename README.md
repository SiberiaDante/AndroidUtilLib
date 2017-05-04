# SiberiaDanteLib
### 旨在打造一款属于自己的强大工具库，Come on！！！
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
* 内置三方框架如下（自己项目中无须再次添加）
	* picasso图片加载框架:    compile 'com.squareup.picasso:picasso:2.5.2'
	* PhotoView:compile '    com.github.chrisbanes:PhotoView:2.0.0'
## util
* NetWorkUtil:网络连接、类型等
* TransitionTools:dp、px转换
* DateUtil：时间、日期转换
* Toast:单例模式的toast
* AppUtil:获取应用、手机、安卓系统等信息
* FileUtil:获取应用缓存、获取文件大小、清除应用缓存、格式化文件单位等
* ScreenUtil:获取屏幕的宽高
## view
* TabRadioButton:可设置图片尺寸
* PicassoCircleTransfer:Picasso加载图片时将图片转换为圆形
* PhotoViewPager：可左右滑动照片查看器(sample/activity/PhotoViewActivity)
## src/main.note
* note-one
    * 友盟多渠道打包

