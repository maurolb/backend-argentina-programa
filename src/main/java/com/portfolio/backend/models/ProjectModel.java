package com.portfolio.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_project")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectImg;
    private String title;
    private String description;
    private String demoUrl;
    private String repoUrl;

    public ProjectModel() {
    }

    public ProjectModel(Long id, String projectImg, String title, String description, String demoUrl, String repoUrl) {
        this.id = id;
        this.projectImg = projectImg;
        this.title = title;
        this.description = description;
        this.demoUrl = demoUrl;
        this.repoUrl = repoUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
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

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public String getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(String repoUrl) {
        this.repoUrl = repoUrl;
    }
}