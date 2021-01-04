package com.locacoes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locacoes.apirest.models.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {

}
