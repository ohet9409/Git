package com.example.practice3.model;

public class Job {
    private String title;
    private String description;
    private int image;
    private int originImage;
    public Job() {
    }

    public Job(String title, String description, int image, int originImage) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.originImage = originImage;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getOriginImage() {
        return originImage;
    }

    public void setOriginImage(int originImage) {
        this.originImage = originImage;
    }
}
