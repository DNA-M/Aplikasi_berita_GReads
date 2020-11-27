package com.example.greads.model;

import com.google.gson.annotations.SerializedName;

public class News_Model {

    @SerializedName("urlToImage")
    String urlToImage;
    @SerializedName("title")
    String title;
    @SerializedName("publishedAt")
    String publishedAt;
    @SerializedName("author")
    String author;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String url;
    @SerializedName("content")
    String content;
    @SerializedName("source")
    Source source;


    public News_Model(String urlToImage, String title, String publishedAt, String author, String description, String url, String content, Source source) {
        this.urlToImage = urlToImage;
        this.title = title;
        this.publishedAt = publishedAt;
        this.author = author;
        this.description = description;
        this.url = url;
        this.content = content;
        this.source = source;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}