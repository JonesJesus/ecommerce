package br.com.espacomulher.ecommerce.service.usuario;

import br.com.espacomulher.ecommerce.model.Usuario;
import br.com.espacomulher.ecommerce.security.ECToken;

public interface IUsuarioService {
    public Usuario cadastrarNovo(Usuario novo);
    public Usuario alterarDados(Usuario usuario);
    public ECToken fazerLogin(String login, String senha);
}
