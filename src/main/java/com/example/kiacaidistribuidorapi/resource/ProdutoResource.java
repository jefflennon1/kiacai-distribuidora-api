package com.example.kiacaidistribuidorapi.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/listar-produtos",
			produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> listar(){
	 try {
		 List<Produto> lista = service.listar(); 
		 return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping(value = "/buscar-produto", 
				produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarPorId(@RequestParam("id") Long id){
	 try {
		 Produto produto = service.buscarPorId(id); 
		 return produto == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(produto);
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value = "/salvar-produto", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> salvar(@RequestBody Produto produto){
	 try {
		 service.salvar(produto); 
		 URI location = URI.create(String.format("/produtos/buscar-produto?id=%s", produto.getId()));
		 return ResponseEntity.created(location).build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping(value = "/atualizar-produto", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> atualizar(@RequestBody Produto produto){
	 try {
		 service.atualizar(produto); 
		 URI location = URI.create(String.format("/produtos/buscar-produto?id=%s", produto.getId()));
		 return ResponseEntity.ok().location(location).build();
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/excluir-produto")
	public ResponseEntity<?> excluirPorId(@RequestParam("id") Long id){
	 try {
		 service.excluirPorId(id); 
		 return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			 return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
