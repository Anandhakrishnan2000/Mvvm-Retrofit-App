package com.krizz.mvvmdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SampleApiModel {

    @SerializedName("page")
    private int page;
    @SerializedName("per_page")
    private int per_page;
    @SerializedName("total")
    private int total;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("data")
    private List<DataModel> data = null;
    @SerializedName("ad")
    private SiteAd ad = null;

    public SiteAd getAd() {
        return ad;
    }

    public void setAd(SiteAd ad) {
        this.ad = ad;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<DataModel> getData() {
        return data;
    }

    public void setData(List<DataModel> data) {
        this.data = data;
    }
}
