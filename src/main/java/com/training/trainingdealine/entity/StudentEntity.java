package com.training.trainingdealine.entity;

public class StudentEntity {
    private String Id;
    private String Content;
    private String Not;
    private String image;

    public StudentEntity() {
    }

    public StudentEntity(String id, String content, String not, String image) {
        Id = id;
        Content = content;
        Not = not;
        this.image = image;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getNot() {
        return Not;
    }

    public void setNot(String not) {
        Not = not;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
