package com.example.greads.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_News_Model {

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private List<News_Model> newsList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<News_Model> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News_Model> newsList) {
        this.newsList = newsList;
    }
}