package com.example.kiacaidistribuidorapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.kiacaidistribuidorapi.models.Produto;

import jakarta.transaction.Transactional;

@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT * FROM PRODUTOS WHERE ID = :id", nativeQuery = true)
	Produto buscarPorId(Long id);

}
