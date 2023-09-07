package com.example.kiacaidistribuidorapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kiacaidistribuidorapi.models.Produto;
import com.example.kiacaidistribuidorapi.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;

	@GetMapping(value = "/listar",
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> listar(){
	 try {
		 List<Produto> lista = service.listar(); 
		 return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(value = "/buscar-produto", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarPorId(@RequestParam("id") Long id){
	 try {
		 Produto produto = service.buscarPorId(id); 
		 return produto == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(produto);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().build();
		}
	}
}
