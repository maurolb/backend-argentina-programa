package com.portfolio.backend.services;

import com.portfolio.backend.models.AboutModel;

public interface IAboutService {
    AboutModel findById(Long id);
    void update(Long id, AboutModel about);
}
