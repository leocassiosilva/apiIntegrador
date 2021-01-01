package com.locacoes.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.locacoes.apirest.models.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	Optional<Veiculo> findById(Long id);
	
	@Query(name = " buscarVeiculo", value = "Select * FROM veiculos as v "
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "inner join tipomarca on(v.id_tipo_marca = tipomarca.id_tipo_marca)\n"
			+ "inner join marca on(tipomarca.id_marca = marca.id_marca)\n"
			+ "inner join locadora on(v.id_locadora = locadora.id_locadora)\n" + "where v.id_veiculo = :id", nativeQuery = true)
	Veiculo buscarVeiculo(@Param("id") Long id);
	
	@Query(name = "buscarTodos", value = "Select * FROM veiculos as v "
			+ "inner join categoria on (v.id_categoria = categoria.id_categoria)"
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "inner join tipomarca on(v.id_tipo_marca = tipomarca.id_tipo_marca)\n"
			+ "inner join marca on(tipomarca.id_marca = marca.id_marca)\n"
			+ "inner join locadora on(v.id_locadora = locadora.id_locadora)\n", nativeQuery = true)
	List<Veiculo> buscarTodos();
}