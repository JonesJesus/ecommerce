package br.com.espacomulher.ecommerce.dao;

import br.com.espacomulher.ecommerce.dto.FaturamentoMensal;
import br.com.espacomulher.ecommerce.model.Pedido;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAllByStatus(Integer status);

    //criando uma query customizada para recuperar faturamente
    @Query("SELECT new" +
            " br.com.espacomulher.ecommerce.dto.FaturamentoMensal(month(p.dataPedido), sum(p.valorTotal)) " +
            " FROM Pedido p" +
            " Where year(p.dataPedido) = :ano " +
            " GROUP BY month(p.dataPedido) ")
    public List<FaturamentoMensal> recuperarFaturamento(@Param("ano")Integer ano);

}
