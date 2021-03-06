package com.locacoes.apirest.repository;

import java.time.LocalDate;
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
			+ "inner join locadora on(v.id_locadora = locadora.id_locadora)\n"
			+ "where v.id_veiculo = :id", nativeQuery = true)
	Veiculo buscarVeiculo(@Param("id") Long id);
	
	@Query(name = "buscarTodos", value = "Select * FROM veiculos as v "
			+ "inner join categoria on (v.id_categoria = categoria.id_categoria)"
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "inner join tipomarca on(v.id_tipo_marca = tipomarca.id_tipo_marca)\n"
			+ "inner join marca on(tipomarca.id_marca = marca.id_marca)\n"
			+ "inner join locadora on(v.id_locadora = locadora.id_locadora)\n", nativeQuery = true) 
	List<Veiculo> buscarTodos();

	@Query(name = "buscarPorDatas", value = "SELECT * FROM veiculos as v "
			+ "inner join locadora on (locadora.id_locadora = v.id_locadora) "
			+ "inner join arquivos as ar on(v.id_veiculo = ar.id_veiculo)\n"
			+ "inner join categoria on(categoria.id_categoria = v.id_categoria)"
			+ "inner join tipomarca on (tipomarca.id_tipo_marca = v.id_tipo_marca)\r\n"
			+ "inner join marca on (marca.id_marca = tipomarca.id_marca)\r\n"
			+ "inner join tipo on (tipo.id_tipo = tipomarca.id_tipo)"
			+ "inner join local on (local.id_local = locadora.id_local)"
			+ " where v.id_veiculo NOT IN (SELECT locacao.id_veiculo FROM locacao "
			+ " where (locacao.data_retirada <= :retirada and locacao.data_retirada >= :retirada) "
			+ " or (locacao.data_entrega >= :devolucao and locacao.data_entrega <= :devolucao)) and local.nome = :nome", nativeQuery = true)
	List<Veiculo>  buscarPorDatas(@Param("retirada") LocalDate retirada, @Param("devolucao") LocalDate devolucao,@Param("nome") String nome);

}