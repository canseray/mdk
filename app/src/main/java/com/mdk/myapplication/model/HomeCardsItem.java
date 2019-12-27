package com.mdk.myapplication.model;

public class HomeCardsItem {

    //part11 main_category_data
    private String parent_category_id;
    private String parent_category_name;
    private String parent_category_image;
    private String parent_prepare_segue;
    private String badge_count;

    public HomeCardsItem(String parent_category_id, String parent_category_name, String parent_category_image, String parent_prepare_segue, String badge_count) {
        this.parent_category_id = parent_category_id;
        this.parent_category_name = parent_category_name;
        this.parent_category_image = parent_category_image;
        this.parent_prepare_segue = parent_prepare_segue;
        this.badge_count = badge_count;
    }

    public String getParent_category_id() {
        return parent_category_id;
    }

    public void setParent_category_id(String parent_category_id) {
        this.parent_category_id = parent_category_id;
    }

    public String getParent_category_name() {
        return parent_category_name;
    }

    public void setParent_category_name(String parent_category_name) {
        this.parent_category_name = parent_category_name;
    }

    public String getParent_category_image() {
        return parent_category_image;
    }

    public void setParent_category_image(String parent_category_image) {
        this.parent_category_image = parent_category_image;
    }

    public String getParent_prepare_segue() {
        return parent_prepare_segue;
    }

    public void setParent_prepare_segue(String parent_prepare_segue) {
        this.parent_prepare_segue = parent_prepare_segue;
    }

    public String getBadge_count() {
        return badge_count;
    }

    public void setBadge_count(String badge_count) {
        this.badge_count = badge_count;
    }
}
