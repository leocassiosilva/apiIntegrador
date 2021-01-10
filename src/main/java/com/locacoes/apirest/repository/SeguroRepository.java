package com.locacoes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locacoes.apirest.models.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
	
	@Query(name = "buscarPeloId", value = "Select * FROM seguro where seguro.id_seguro = :id", nativeQuery = true) 
	Seguro buscarPeloId(Long id);
}
