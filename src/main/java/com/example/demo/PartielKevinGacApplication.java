package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entities.AppUser;
import com.example.demo.entities.Liste;
import com.example.demo.entities.Tache;
import com.example.demo.enums.TypeEtat;
import com.example.demo.enums.TypePriorite;
import com.example.demo.repositories.ListeRepository;
import com.example.demo.repositories.TacheRepository;
import com.example.demo.repositories.UserRepository;

@SpringBootApplication
public class PartielKevinGacApplication {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ListeRepository listeRepo;
	@Autowired
	private TacheRepository tacheRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PartielKevinGacApplication.class, args);
	}
	
	@Bean 
	CommandLineRunner start() {
		return args -> {
			userRepo.save(new AppUser(null, "kevin", "1234"));
			userRepo.save(new AppUser(null, "kevin2", "5678"));
			userRepo.save(new AppUser(null, "kevin3", "1234"));
			userRepo.findAll().forEach(user -> {
				System.out.println("user : " + user.getUsername());
			}); 
			
			tacheRepo.save(new Tache(null, "java", new Date(), TypePriorite.ELEVEE, TypeEtat.FAIT));
			tacheRepo.save(new Tache(null, "SQL", new Date(), TypePriorite.MOYEN, TypeEtat.PAS_FAIT));
			tacheRepo.save(new Tache(null, "Python", new Date(), TypePriorite.FAIBLE, TypeEtat.PAS_FAIT));
			tacheRepo.save(new Tache(null, "PHP", new Date(), TypePriorite.MOYEN, TypeEtat.PAS_FAIT));
			tacheRepo.findAll().forEach(tache -> {
				System.out.println("tache : " + tache.getDescription() + " " + tache.getDateEcheance() + " " + tache.getPriorite() + " " + tache.getEtat());
			});
			
			
			Liste liste = new Liste();
			List<Tache> listeTache = new ArrayList<Tache>(); 
			listeTache.addAll (tacheRepo.findAll());
			liste.setListeTache(listeTache);
			liste.setName("liste1");
			listeRepo.save(liste);
			
			listeRepo.findAll().forEach(liste1 -> {
				System.out.println("Liste : " + liste1.getName());
			});
		};
	}

}