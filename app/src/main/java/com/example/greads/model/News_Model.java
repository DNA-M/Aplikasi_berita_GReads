package com.example.greads.model;

import com.google.gson.annotations.SerializedName;

public class News_Model {

    @SerializedName("urlToImage")
    String urlToImage;
    @SerializedName("title")
    String title;
    @SerializedName("publishedAt")
    String publishedAt;
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String url;


    public News_Model(String urlToImage, String title, String publishedAt, String source, String description, String url) {
        this.urlToImage = urlToImage;
        this.title = title;
        this.publishedAt = publishedAt;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}