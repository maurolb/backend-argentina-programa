package com.portfolio.backend.services;

import com.portfolio.backend.models.HomeModel;

public interface IHomeService {
    HomeModel findById(Long id);
    void update(Long id, HomeModel home);

}
