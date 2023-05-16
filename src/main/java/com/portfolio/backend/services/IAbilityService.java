package com.portfolio.backend.services;

import com.portfolio.backend.models.AbilityModel;

import java.util.List;

public interface IAbilityService {
    List<AbilityModel> findAll();
    AbilityModel findById(Long id);
    void save(AbilityModel ability);
    void update(Long id, AbilityModel ability);
    void deleteById(Long id);
}
