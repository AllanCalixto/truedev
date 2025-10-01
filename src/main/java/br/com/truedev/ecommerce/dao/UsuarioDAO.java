package br.com.truedev.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.truedev.ecommerce.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	public Usuario findByLogin(String login);
}
