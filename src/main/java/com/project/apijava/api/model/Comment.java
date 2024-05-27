package com.project.apijava.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "comments")
public class Comment {
    @Id
    private String id;
    private String movie_id;
    private User userId;
    private String desc;
    private String type;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getDesc() { return desc; }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public User getUserId() { return userId;}

    public void setUserId(User userId) { this.userId = userId;}
}