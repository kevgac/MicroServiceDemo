package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Tache;
import com.example.demo.enums.TypeEtat;
import com.example.demo.repositories.TacheRepository;

@Service
public class TacheService {
	private final TacheRepository tacheRepository;
    
    public TacheService(TacheRepository tacheRepository) {
        this.tacheRepository = tacheRepository;
    }
    
    public List<Tache> getTachesFaites() {
        return tacheRepository.findByEtat(TypeEtat.FAIT);
    }
}
