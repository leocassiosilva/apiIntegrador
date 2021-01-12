package com.locacoes.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.locacoes.apirest.models.Locacao;


public interface LocacoesRepository extends JpaRepository<Locacao, Long>{

	/*Metodo para realizar a busca de locações pelo email do usuario*/
	@Query(name="buscarPeloUsuario", value = "SELECT * FROM locacao"
			+ " inner join veiculos"
			+ " on(locacao.id_veiculo = veiculos.id_veiculo)"
			+ " where locacao.id_usuario = :id", nativeQuery = true)
	List<Locacao> buscarPeloUsuario(@Param("id") Long id);
	
	/*Metodo para buscar as locações pelo id do usuario*/
	@Query(name="buscarPeloId", value = "SELECT * FROM locacao  where locacao.id_usuario = :id", nativeQuery = true)
	List<Locacao> buscarPeloId(@Param("id") Long id);
	
	
}
