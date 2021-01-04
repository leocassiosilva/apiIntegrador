package com.locacoes.apirest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locacoes.apirest.repository.LocadoraRepository;
import com.locacoes.apirest.repository.SeguroRepository;
import com.locacoes.apirest.repository.VeiculoRepository;

import io.swagger.annotations.ApiOperation;

import com.locacoes.apirest.models.Arquivo;
import com.locacoes.apirest.models.Locadora;
import com.locacoes.apirest.models.Seguro;
import com.locacoes.apirest.models.Veiculo;

@RestController
@RequestMapping(value = "/api")
public class VeiculoController {

	@Autowired
	VeiculoRepository veiculoRepository;

	@Autowired
	SeguroRepository seguroRepository;
	
	@Autowired
	LocadoraRepository locadoraRepository;
	
	@GetMapping("/veiculos")
	public List<Veiculo> listaVeiculos() {
		return veiculoRepository.buscarTodos();
	}

	@GetMapping("/veiculo/{id}")
	public Veiculo listaveiculoUnico(@PathVariable("id") Long id) {
		Veiculo veiculo = veiculoRepository.buscarVeiculo(id);
		for (Arquivo arquivo : veiculo.getArquivos()) {
			veiculo.setNomeArquivo(arquivo.getNome());
		}
		return veiculo;
	}

	@GetMapping("/veiculos/buscar/{dataRetirar}/{dataDevolver}/{nome}")
	public List<Veiculo> buscarVeiculos(
			@PathVariable("dataRetirar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataRetirar,
			@PathVariable("dataDevolver") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataDevolver,
			@PathVariable("nome") String nome) {
		List<Veiculo> veiculos = veiculoRepository.buscarPorDatas(dataRetirar, dataDevolver, nome);

		for (Veiculo veiculo2 : veiculos) {
			for (Arquivo arquivo : veiculo2.getArquivos()) {
				veiculo2.setNomeArquivo(arquivo.getNome());
			}
		}
		return veiculos;
	}

	@PostMapping("/veiculos/salvar")
	@ApiOperation(value = "Retorna uma locação salva")
	public Veiculo salvarVeiculo(@RequestBody Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	@GetMapping("/veiculos/seguros")
	public List<Seguro> buscarSeguro() {
		return seguroRepository.findAll();
	}
	
	@GetMapping("/veiculos/locadora")
	public List<Locadora> buscarLocadora() {
		return locadoraRepository.buscarTodas();
	}

}
