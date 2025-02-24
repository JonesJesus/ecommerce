package br.com.espacomulher.ecommerce.dao;

import br.com.espacomulher.ecommerce.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    public Cliente findByTelefone(String telefone);
}
