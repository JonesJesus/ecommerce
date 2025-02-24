package br.com.espacomulher.ecommerce.controller;

import br.com.espacomulher.ecommerce.model.Cliente;
import br.com.espacomulher.ecommerce.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    //quais endpoints

    // se eu fizer   /clientes     GET  -- recupera tudão
    //se eu fizer   /cliente/id     GET  -- recupera pelo ID
    //se eu fizer   /clientes       POST -- inclui novo cliente
    //se ey fuzer  /clientes;id      PUT  -- altera o cliente de ID especificado
    //se eu fizer  /clientes/busca    GET --  busca pelo telefone
    //             /clientes/busca?telefone=xxxxx

    @Autowired
    private IClienteService cliServ;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll(){
        return ResponseEntity.ok(cliServ.recuperarTodos());
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id){
        Cliente result = cliServ.recuperarPeloId(id);
        if (result != null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo){
        try {
            Cliente result = cliServ.cadastrarNovoCliente(novo);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        } catch (Exception ex){
            System.out.println("LOG - Erro ao cadastrar - "+ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone")String telefone){
        Cliente res = cliServ.recuperarClientePeloTelefone(telefone);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id){
        cliente.setId(id);
        try {
            Cliente result = cliServ.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        }
        catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar - "+ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

}
