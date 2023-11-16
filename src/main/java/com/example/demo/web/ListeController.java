package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Liste;
import com.example.demo.repositories.ListeRepository;

@RestController
@RequestMapping("/uri/v1/liste")
public class ListeController {
	@Autowired
	private final ListeRepository listeRepository;

    public ListeController(ListeRepository listeRepository) {
        this.listeRepository = listeRepository;
    }
    
    @PostMapping
    public Liste createList(@RequestBody Liste list) {
        return listeRepository.save(list);
    }

    @GetMapping("/{id}")
    public Optional<Liste> getList(@PathVariable Long id) {
        return listeRepository.findById(id);
    }
    
    @GetMapping("/all")
    public List<Liste> getAllListe(){
    	return listeRepository.findAll();
    }

    @PutMapping("/{id}")
    public Liste updateList(@PathVariable Long id, @RequestBody Liste updatedList) {
        Optional<Liste> optionalListe = listeRepository.findById(id);
        if (optionalListe.isPresent()) {
        	Liste liste = optionalListe.get();
            liste.setName(updatedList.getName());
            // Update other properties as needed
            return listeRepository.save(liste);
        } else {
            throw new IllegalArgumentException("id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Long id) {
        listeRepository.deleteById(id);
    }
}
