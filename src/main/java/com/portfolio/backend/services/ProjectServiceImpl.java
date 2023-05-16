package com.portfolio.backend.services;

import com.portfolio.backend.models.ProjectModel;
import com.portfolio.backend.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements IProjectService{
    @Autowired
    IProjectRepository projectRepository;

    @Override
    public List<ProjectModel> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectModel findById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ProjectModel project) {
        projectRepository.save(project);
    }

    @Override
    public void update(Long id, ProjectModel project) {
        ProjectModel projectToUpdate = findById(id);
        if(projectToUpdate != null){
            projectToUpdate.setProjectImg(project.getProjectImg());
            projectToUpdate.setTitle(project.getTitle());
            projectToUpdate.setDescription(project.getDescription());
            projectToUpdate.setDemoUrl(project.getDemoUrl());
            projectToUpdate.setRepoUrl(project.getRepoUrl());
            projectRepository.save(projectToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }
}
