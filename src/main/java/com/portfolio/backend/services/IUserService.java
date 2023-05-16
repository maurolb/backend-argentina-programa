package com.portfolio.backend.services;

import com.portfolio.backend.models.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserModel findById(Long id);
    UserModel getUserByEmail(String email);
    void save(UserModel user);
    void update(Long id, UserModel user);
    void deleteById(Long id);
}