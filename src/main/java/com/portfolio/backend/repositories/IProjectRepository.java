package com.portfolio.backend.repositories;

import com.portfolio.backend.models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<ProjectModel, Long> {
}
