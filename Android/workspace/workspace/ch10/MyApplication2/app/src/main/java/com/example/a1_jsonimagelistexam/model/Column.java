package com.example.a1_jsonimagelistexam.model;

import java.io.Serializable;

public class Column implements Serializable {
    private int num;
    private String ing;
    private String subject;
    private String content;

    public Column() {
    }

    public Column(int num, String img, String subject, String content) {
        this.num = num;
        this.ing = img;
        this.subject = subject;
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getimg() {
        return ing;
    }

    public void setimg(String img) {
        this.ing = ing;
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
