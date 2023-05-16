package com.portfolio.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_ability")
public class AbilityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String icon;
    private String name;
    private Long progress;

    public AbilityModel() {
    }

    public AbilityModel(Long id, String type, String icon, String name, Long progress) {
        this.id = id;
        this.type = type;
        this.icon = icon;
        this.name = name;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }
}