package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.ICategoriaService;

@RestController
public class CategoriaController {
	
	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> recuperarTodas(){
		return ResponseEntity.ok(service.listarTodas());
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria nova){
		try {
			Categoria res = service.criarNova(nova);
			if(res != null) {
				return ResponseEntity.status(201).body(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG - Não foi possivel criar uma nova categoria! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/categorias/{id}")
	public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria categoria, @PathVariable Integer id){
		categoria.setId(id);
		try {
			Categoria res = service.alterar(categoria);
			if(res != null) {
				return ResponseEntity.ok(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG: Não foi possivel alterar uma categoria! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<?> removerCategoria(@PathVariable Integer id){
		service.apagarCategoria(id);
		return ResponseEntity.ok("Removido!");
	}
}
