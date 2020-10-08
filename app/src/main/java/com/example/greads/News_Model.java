package com.example.greads;


public class News_Model {
    String title;
    int image;
    String name;
    String publishedAt;
    String description;


    public News_Model(String title, int image, String name, String publishedAt, String description){

        this.title=title;
        this.image=image;
        this.name=name;
        this.publishedAt=publishedAt;
        this.description=description;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPublishedAt() {
        return publishedAt;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
