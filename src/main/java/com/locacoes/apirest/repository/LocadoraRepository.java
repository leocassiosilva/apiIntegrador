package com.locacoes.apirest.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locacoes.apirest.models.Locadora;

public interface LocadoraRepository extends JpaRepository<Locadora, Long> {
	
	@Query(name = "buscarTodas", value = "SELECT * FROM locadora\n"
			+ "	inner join local on(locadora.id_local = local.id_local)", nativeQuery = true) 
	List<Locadora> buscarTodas();
}
