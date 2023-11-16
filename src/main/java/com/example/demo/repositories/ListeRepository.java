package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Liste;

public interface ListeRepository extends JpaRepository<Liste, Long> {
	Optional<Liste> findById(Long id);
}
