package br.com.truedev.ecommerce.service.categoria;

import java.util.List;

import br.com.truedev.ecommerce.model.Categoria;

public interface ICategoriaService {
	
	public Categoria criarNova(Categoria nova);
	public Categoria alterar(Categoria categoria);
	public List<Categoria> listarTodas();
	public void apagarCategoria(Integer id);
	

}
