package com.locacoes.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.locacoes.apirest.models.Locacao;


public interface LocacoesRepository extends JpaRepository<Locacao, Long>{

	@Query(name="buscarPeloUsuario", value = "SELECT * FROM locacao inner join usuario\r\n"
			+ "on(locacao.id_usuario = usuario.id_usuario)"
			+ "inner join veiculos\r\n"
			+ "on(locacao.id_veiculo = veiculos.id_veiculo) where usuario.email = :email", nativeQuery = true)
	List<Locacao> buscarPeloUsuario(@Param("email") String email);
	
	
	@Query(name="buscarPeloUsuario", value = "SELECT * FROM locacao  where locacao.id_usuario = :id", nativeQuery = true)
	List<Locacao> buscarPeloId(@Param("id") Long id);
}
