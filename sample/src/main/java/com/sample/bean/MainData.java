package com.sample.bean;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/20
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class MainData {
    private String title;
    private String url;

    public MainData(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
