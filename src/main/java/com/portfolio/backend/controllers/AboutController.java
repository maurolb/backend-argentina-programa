package com.portfolio.backend.controllers;

import com.portfolio.backend.models.AboutModel;
import com.portfolio.backend.services.IAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {
    @Autowired
    IAboutService aboutService;

    @GetMapping("/{id}")
    public ResponseEntity<AboutModel> getAboutById(@PathVariable(value = "id") Long id){
        AboutModel aboutById = aboutService.findById(id);
        if(aboutById != null){
            return ResponseEntity.ok().body(aboutById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AboutModel> updateAbout(@PathVariable(value = "id") Long id, @RequestBody AboutModel about){
        aboutService.update(id, about);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(about);
    }
}
