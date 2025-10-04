package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.produto.IProdutoService;

@RestController
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	@GetMapping("/produtos")
	public ResponseEntity<Page<Produto>> recuperarTodos(@RequestParam(name="p", defaultValue = "1") int p){

		return ResponseEntity.ok(service.recuperarTodos(p));
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id){
		Produto res = service.buscarPeloId(id);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> incluirNovo(@RequestBody Produto novo){
		try {
			Produto res = service.cadastrarNovo(novo);
			if(res != null) {
				return ResponseEntity.status(201).body(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG - Não foi possivel cadastrar um novo produto!" +ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Integer id){
		produto.setId(id);
		try {
			Produto res = service.alterarProduto(produto);
			if(res != null) {
				return ResponseEntity.ok(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG - Não foi possivel alterar um produto! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/produtos/search")
	public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name="key") String key){
		List<Produto> lista = service.recuperarPorPalavraChave(key);
		if(lista.size() > 0 ) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/produtos/categoria/{id}")
	public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id){
		Categoria categ = new Categoria();
		categ.setId(id);
		return ResponseEntity.ok(service.buscarPorCategoria(categ));
	}
	
	
}
