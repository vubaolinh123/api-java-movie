package com.project.apijava.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "favoriteMovie")
public class FavoriteMovie {
    @Id
    private String mediaId;
    private String userId;
    @Field("media_type")
    private Number mediaType;

    // Getters and setters
    public void setMediaType(Number mediaType) {
        this.mediaType = mediaType;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getUserId() {
        return userId;
    }

    public Number getMediaType() {
        return mediaType;
    }

}
