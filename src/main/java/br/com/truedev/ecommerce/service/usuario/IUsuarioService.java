package br.com.truedev.ecommerce.service.usuario;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;

public interface IUsuarioService {
	
	public Usuario cadastrarNovo(Usuario novo);
	public Usuario alterarDados(Usuario usuario);
	public ECToken fazerLogin (String login, String senha);

}
