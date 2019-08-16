package com.example.practice3.model;

public class Job {
    private String title;
    private String description;
    private int thumbImgae;
    private int originalImage;

    public Job() {
    }
    public Job(String title, String description, int thumbImgae, int originalImage) {
        this.title = title;
        this.description = description;
        this.thumbImgae = thumbImgae;
        this.originalImage = originalImage;
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

    public int getThumbImgae() {
        return thumbImgae;
    }

    public void setThumbImgae(int thumbImgae) {
        this.thumbImgae = thumbImgae;
    }

    public int getOriginalImage() {
        return originalImage;
    }

    public void setOriginalImage(int originalImage) {
        this.originalImage = originalImage;
    }
}
