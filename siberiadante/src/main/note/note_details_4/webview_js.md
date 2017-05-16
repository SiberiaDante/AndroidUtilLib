* WebView 设置可以跟JS交互,并设置别名
```
mWebView.getSettings().setJavaScriptEnabled(true);
mWebView.addJavascriptInterface(new JavaScriptInterface(this), "imageListener");
```

* 注册JS调用的方法JSImageCallAndroid(String data)
```
public class JavaScriptInterface {

    public JavaScriptInterface( ) {
    }

    @JavascriptInterface
    public void JSImageCallAndroid(String data) {
        Log.d(TAG, "JSImageCallAndroid: Js返回的数据" + data);
        }
    }

```
* JS调用：window.imageListener.JSImageCallAndroid("data")
