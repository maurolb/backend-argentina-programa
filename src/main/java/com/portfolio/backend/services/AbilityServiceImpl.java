package com.portfolio.backend.services;

import com.portfolio.backend.models.AbilityModel;
import com.portfolio.backend.repositories.IAbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AbilityServiceImpl implements IAbilityService{
    @Autowired
    IAbilityRepository abilityRepository;

    @Override
    public List<AbilityModel> findAll() {
        return abilityRepository.findAll();
    }

    @Override
    public AbilityModel findById(Long id) {
        return abilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AbilityModel ability) {
        abilityRepository.save(ability);
    }

    @Override
    public void update(Long id, AbilityModel ability) {
        AbilityModel abilityToUpdate = findById(id);
        if(abilityToUpdate != null){
            abilityToUpdate.setType(ability.getType());
            abilityToUpdate.setIcon(ability.getIcon());
            abilityToUpdate.setName(ability.getName());
            abilityToUpdate.setProgress(ability.getProgress());
            abilityRepository.save(abilityToUpdate);
        }
    }

    @Override
    public void deleteById(Long id) {
        abilityRepository.deleteById(id);
    }
}
