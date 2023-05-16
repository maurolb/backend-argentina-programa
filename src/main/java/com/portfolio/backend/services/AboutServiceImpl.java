package com.portfolio.backend.services;

import com.portfolio.backend.models.AboutModel;
import com.portfolio.backend.models.HomeModel;
import com.portfolio.backend.repositories.IAboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements IAboutService{
    @Autowired
    IAboutRepository aboutRepository;

    @Override
    public AboutModel findById(Long id) {
        return aboutRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, AboutModel about) {
        AboutModel aboutToUpdate = findById(id);
        if(aboutToUpdate != null){
            aboutToUpdate.setDescription(about.getDescription());
            aboutRepository.save(aboutToUpdate);
        }
    }
}
