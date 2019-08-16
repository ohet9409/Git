package com.example.a4_listitemcheckexam.model;

public class Flower {
    private String title;               // 꽃이름
    private  String description;        // 꽃말
    private  int image;                 // 이미지의 id
    private  boolean check;             // CheckBox의 상태

    public Flower() {
    }

    public Flower(String title, String description, int image, boolean check) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.check = check;
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

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
