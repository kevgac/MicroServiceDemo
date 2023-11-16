package com.example.demo.entities;

import java.util.Date;

import com.example.demo.enums.TypePriorite;
import com.example.demo.enums.TypeEtat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tache {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date dateEcheance;
    @Enumerated(EnumType.STRING)
	private TypePriorite priorite;
    @Enumerated(EnumType.STRING)
	private TypeEtat etat;
    
}
