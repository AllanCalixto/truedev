package br.com.truedev.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.service.usuario.IUsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;

	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario novo) {
		try {
			Usuario res = service.cadastrarNovo(novo);
			if(res != null) {
				return ResponseEntity.status(201).body(res);
			}
			
		} catch (Exception ex) {
			System.out.println("Não foi possivel cadastrar um novo usuario! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();

	}
	
	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> alterarDados(@RequestBody Usuario usuario, @PathVariable Integer id){
		usuario.setIdUsuario(id);
		try {
			Usuario res = service.alterarDados(usuario);
			if(res != null) {
				return ResponseEntity.ok(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG: Não foi possivel atualizar o os dados do usuario! "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
}
