package br.com.espacomulher.ecommerce.dao;

import br.com.espacomulher.ecommerce.model.Pedido;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAllByStatus(Integer status);
}
