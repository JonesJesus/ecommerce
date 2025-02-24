package br.com.espacomulher.ecommerce.controller;

import br.com.espacomulher.ecommerce.model.Categoria;
import br.com.espacomulher.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> recuperarTodas(){
        return ResponseEntity.ok(service.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria nova){
        Categoria res = service.criaNova(nova);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping ("/categorias/{id}")
    public ResponseEntity<Categoria> alterarCategoria(@RequestBody Categoria categ, @PathVariable Integer id){
        categ.setId(id);
        Categoria res = service.alterar(categ);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> removerCategoria(@PathVariable Integer id){
        service.apagarCategoria(id);
        return ResponseEntity.ok("Removed");
    }
}
