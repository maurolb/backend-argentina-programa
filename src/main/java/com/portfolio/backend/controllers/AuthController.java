package com.portfolio.backend.controllers;

import com.portfolio.backend.models.UserModel;
import com.portfolio.backend.services.IUserService;
import com.portfolio.backend.utils.JwtUtil;
import com.portfolio.backend.utils.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserModel user){
        try {
            // verifica email
            UserModel userByEmail = userService.getUserByEmail(user.getEmail());
            // verifica contraseña
            if (userByEmail != null && BCrypt.checkpw(user.getPassword(), userByEmail.getPassword())) {

                // genera token
                String token = jwtUtil.generateToken(userByEmail.getId());
                UserResponse response = new UserResponse(userByEmail, token);
                return ResponseEntity.ok().body(response);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            return null;
        }
    }
}
