package com.portfolio.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_home")
public class HomeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subtitle;
    private String description;
    private String profileImg;

    public HomeModel() {
    }

    public HomeModel(Long id, String title, String subtitle, String description, String profileImg) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.profileImg = profileImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }
}
