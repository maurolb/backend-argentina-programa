package com.portfolio.backend.services;

import com.portfolio.backend.models.HomeModel;
import com.portfolio.backend.models.UserModel;
import com.portfolio.backend.repositories.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements IHomeService{
    @Autowired
    IHomeRepository homeRepository;

    @Override
    public HomeModel findById(Long id) {
        return homeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, HomeModel home) {
        HomeModel homeToUpdate = findById(id);
        if(homeToUpdate != null){
            homeToUpdate.setTitle(home.getTitle());
            homeToUpdate.setSubtitle(home.getSubtitle());
            homeToUpdate.setDescription(home.getDescription());
            homeToUpdate.setProfileImg(home.getProfileImg());
            homeRepository.save(homeToUpdate);
        }
    }
}
