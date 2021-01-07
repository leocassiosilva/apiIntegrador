package com.locacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locacoes.apirest.models.Locacao;
import com.locacoes.apirest.repository.LocacoesRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class LocacoesController {

	@Autowired
	LocacoesRepository locacoesRepository;

	
	@PostMapping("/locacao")
	@ApiOperation(value = "Retorna uma locação salva")
	public Locacao salvarLocacao(@RequestParam("locacao") Locacao locacao) {
		return locacoesRepository.save(locacao);
	}
	

	@GetMapping("/locacoes/{email}")
	@ApiOperation(value = "Lista as locações de um usuario")
	public List<Locacao> listaPeloUsuarioEmail(@PathVariable("email") String email) {
		return locacoesRepository.buscarPeloUsuario(email);
	}

}
