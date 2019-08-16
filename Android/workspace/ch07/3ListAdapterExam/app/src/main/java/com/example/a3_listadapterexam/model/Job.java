package com.example.a3_listadapterexam.model;

import java.io.Serializable;

public class Job implements Serializable {
    private String title;       // 직업명
    private String description; // 직업 설명
    private int image;          // 이미지의 id

    public Job() {
    }
    public Job(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
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
}
