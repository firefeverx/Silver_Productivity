package com.example.bernard.silver_productivity.entity;

import java.util.ArrayList;

/**
 * Created by LEBAO_000 on 12/02/2015.
 */
public class Poster {

    private String id;
    private String title;
    private String content;
    private int numberOfLike;
    private int numberOfComment;
    private String author;
    ArrayList<Comment> comments;
    private String location;
    private String time;


    public Poster(){

    }

    public Poster(String title, String location, int numberOfComment, int numberOfLike){
        this.title = title;
        this.location = location;
        this.numberOfComment = numberOfComment;
        this.numberOfLike = numberOfLike;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
