package com.mdk.myapplication.model;

public class IntroScreenItem {

    private String title;
    private String exp;
    private String image_path;
    private String image_back_url;

    public IntroScreenItem(String title, String exp, String image_path, String image_back_url) {
        this.title = title;
        this.exp = exp;
        this.image_path = image_path;
        this.image_back_url = image_back_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getImage_back_url() {
        return image_back_url;
    }

    public void setImage_back_url(String image_back_url) {
        this.image_back_url = image_back_url;
    }
}
