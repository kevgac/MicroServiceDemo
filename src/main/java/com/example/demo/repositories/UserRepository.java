package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.AppUser;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
}
