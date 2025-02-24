package br.com.espacomulher.ecommerce.service.cliente;

import br.com.espacomulher.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente cadastrarNovoCliente(Cliente novo);
    public Cliente alterarCliente(Cliente cliente);
    public Cliente recuperarPeloId(Integer id);
    public Cliente recuperarClientePeloTelefone(String telefone);
    public List<Cliente> recuperarTodos();
}
