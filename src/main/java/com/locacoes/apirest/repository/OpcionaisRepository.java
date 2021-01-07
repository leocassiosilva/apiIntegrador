package com.locacoes.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locacoes.apirest.models.Opcionais;

public interface OpcionaisRepository extends JpaRepository<Opcionais, Long>{
	Optional<Opcionais> findById(Long id);
}
