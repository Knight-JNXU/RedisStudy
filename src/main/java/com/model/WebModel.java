package com.model;

/**
 * Created by Knigh on 2016/11/14.
 */
public class WebModel extends BaseModel {
    //网站描述
    private String des;
    //网站url
    private String url;

    public WebModel() {
    }

    public WebModel(String des, String url) {
        this.des = des;
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WebModel{" +
                "des='" + des + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
