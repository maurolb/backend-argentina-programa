package com.portfolio.backend.repositories;

import com.portfolio.backend.models.AbilityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbilityRepository extends JpaRepository<AbilityModel, Long> {
}
