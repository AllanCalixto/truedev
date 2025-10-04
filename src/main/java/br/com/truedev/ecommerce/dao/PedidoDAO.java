package br.com.truedev.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido, Integer>{
	
	public List<Pedido> findAllByStatus(Integer status);
	
	/* recuperar faturamento */
	@Query("SELECT new br.com.truedev.ecommerce.dto.FaturamentoMensal(MONTH(p.data), SUM(p.valor_total)) "
		       + "FROM Pedido p "
		       + "WHERE YEAR(p.data) = :ano "
		       + "GROUP BY MONTH(p.data)")
		public List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);

	

}
