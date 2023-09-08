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

	public void salvar(Produto produto) {
		repository.save(produto);
	}
	

	/*
	 * INICIALMENTE VAMOS UTILIZAR O MÉTODO SALVAR, 
	 * QUANDO SE HÁ UM ID O JPA JA ENTENDE QUE O RECURSO EXISTE E ENTÃO EXECUTA UM UPDATE!
	 * APÓS A EVOLUÇÃO DOS SISTEMA IREMOS IMPLEMENTAR UM UPDATE MAIS COMPLETO E VALIDATIVO.
	 */
	public void atualizar(Produto produto) {
		salvar(produto);
	}

	public void excluirPorId(Long id) {
		 repository.deleteById(id);
	}
}
