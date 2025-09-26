package br.com.truedev.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;

@Component
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private ClienteDAO cliDAO;

	@Override
	public Cliente cadastrarNovoCliente(Cliente novo) {
		return cliDAO.save(novo);
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		return cliDAO.save(cliente);
	}

	@Override
	public Cliente recuperarClientePeloId(Integer id) {
		return cliDAO.findById(id).orElse(null);
	}

	@Override
	public Cliente recuperarClientePeloTelefone(String telefone) {
		return cliDAO.findByTelefone(telefone);
	}

	@Override
	public List<Cliente> recuperarTodos() {
		return (List<Cliente>)cliDAO.findAll();
	}

}
