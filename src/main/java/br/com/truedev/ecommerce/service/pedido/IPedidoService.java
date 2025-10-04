package br.com.truedev.ecommerce.service.pedido;

import java.util.List;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;

public interface IPedidoService {
	
	public Pedido criarNovoPedido(Pedido pedido);
	public Pedido alterarDados(Pedido pedido);
	public List<Pedido> recuperarTodos();
	public Pedido recuperarPeloNumero(Integer numPedido);
	public List<Pedido> recuperarPorStatus(Integer status);
	public List<FaturamentoMensal> recuperarFaturamento(Integer ano);
}
