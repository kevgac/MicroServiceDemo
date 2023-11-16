package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Tache;
import com.example.demo.enums.TypeEtat;
import com.example.demo.repositories.TacheRepository;
import com.example.demo.services.TacheService;

@RestController
@RequestMapping("/uri/v1/tache")
public class TacheController {
    @Autowired
	private final TacheRepository tacheRepository;
    @Autowired
    private final TacheService tacheService;

    public TacheController(TacheRepository tacheRepository, TacheService tacheService) {
        this.tacheRepository = tacheRepository;
        this.tacheService = tacheService;
    }
    
    @PostMapping
    public Tache createList(@RequestBody Tache tache) {
        return tacheRepository.save(tache);
    }

    @GetMapping("/{id}")
    public Optional<Tache> getList(@PathVariable Long id) {
        return tacheRepository.findById(id);
    }
    
    @GetMapping("/all")
    public List<Tache> getAllListe(){
    	return tacheRepository.findAll();
    }
    
    @GetMapping("faites")
    public List<Tache> getTachesFaites() {
        return tacheService.getTachesFaites();
    }
    
    @PutMapping("/{id}/terminee")
    public ResponseEntity<String> marquerTacheTerminee(@PathVariable Long id) {
        Optional<Tache> optionalTache = tacheRepository.findById(id);
        if (optionalTache.isPresent()) {
            Tache tache = optionalTache.get();
            tache.setEtat(TypeEtat.FAIT);
            tacheRepository.save(tache);
            return ResponseEntity.ok("La tâche a été marquée comme terminée.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Long id) {
    	tacheRepository.deleteById(id);
    }
    
}



