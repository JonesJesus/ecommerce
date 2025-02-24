package br.com.espacomulher.ecommerce.service.cliente;

import br.com.espacomulher.ecommerce.dao.ClienteDAO;
import br.com.espacomulher.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteDAO cliDAO;

    @Override
    public Cliente cadastrarNovoCliente(Cliente novo) {
        return cliDAO.save(novo);
    }

    @Override
    public Cliente alterarCliente(Cliente cliente) {
        return cliDAO.save(cliente);
    }

    @Override
    public Cliente recuperarPeloId(Integer id) {
        return cliDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperarClientePeloTelefone(String telefone) {
        return cliDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>)cliDAO.findAll();
    }
}
