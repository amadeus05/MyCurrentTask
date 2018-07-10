package com.example.extellar.mycurrenttask;

import io.realm.RealmObject;

public class Tamplate extends RealmObject {

    private int userId;
    private int postId;
    private String title;
    private String content;

    public Tamplate(){

    }

    public Tamplate(int userId, int postId, String title, String content) {
        this.userId = userId;
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
}

