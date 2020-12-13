package com.locacoes.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.locacoes.apirest.models.Locacao;


public interface LocacoesRepository extends JpaRepository<Locacao, Long>{

	@Query(name="buscarPeloUsuario", value = "SELECT * FROM locacao inner join usuario\n"
			+ "on(locacao.id_usuario = usuario.id_usuario)inner join veiculos\n"
			+ "on(locacao.id_veiculo = veiculos.id) where usuario.email = :email", nativeQuery = true)
	List<Locacao> buscarPeloUsuario(@Param("email") String email);
}
