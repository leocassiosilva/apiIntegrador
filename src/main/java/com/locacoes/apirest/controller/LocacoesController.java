package com.locacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locacoes.apirest.models.Locacao;
import com.locacoes.apirest.repository.LocacoesRepository;

@RestController
@RequestMapping(value = "/api")
public class LocacoesController {

	@Autowired
	LocacoesRepository locacoesRepository;

	
	
	@PostMapping("/locacao")
	public Locacao salvarLocacao(@RequestBody Locacao locacao) {
		return locacoesRepository.save(locacao);
	}
	
	
	@GetMapping("/locacoes/{id}")
	public List<Locacao> listaPeloUsuario(@PathVariable("id") Long id) {
		return locacoesRepository.buscarPeloId(id);
	}

}
