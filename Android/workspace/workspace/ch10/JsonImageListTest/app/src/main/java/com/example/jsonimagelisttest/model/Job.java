package com.example.jsonimagelisttest.model;

import java.io.Serializable;

public class Job implements Serializable {
    private int num;
    private String img;
    private String imgOrigin;
    private String subject;
    private String content;

    public Job() {
    }

    public Job(int num, String img, String subject, String content, String imgOrigin) {
        this.num = num;
        this.img = img;
        this.subject = subject;
        this.content = content;
        this.imgOrigin = imgOrigin;
    }

    public String getImgOrigin() {
        return imgOrigin;
    }

    public void setImgOrigin(String imgOrigin) {
        this.imgOrigin = imgOrigin;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
