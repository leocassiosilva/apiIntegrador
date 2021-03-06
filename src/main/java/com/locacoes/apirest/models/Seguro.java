package com.locacoes.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
@Entity
@Table(name = "SEGURO")
public class Seguro implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_seguro;
	
	private String nome;
	
	private double preco;
	
	@OneToMany(mappedBy = "seguro")
	private List<Locacao> locacoes;
	
	public Long getId_seguro() {
		return id_seguro;
	}

	public void setId_seguro(Long id_seguro) {
		this.id_seguro = id_seguro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
