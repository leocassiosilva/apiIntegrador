package com.locacoes.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locacoes.apirest.repository.VeiculoRepository;
import com.locacoes.apirest.models.Veiculo;

@RestController
@RequestMapping(value = "/api")
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRepository;
	
	@GetMapping("/veiculos")
	public List<Veiculo> listaVeiculos(){
		return veiculoRepository.buscarTodos();
	}
	
	@GetMapping("/veiculos/{id}")
	public Optional<Veiculo> listaveiculoUnico(@PathVariable("id") Long id) {
		return veiculoRepository.findById(id);
	}
	
}
