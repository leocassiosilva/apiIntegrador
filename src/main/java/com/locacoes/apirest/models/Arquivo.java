package com.locacoes.apirest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "ARQUIVOS")
public class Arquivo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_arquivo;
	
	/*Coloquei aqui*/
	private String nome;
		
	
	@ManyToOne
	@JoinColumn(name = "id_veiculo")
	private Veiculo veiculo;

	public Long getId_arquivo() {
		return id_arquivo;
	}


	public void setId_arquivo(Long id_arquivo) {
		this.id_arquivo = id_arquivo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

