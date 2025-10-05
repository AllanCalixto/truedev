package br.com.truedev.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;
import br.com.truedev.ecommerce.service.pedido.IPedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private IPedidoService service;
	
	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido novo){
		try {
			Pedido res = service.criarNovoPedido(novo);
			if (res != null) {
				return ResponseEntity.status(201).body(res);
			}
		} catch (Exception ex) {
			System.out.println("LOG - Não foi possivel inserir um novo pedido! "+ex.getMessage());	
			}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> recuperarTodos(){
		return ResponseEntity.ok(service.recuperarTodos());
	}
	
	@GetMapping("/pedidos/{id}")
	public ResponseEntity<Pedido> recuperarPorId(@PathVariable Integer id){
		Pedido res = service.recuperarPeloNumero(id);
		if(res != null){
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/pedidos/faturamento/{ano}")
	public ResponseEntity<List<FaturamentoMensal>> recuperarFaturamento(@PathVariable Integer ano){
		return ResponseEntity.ok(service.recuperarFaturamento(ano));
	}

}
