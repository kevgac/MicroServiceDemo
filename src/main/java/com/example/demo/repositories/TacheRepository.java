package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Tache;
import com.example.demo.enums.TypeEtat;

public interface TacheRepository extends JpaRepository<Tache, Long> {
	Optional<Tache> findById(Long id);
	List<Tache> findByEtat(TypeEtat etat);
}
