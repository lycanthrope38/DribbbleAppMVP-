
package com.thongle.dribbbleapp.data.remote.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class User {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("bio")
    @Expose
    private String bio;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("buckets_count")
    @Expose
    private Integer bucketsCount;
    @SerializedName("comments_received_count")
    @Expose
    private Integer commentsReceivedCount;
    @SerializedName("followers_count")
    @Expose
    private Integer followersCount;
    @SerializedName("followings_count")
    @Expose
    private Integer followingsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("likes_received_count")
    @Expose
    private Integer likesReceivedCount;
    @SerializedName("projects_count")
    @Expose
    private Integer projectsCount;
    @SerializedName("rebounds_received_count")
    @Expose
    private Integer reboundsReceivedCount;
    @SerializedName("shots_count")
    @Expose
    private Integer shotsCount;
    @SerializedName("teams_count")
    @Expose
    private Integer teamsCount;
    @SerializedName("can_upload_shot")
    @Expose
    private Boolean canUploadShot;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("pro")
    @Expose
    private Boolean pro;
    @SerializedName("buckets_url")
    @Expose
    private String bucketsUrl;
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @SerializedName("following_url")
    @Expose
    private String followingUrl;
    @SerializedName("likes_url")
    @Expose
    private String likesUrl;
    @SerializedName("projects_url")
    @Expose
    private String projectsUrl;
    @SerializedName("shots_url")
    @Expose
    private String shotsUrl;
    @SerializedName("teams_url")
    @Expose
    private String teamsUrl;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }


    public Integer getBucketsCount() {
        return bucketsCount;
    }


    public void setBucketsCount(Integer bucketsCount) {
        this.bucketsCount = bucketsCount;
    }


    public Integer getCommentsReceivedCount() {
        return commentsReceivedCount;
    }


    public void setCommentsReceivedCount(Integer commentsReceivedCount) {
        this.commentsReceivedCount = commentsReceivedCount;
    }


    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }


    public Integer getFollowingsCount() {
        return followingsCount;
    }

    public void setFollowingsCount(Integer followingsCount) {
        this.followingsCount = followingsCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }


    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }


    public Integer getLikesReceivedCount() {
        return likesReceivedCount;
    }


    public void setLikesReceivedCount(Integer likesReceivedCount) {
        this.likesReceivedCount = likesReceivedCount;
    }


    public Integer getProjectsCount() {
        return projectsCount;
    }


    public void setProjectsCount(Integer projectsCount) {
        this.projectsCount = projectsCount;
    }


    public Integer getReboundsReceivedCount() {
        return reboundsReceivedCount;
    }


    public void setReboundsReceivedCount(Integer reboundsReceivedCount) {
        this.reboundsReceivedCount = reboundsReceivedCount;
    }


    public Integer getShotsCount() {
        return shotsCount;
    }


    public void setShotsCount(Integer shotsCount) {
        this.shotsCount = shotsCount;
    }

    public Integer getTeamsCount() {
        return teamsCount;
    }


    public void setTeamsCount(Integer teamsCount) {
        this.teamsCount = teamsCount;
    }


    public Boolean getCanUploadShot() {
        return canUploadShot;
    }


    public void setCanUploadShot(Boolean canUploadShot) {
        this.canUploadShot = canUploadShot;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Boolean getPro() {
        return pro;
    }

    public void setPro(Boolean pro) {
        this.pro = pro;
    }


    public String getBucketsUrl() {
        return bucketsUrl;
    }


    public void setBucketsUrl(String bucketsUrl) {
        this.bucketsUrl = bucketsUrl;
    }


    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }


    public String getFollowingUrl() {
        return followingUrl;
    }


    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
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


    public String getShotsUrl() {
        return shotsUrl;
    }


    public void setShotsUrl(String shotsUrl) {
        this.shotsUrl = shotsUrl;
    }


    public String getTeamsUrl() {
        return teamsUrl;
    }


    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
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

}
