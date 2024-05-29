package com.project.apijava.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "favoriteMovie")
public class FavoriteMovie {
    @Id
    private String movie_id;
    private User userId;

    // Getters and setters
    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public User getUserId() { return userId;}

    public void setUserId(User userId) { this.userId = userId;}
}
