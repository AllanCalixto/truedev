package br.com.truedev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.truedev.ecommerce.model.Cliente;

public interface ClienteDAO extends CrudRepository<Cliente, Integer>{

	public Cliente findByTelefone(String telefone);
}
