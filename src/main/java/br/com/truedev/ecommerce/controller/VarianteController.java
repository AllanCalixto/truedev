package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;

@RestController
public class VarianteController {

	@Autowired
	private IVarianteService service;
	
	@PostMapping("/variantes")
	public ResponseEntity<Variante> adicionar(@RequestBody Variante variante){
		try {
			Variante v = service.adicionarNova(variante);
			if (v != null) {
				return ResponseEntity.ok(v);
			}
		} catch (Exception ex) {
			System.out.println("LOG - Não foi possivel adicionar uma nova variante! " +ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/variantes/{id}")
	public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable Integer id){
		variante.setId(id);
		try {
			Variante var = service.alterarDados(variante);
			if (var != null) {
				return ResponseEntity.ok(var);
			}
		} catch (Exception ex) {
			System.out.println("LOG: Não foi possivel modificar uma variante! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/variantes/{id}")
	public ResponseEntity<Variante> recuperarPeloId(@PathVariable Integer id){
		Variante var = service.recuperarPeloId(id);
		if (var != null) {
			return ResponseEntity.ok(var);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/variantes")
	public ResponseEntity<List<Variante>> recuperaPeloProduto(@RequestParam(name="idproduto") Integer idProduto){
		Produto p = new Produto();
		p.setId(idProduto);
		return ResponseEntity.ok(service.recuperarPorProduto(p));
		
	}
}
