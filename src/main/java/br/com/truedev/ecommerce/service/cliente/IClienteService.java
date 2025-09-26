package br.com.truedev.ecommerce.service.cliente;

import java.util.List;

import br.com.truedev.ecommerce.model.Cliente;

public interface IClienteService {
	
	public Cliente cadastrarNovoCliente(Cliente novo);
	public Cliente alterarCliente(Cliente cliente);
	public Cliente recuperarClientePeloId(Integer id);
	public Cliente recuperarClientePeloTelefone(String telefone);
	public List<Cliente> recuperarTodos();

}
