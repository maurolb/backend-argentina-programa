package com.portfolio.backend.controllers;

import com.portfolio.backend.models.AbilityModel;
import com.portfolio.backend.services.IAbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ability")
@CrossOrigin(origins = "http://localhost:4200")
public class AbilityController {
    @Autowired
    IAbilityService abilityService;

    @GetMapping("")
    public List<AbilityModel> getAllAbilities(){
        return abilityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AbilityModel> getAbilityById(@PathVariable(value = "id") Long id){
        AbilityModel abilityById = abilityService.findById(id);
        if(abilityById != null){
            return ResponseEntity.ok().body(abilityById);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<AbilityModel> createAbility(@RequestBody AbilityModel ability){
        abilityService.save(ability);
        return ResponseEntity.status(HttpStatus.CREATED).body(ability);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AbilityModel> updateAbility(@PathVariable(value = "id") Long id, @RequestBody AbilityModel ability){
        abilityService.update(id, ability);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ability);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbility(@PathVariable(value = "id") Long id){
        abilityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
