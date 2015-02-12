package com.example.bernard.silver_productivity.entity;

import android.widget.ImageView;

/**
 * Created by LEBAO_000 on 12/02/2015.
 */
public class Comment {
    private String content;
    private ImageView portraitImage;
    private int numberOfLike;

    Comment(){

    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }
}



