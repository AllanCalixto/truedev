package br.com.truedev.ecommerce.service.produto;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

public interface IProdutoService {
	
	public Produto cadastrarNovo(Produto novo);
	public Produto alterarProduto(Produto produto);
	public Page<Produto> recuperarTodos(int numPagina);
	public Page<Produto> recuperarTodos(Pageable pageable);
	public List<Produto> recuperarPorPalavraChave(String palavraChave);
	public Produto buscarPeloId(Integer id);
	public List<Produto> buscarPorCategoria(Categoria categoria);


}
