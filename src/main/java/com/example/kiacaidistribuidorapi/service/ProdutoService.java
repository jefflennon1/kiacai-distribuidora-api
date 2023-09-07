package com.example.kiacaidistribuidorapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kiacaidistribuidorapi.models.Produto;
import com.example.kiacaidistribuidorapi.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> listar(){
		return repository.findAll();
	}

	public Produto buscarPorId(Long id) {  
		return repository.buscarPorId(id);
	}
}
