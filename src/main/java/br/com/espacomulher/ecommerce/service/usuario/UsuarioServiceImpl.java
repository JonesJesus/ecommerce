package br.com.espacomulher.ecommerce.service.usuario;

import br.com.espacomulher.ecommerce.dao.UsuarioDAO;
import br.com.espacomulher.ecommerce.model.Usuario;
import br.com.espacomulher.ecommerce.security.ECToken;
import br.com.espacomulher.ecommerce.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDAO dao;

    @Override
    public Usuario cadastrarNovo(Usuario novo) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(novo.getSenha());

        novo.setSenha(novaSenha);
        return dao.save(novo);
    }

    @Override
    public Usuario alterarDados(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());

        usuario.setSenha(novaSenha);
        return dao.save(usuario);
    }

    @Override
    public ECToken fazerLogin(String login, String senha) {
        Usuario u = dao.findByLogin(login);
        if (u != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(senha, u.getSenha())){
                return ECTokenUtil.generateToken(u);
            }
        }
        return null;
    }
}
