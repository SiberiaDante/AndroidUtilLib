1、订制EditText光标
* 设置背景android:background="@null"
* 设置光标样式：android:textCursorDrawable="@drawable/edit_cursor_line"
```
    <shape xmlns:android="http://schemas.android.com/apk/res/android" android:shape="rectangle">
        <size android:width="2dp" />
        <solid android:color="@color/zhiRiRed"  />
    </shape>
```
* 去掉或设置光标下的圆点样式：android:textSelectHandle="@drawable/edit_select_handle"
去掉下标可如下设置（直接设置android:textSelectHandle="@null"运行时出错）
```
    <?xml version="1.0" encoding="utf-8"?>
    <shape xmlns:android="http://schemas.android.com/apk/res/android"
        android:shape="rectangle" >
        <size android:width="0dp" />
    </shape>
```
整体代码如下：
```
    <EditText
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:background="@null"
         android:textCursorDrawable="@drawable/edit_cursor_line"
         android:textSelectHandle="@drawable/edit_select_handle" />
```
