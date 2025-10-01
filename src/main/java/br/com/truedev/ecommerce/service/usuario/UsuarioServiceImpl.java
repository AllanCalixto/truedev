package br.com.truedev.ecommerce.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.UsuarioDAO;
import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public Usuario cadastrarNovo(Usuario novo) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String novaSenha = encoder.encode(novo.getSenha());
		
		novo.setSenha(novaSenha);
		return dao.save(novo);
	}

	@Override
	public Usuario alterarDados(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ECToken fazerLogin(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}
