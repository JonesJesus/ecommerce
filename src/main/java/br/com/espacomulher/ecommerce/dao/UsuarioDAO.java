package br.com.espacomulher.ecommerce.dao;

import br.com.espacomulher.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {
    public Usuario findByLogin(String login);
}
