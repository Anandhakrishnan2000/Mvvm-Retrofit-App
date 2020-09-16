package com.krizz.mvvmdemo.model;

import com.google.gson.annotations.SerializedName;

public class SiteAd {

    @SerializedName("company")
    private String company;
    @SerializedName("url")
    private String url;
    @SerializedName("text")
    private String text;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
