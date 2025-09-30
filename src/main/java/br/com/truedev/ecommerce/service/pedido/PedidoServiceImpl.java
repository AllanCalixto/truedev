package br.com.truedev.ecommerce.service.pedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.PedidoDAO;
import br.com.truedev.ecommerce.model.ItemPedido;
import br.com.truedev.ecommerce.model.Pedido;

@Component
public class PedidoServiceImpl implements IPedidoService{
	
	@Autowired
	private PedidoDAO dao;

	@Override
	public Pedido criarNovoPedido(Pedido pedido) {
		double total = 0.0;
		double desconto = 0.0;
		pedido.setStatus(1);
		
		// preciso associar cada item ao pedido correspondente
		for(ItemPedido item: pedido.getItens()) {
			item.setPedido(pedido);
			pedido.setValorBruto(total);
			if(total >=30.0) {
				desconto = total * 0.10;
			}
			total = total - desconto;
		}
		pedido.setDesconto(desconto);
		pedido.setValor_total(total);
		return dao.save(pedido);
	}

	@Override
	public Pedido alterarDados(Pedido pedido) {
		return dao.save(pedido);
	}

	@Override
	public List<Pedido> recuperarTodos() {
		return (List<Pedido>)dao.findAll();
	}

	@Override
	public Pedido recuperarPeloNumero(Integer numPedido) {
		return dao.findById(numPedido).orElse(null);
	}

	@Override
	public List<Pedido> recuperarPorStatus(Integer status) {
		return dao.findAllByStatus(status);
	}

}
