
package com.thongle.dribbbleapp.data.remote.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Shot {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("attachments_count")
    @Expose
    private Integer attachmentsCount;
    @SerializedName("rebounds_count")
    @Expose
    private Integer reboundsCount;
    @SerializedName("buckets_count")
    @Expose
    private Integer bucketsCount;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("attachments_url")
    @Expose
    private String attachmentsUrl;
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;
    @SerializedName("comments_url")
    @Expose
    private String commentsUrl;
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;
    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;
    @SerializedName("rebounds_url")
    @Expose
    private String reboundsUrl;
    @SerializedName("rebound_source_url")
    @Expose
    private String reboundSourceUrl;
    @SerializedName("animated")
    @Expose
    private Boolean animated;

    @SerializedName("user")
    @Expose
    private User user;



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWidth() {
        return width;
    }


    public void setWidth(Integer width) {
        this.width = width;
    }


    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }


    public Images getImages() {
        return images;
    }


    public void setImages(Images images) {
        this.images = images;
    }


    public Integer getViewsCount() {
        return viewsCount;
    }


    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }


    public Integer getLikesCount() {
        return likesCount;
    }


    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }


    public Integer getCommentsCount() {
        return commentsCount;
    }


    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }


    public Integer getAttachmentsCount() {
        return attachmentsCount;
    }


    public void setAttachmentsCount(Integer attachmentsCount) {
        this.attachmentsCount = attachmentsCount;
    }


    public Integer getReboundsCount() {
        return reboundsCount;
    }

    public void setReboundsCount(Integer reboundsCount) {
        this.reboundsCount = reboundsCount;
    }


    public Integer getBucketsCount() {
        return bucketsCount;
    }


    public void setBucketsCount(Integer bucketsCount) {
        this.bucketsCount = bucketsCount;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    public String getHtmlUrl() {
        return htmlUrl;
    }


    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }


    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }


    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }


    public String getBucketsUrl() {
        return bucketsUrl;
    }

    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }


    public String getCommentsUrl() {
        return commentsUrl;
    }


    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }


    public String getLikesUrl() {
        return likesUrl;
    }


    public void setLikesUrl(String likesUrl) {
        this.likesUrl = likesUrl;
    }

    public String getProjectsUrl() {
        return projectsUrl;
    }


    public void setProjectsUrl(String projectsUrl) {
        this.projectsUrl = projectsUrl;
    }

    public String getReboundsUrl() {
        return reboundsUrl;
    }

    public void setReboundsUrl(String reboundsUrl) {
        this.reboundsUrl = reboundsUrl;
    }


    public String getReboundSourceUrl() {
        return reboundSourceUrl;
    }

    public void setReboundSourceUrl(String reboundSourceUrl) {
        this.reboundSourceUrl = reboundSourceUrl;
    }


    public Boolean getAnimated() {
        return animated;
    }


    public void setAnimated(Boolean animated) {
        this.animated = animated;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
