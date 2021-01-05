package com.locacoes.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locacoes.apirest.models.Seguro;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
	Optional<Seguro> findById(Long id);
}
