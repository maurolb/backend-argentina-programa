package com.portfolio.backend.services;

import com.portfolio.backend.models.UserModel;
import com.portfolio.backend.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public void save(UserModel user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserModel user) {
        UserModel userToUpdate = findById(id);
        if(userToUpdate != null){
            userToUpdate.setEmail(user.getEmail());
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            userToUpdate.setPassword(hashedPassword);
            userRepository.save(userToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
