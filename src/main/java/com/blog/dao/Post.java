package com.blog.dao;

import java.sql.Timestamp;

public class Post {
    private int id;
    private String title;
    private String content;
    private Timestamp postDate;

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getPostDate() {
        return postDate;
    }
    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}