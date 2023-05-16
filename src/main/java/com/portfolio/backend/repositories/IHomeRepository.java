package com.portfolio.backend.repositories;

import com.portfolio.backend.models.HomeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHomeRepository extends JpaRepository<HomeModel, Long> {
}
