package com.siberiadante.utilsample.bean.document;

/**
 * create date: 2018/11/3
 */
public class DocumentList {
    private int id;
    private String title;

    public DocumentList(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
