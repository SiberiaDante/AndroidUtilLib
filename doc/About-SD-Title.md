<h1>目录</h1>
<h2>
    <a href="#sdtitlelayout">SDTitleLayout</a>
</h2>

<h2>
    <a href="#sdtitlebar">SDTitleBar</a>
</h2>


<h3>
    <a name="sdtitlelayout" id="sdtitlelayout">一、SDTitleLayout详细说明</a>
</h3>

<p>多功能、通用的、可在布局或者使用Java代码实现标题栏；支持沉浸式状态栏，支持左侧返回按钮（不需要手动实现页面返回），左侧支持图片+文字、图片、文字；右侧支持图片、文字等。</p>
<p> 图片有点虚，请见谅</p>

![图片](https://github.com/SiberiaDante/SiberiaDanteLib/blob/fef26b8dbc654f67c998c80fda5e9a7e9f114457/doc/assets/sd_title_layout.jpeg)

#### 在布局中使用：
```
<com.siberiadante.lib.view.titlebar.SDTitleLayout
        android:id="@+id/title_layout_one"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        sd:d_is_back_view="true"
        sd:d_is_immersive_state_bar="true"
        sd:d_left_image="@mipmap/back_gray"
        sd:d_left_image_padding_start="10dp"
        sd:d_left_image_width="30dp"
        sd:d_left_text="测试"
        sd:d_left_text_color="@color/black"
        sd:d_left_text_padding_start="10dp"
        sd:d_left_text_size="14sp"
        sd:d_line_height="1px"
        sd:d_right_text="举报"
        sd:d_right_text_color="@color/white"
        sd:d_right_text_size="14sp"
        sd:d_title_color="@color/black"
        sd:d_title_layout_background="@color/red"
        sd:d_title_layout_height="45dp"
        sd:d_title_size="18sp"
        sd:d_title_text="这里是标题" />
```
#### 使用Java代码：
```
  TitleBarLayout titleBarLayout = (TitleBarLayout) findViewById(R.id.title_layout);
        titleBarLayout.setTitleClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.d("title 被点击了");
            }
        });
        //设置Titlesize
        titleBarLayout.setTitleSize(30);
   //一键设置标题样式
        titleBarLayout.setTitleStyle("我是标题", 18, ContextCompat.getColor(this, R.color.action_sheet_blue));
        titleBarLayout.setRightImageClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtil.d("右边图片被点击了");
            }
        });
```
#### 重点说明：
* 若左侧文字或者按钮为返回键，只需要布局中使用如下代码即可：
    ```
    sd:d_is_back_view="true"
    ```
    或者Java代码中
    ```
    titleLayout.setIsLeftBackView(true)
    ```
    无须在设置onClickListener，this.finish等；如有特殊需要，可设置属性为false，实现方法：
    ```
    setLeftClickListener(OnClickListener listener)
    ```
* 若项目中使用了沉浸式状态栏,则需要在布局中
    ```
    sd:d_is_immersive_state_bar="true"
    ```
* 设置页面为沉浸式状态栏方法：
    ```
     ScreenUtil.setStatusTranslucent(this);
    ```

#### 其他属性说明
##### xml中的属性：
<table>
        <tr>
            <td>xml属性</td>
            <td>属性说明</td>
        </tr>
        <tr>
            <td>d_left_image</td>
            <td>左边图片资源</td>
        </tr>
        <tr>
            <td>d_left_image_width</td>
            <td>左边图片宽（高为匹配父布局）</td>
        </tr>
        <tr>
            <td>d_left_image_padding_start</td>
            <td>左边图片左边距（默认10dp）</td>
        </tr>
        <tr>
            <td>d_left_text</td>
            <td>左边文字资源</td>
        </tr>
        <tr>
            <td>d_left_text_size</td>
            <td>左边文字大小（默认16SP）</td>
        </tr>
        <tr>
            <td>d_left_text_color</td>
            <td>左边文字颜色（默认黑色）</td>
        </tr>
        <tr>
            <td>d_left_text_style</td>
            <td>后续完善该属性</td>
        </tr>
        <tr>
            <td>d_left_text_padding_start</td>
            <td>左边文字左边距（默认10dp）</td>
        </tr>
        <tr>
            <td>d_title_text</td>
            <td>中间标题文字资源</td>
        </tr>
        <tr>
            <td>d_title_size</td>
            <td>中间标题文字大小（默认18SP）</td>
        </tr>
        <tr>
            <td>d_title_color</td>
            <td>中间标题文字颜色（默认黑色）</td>
        </tr>
        <tr>
            <td>d_title_style</td>
            <td>后续完善该属性</td>
        </tr>
        <tr>
            <td>d_subtitle_text</td>
            <td>中间副标题文字资源</td>
        </tr>
        <tr>
            <td>d_subtitle_size</td>
            <td>中间副标题文字大小（默认12SP）</td>
        </tr>
        <tr>
            <td>d_subtitle_color</td>
            <td>中间副标题文字颜色（默认黑色）</td>
        </tr>
        <tr>
            <td>d_subtitle_style</td>
            <td>后续完善该属性</td>
        </tr>
        <tr>
            <td>d_right_text</td>
            <td>右边文字资源</td>
        </tr>
        <tr>
            <td>d_right_text_color</td>
            <td>右边文字颜色</td>
        </tr>
        <tr>
            <td>d_right_text_size</td>
            <td>右边文字大小（默认16sp）</td>
        </tr>
        <tr>
            <td>d_right_text_style</td>
            <td>后续完善该属性</td>
        </tr>
        <tr>
            <td>d_right_text_padding_end</td>
            <td>右边文字距离右边距</td>
        </tr>
        <tr>
            <td>d_right_image</td>
            <td>右边图片资源</td>
        </tr>
        <tr>
            <td>d_right_image_width</td>
            <td>右边图片宽度，高度为匹配父布局</td>
        </tr>
        <tr>
            <td>d_right_image_padding_end</td>
            <td>右边图片距离右边距</td>
        </tr>
        <tr>
            <td>d_line_height</td>
            <td>标题栏底部横线高度（默认1px，建议单位使用px）</td>
        </tr>
        <tr>
            <td>d_line_background</td>
            <td>标题栏底部横线背景颜色（默认黑色）</td>
        </tr>
        <tr>
            <td>d_title_layout_height</td>
            <td>标题栏整体高度（默认45dp）</td>
        </tr>
        <tr>
            <td>d_title_layout_background</td>
            <td>标题栏整体背景颜色</td>
        </tr>
        <tr>
            <td>d_is_back_view</td>
            <td>左侧文字和图片是否为返回键，若是返回键，则自带返回前一页面功能</td>
        </tr>
        <tr>
            <td>d_is_immersive_state_bar</td>
            <td>是否是沉浸式状态栏，默认false，（为true时标题栏高度包含状态栏高度）</td>
        </tr>
</table>

##### Java 代码中

<table>
        <tr>
            <td>Java代码方法</td>
            <td>Java代码方法说明</td>
        </tr>
        <tr>
            <td>setTitle(CharSequence title)</td>
            <td>设置标题资源</td>
        </tr>
        <tr>
            <td>setTitleSize(int titleSize)</td>
            <td>设置标题字体大小</td>
        </tr>
        <tr>
            <td>setTitleColor(int titleColor)</td>
            <td>设置标题字体颜色</td>
        </tr>
        <tr>
            <td>setTitleStyle(String title, int titleSize, int titleColor)</td>
            <td>设置标题资源、文字大小、文字颜色</td>
        </tr>
        <tr>
            <td>setSubTitle(CharSequence title)</td>
            <td>设置副标题资源</td>
        </tr>
        <tr>
            <td>setSubTitleSize(int titleSize)</td>
            <td>设置副标题字体大小</td>
        </tr>
        <tr>
            <td>setSubTitleColor(int titleColor)</td>
            <td>设置副标题字体颜色</td>
        </tr>
        <tr>
            <td>setSubTitleStyle(String title, int titleSize, int titleColor)</td>
            <td>设置副标题资源、文字大小、文字颜色</td>
        </tr>
        <tr>
            <td>setLeftText(String leftText)</td>
            <td>设置左侧文字</td>
        </tr>
        <tr>
            <td>setLeftTextSize(int leftTextSize)</td>
            <td>设置左侧文字大小</td>
        </tr>
        <tr>
            <td>setLeftTextColor(int leftTextColor)</td>
            <td>设置左侧文字颜色</td>
        </tr>
        <tr>
            <td>setLeftStyle(String leftText, int leftTextSize, int leftTextColor)</td>
            <td>设置左侧文字、文字大小、文字颜色</td>
        </tr>
        <tr>
            <td>setRightText(String rightText)</td>
            <td>设置右侧文字</td>
        </tr>
        <tr>
            <td>setRightTextSize(int rightTextSize)</td>
            <td>设置右侧文字大小</td>
        </tr>
        <tr>
            <td>setRightTextColor(int rightTextColor)</td>
            <td>设置右侧文字颜色</td>
        </tr>
        <tr>
            <td>setTitleClickListener(OnClickListener listener)</td>
            <td>标题点击监听</td>
        </tr>
        <tr>
            <td>setLeftClickListener(OnClickListener listener)</td>
            <td>左侧文字和按钮点击监听</td>
        </tr>
        <tr>
            <td>setRightTextClickListener(OnClickListener listener)</td>
            <td>右侧文字点击监听</td>
        </tr>
        <tr>
            <td>setRightImageClickListener(OnClickListener listener)</td>
            <td>右侧按钮点击监听</td>
        </tr>
        <tr>
            <td>setIsLeftBackView(boolean isLeftBackView)</td>
            <td>设置左侧文字和按钮是否为返回按钮</td>
        </tr>
</table>


<h3>
    <a name="sdtitlebar" id="sdtitlebar">二、SDTitleBar详细说明</a>
</h3>

* 在xml中
```
    com.siberiadante.lib.view.titlebar.SDTitleBar
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