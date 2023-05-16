package com.portfolio.backend.repositories;

import com.portfolio.backend.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserModel, Long> {
    UserModel findOneByEmail(String email);
}
