package com.siberiadante.utilsample.bean;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/9/20
 * @UpDate:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class DataBean {
    private String Title;
    private Class<?> cls;

    public DataBean(String title, Class<?> cls) {
        Title = title;
        this.cls = cls;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
