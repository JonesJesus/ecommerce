package br.com.espacomulher.ecommerce.controller;

import br.com.espacomulher.ecommerce.model.Categoria;
import br.com.espacomulher.ecommerce.model.Produto;
import br.com.espacomulher.ecommerce.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService service;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> recuperarTodos(){
        return ResponseEntity.ok(service.recuperarTodos());
    }

    @GetMapping("/produtos{id}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id){
        Produto res = service.buscarPeloId(id);
        if (res != null ){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> incluirNovo(@RequestBody Produto novo){
        Produto res = service.cadastrarNovo(novo);
        if ( res != null){
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos{id}")
    public ResponseEntity<Produto> alterarProduto(@RequestBody Produto produto, @PathVariable Integer id){
        produto.setId(id);
        Produto res = service.alterarProduro(produto);
        if (res != null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name = "key")String key){
        List<Produto> lista = service.recuperarPorPalavraChave(key);
        if(lista.size() > 0 ){
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id){
        Categoria categ = new Categoria();
        categ.setId(id);
        return ResponseEntity.ok(service.buscarPorCategoria(categ));
    }
}
