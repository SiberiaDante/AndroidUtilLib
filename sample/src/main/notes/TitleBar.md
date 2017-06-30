## TitleBar
## [Github 地址：https://github.com/SibreiaDante/SiberiaDanteLib]
### 主要实现：（后续会继续完善，喜欢的给个star，感谢支持）
* 使用方法：
```
allprojects {
    repositories {
	 ...
	 aven { url 'https://jitpack.io' }
	}
}
```
```
dependencies {
    compile 'com.github.SibreiaDante:SiberiaDanteLib:1.0.2'
	}
```
* 在xml中
```
    com.siberiadante.widget.TitleBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```
* 项目使用沉浸式状态栏的话，设置titleBar沉浸式：
```
 titleBar.setImmersive(true);
 ```
* 左侧以返回关功能为主：不显示内容或者显示图片+文字（仿IOS），可自己设置图片、文字，也可以使用默认文字图片
```
        titleBar.setLeftImage(R.mipmap.back);
        titleBar.setLeftText("返回");
        titleBar.setLeftListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.toast("点击了左侧");
                    }
                });
```
* 右侧可设置一个图片或者不显示内容，有监听事件
```
         titleBar.setRightImage(R.mipmap.search);
         titleBar.setRightListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                         ToastUtil.toast("点击了右侧");
                     }
                 });
```
* 设置标题（可设置主标题和副标题，可设置字体颜色、字体，标题点击监听）
```
        titleBar.setTitle("各种Dialog组件封装");
        titleBar.setSubTitle("SiberiaDante");
        titleBar.setSubTitleColor(getResources().getColor(R.color.gray));
        titleBar.setTitleListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.showTextLong("点击了标题");
                    }
                });
 ```               
* TitleBar设置底部分割线，可以是颜色、图片等
```
        titleBar.setDivideBackground(getResources().getColor(R.color.colorPrimary));
```