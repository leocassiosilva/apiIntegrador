package com.locacoes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locacoes.apirest.models.Opcionais;

public interface OpcionaisRepository extends JpaRepository<Opcionais, Long>{
	
	@Query(name = "buscarPeloId", value = "Select * FROM opcionais where opcionais.id_opc = :id", nativeQuery = true) 
	Opcionais buscarPeloId(Long id);
}
