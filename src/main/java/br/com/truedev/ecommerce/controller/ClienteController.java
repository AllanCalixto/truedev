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

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAll(){
		return ResponseEntity.ok(clienteService.recuperarTodos());
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> getById(@PathVariable Integer id){
		Cliente result = clienteService.recuperarClientePeloId(id);
		if(result != null) {
			return ResponseEntity.ok(result);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<Cliente> inserirNovo(@RequestBody Cliente novo){
		try {
			Cliente result = clienteService.cadastrarNovoCliente(novo);
			if(result != null) {
				return ResponseEntity.status(201).body(result);
			}
		} catch (Exception ex) {
			System.out.println("LOG  - Erro ao Cadastrar - "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/clientes/busca")
	public ResponseEntity<Cliente> buscarPorTelefone(@RequestParam(name="telefone") String telefone){
		Cliente res = clienteService.recuperarClientePeloTelefone(telefone);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable Integer id){
		cliente.setId(id);
		try {
			Cliente result = clienteService.alterarCliente(cliente);
			if(result != null) {
				return ResponseEntity.ok(result);
			}
		} catch(Exception ex) {
			System.out.println("LOG - Erro ao atualizar - "+ex.getMessage());
		}
		return ResponseEntity.badRequest().build();
	}
}
