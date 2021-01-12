package com.locacoes.apirest.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locacoes.apirest.repository.LocadoraRepository;
import com.locacoes.apirest.repository.OpcionaisRepository;
import com.locacoes.apirest.repository.SeguroRepository;
import com.locacoes.apirest.repository.VeiculoRepository;

import io.swagger.annotations.ApiOperation;

import com.locacoes.apirest.models.Arquivo;
import com.locacoes.apirest.models.Locadora;
import com.locacoes.apirest.models.Opcionais;
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
	
	
	@Autowired
	OpcionaisRepository opcionaisRepository;
	
	
	@GetMapping("/veiculos")
	public List<Veiculo> listaVeiculos() {
		return veiculoRepository.buscarTodos();
	}

	@GetMapping("/veiculo/{id}")
	public Veiculo listaveiculoUnico(@PathVariable("id") Long id) {
		Veiculo veiculo = veiculoRepository.buscarVeiculo(id);
		System.out.println(veiculo);
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
	public  ResponseEntity<Veiculo> salvarVeiculo(@RequestBody Veiculo veiculo) {	
		veiculoRepository.save(veiculo);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
	}
	

	@GetMapping("/veiculos/seguros")
	public List<Seguro> buscarSeguro() {
		return seguroRepository.findAll();
	}
	
	@GetMapping("/veiculos/locadoras")
	public List<Locadora> buscarLocadora() {
		return locadoraRepository.buscarTodas();
	}
	
	@GetMapping("/veiculos/opcionais")
	public List<Opcionais> buscarOcionais() {
		return opcionaisRepository.findAll();
	}
	
	@GetMapping("/seguro/{id}")
	public Seguro seguroUnico(@PathVariable("id") Long id) {
		Seguro seguro = seguroRepository.buscarPeloId(id);
		return seguro;
	}
	
	@GetMapping("/locadora/{id}")
	public Locadora opcionalUnico(@PathVariable("id") Long id) {
		Locadora locadora = locadoraRepository.buscarPeloId(id);
		return locadora;
	}
	
	@GetMapping("/opcional/{id}")
	public Opcionais locadoraUnico(@PathVariable("id") Long id) {
		Opcionais opcional = opcionaisRepository.buscarPeloId(id);
		return opcional;
	}

}
