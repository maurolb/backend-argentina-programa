package com.portfolio.backend.repositories;

import com.portfolio.backend.models.AboutModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAboutRepository extends JpaRepository<AboutModel, Long> {
}
