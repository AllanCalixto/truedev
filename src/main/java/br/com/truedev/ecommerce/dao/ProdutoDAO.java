package br.com.truedev.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;

public interface ProdutoDAO extends JpaRepository<Produto, Integer>{
	
	public List<Produto> findByNomeContaining(String palavra);
	public Page<Produto> findByOrderByNomeAsc(Pageable pageable);
	public List<Produto> findByCategoriasContaining(Categoria categoria);

}
