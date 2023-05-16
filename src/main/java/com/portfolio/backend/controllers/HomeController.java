package com.portfolio.backend.controllers;

import com.portfolio.backend.models.HomeModel;
import com.portfolio.backend.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {
    @Autowired
    IHomeService homeService;

    @GetMapping("/{id}")
    public ResponseEntity<HomeModel> getHomeById(@PathVariable(value = "id") Long id){
        HomeModel homeById = homeService.findById(id);
        if(homeById != null){
            return ResponseEntity.ok().body(homeById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HomeModel> updateHome(@PathVariable(value = "id") Long id, @RequestBody HomeModel home){
        homeService.update(id, home);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(home);
    }
}
