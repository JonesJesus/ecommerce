package br.com.espacomulher.ecommerce.controller;

import br.com.espacomulher.ecommerce.model.Usuario;
import br.com.espacomulher.ecommerce.security.ECToken;
import br.com.espacomulher.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private IUsuarioService service;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario novo){
        Usuario res = service.cadastrarNovo(novo);
        if (res != null){
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> alterarDados(@RequestBody Usuario usuario, @PathVariable Integer id){
        usuario.setIdUsuario(id);
        Usuario res = service.alterarDados(usuario);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> realizarLogin(@RequestBody Usuario usuario){
        ECToken token = service.fazerLogin(usuario.getLogin(), usuario.getSenha());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }
}
