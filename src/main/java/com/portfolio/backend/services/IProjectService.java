package com.portfolio.backend.services;

import com.portfolio.backend.models.AbilityModel;
import com.portfolio.backend.models.ProjectModel;

import java.util.List;

public interface IProjectService {
    List<ProjectModel> findAll();
    ProjectModel findById(Long id);
    void save(ProjectModel project);
    void update(Long id, ProjectModel project);
    void deleteById(Long id);
}
