package com.example.a3_listadapterexam.model;

public class Job {
    private String ttitle;          // 직업명
    private  String  description;   // 직업 설명
    private  int image;          // 이미지의 id

    public Job() {
    }

    public Job(String ttitle, String description, int image) {
        this.ttitle = ttitle;
        this.description = description;
        this.image = image;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
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
