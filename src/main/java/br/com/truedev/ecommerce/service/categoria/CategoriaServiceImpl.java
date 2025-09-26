package br.com.truedev.ecommerce.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.model.Categoria;

@Component
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaDAO dao;

	@Override
	public Categoria criarNova(Categoria nova) {
		return dao.save(nova);
	}

	@Override
	public Categoria alterar(Categoria categoria) {
		return dao.save(categoria);
	}

	@Override
	public List<Categoria> listarTodas() {
		return dao.findAllByOrderByNomeAsc();
	}

	@Override
	public void apagarCategoria(Integer id) {
		 dao.deleteById(id);
	}

}
