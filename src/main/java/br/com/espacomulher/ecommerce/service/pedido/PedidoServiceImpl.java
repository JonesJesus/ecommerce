package br.com.espacomulher.ecommerce.service.pedido;

import br.com.espacomulher.ecommerce.dao.PedidoDAO;
import br.com.espacomulher.ecommerce.dto.FaturamentoMensal;
import br.com.espacomulher.ecommerce.model.ItemPedido;
import br.com.espacomulher.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService{

    @Autowired
    private PedidoDAO dao;

    @Override
    public Pedido criarNovoPedido(Pedido pedido) {
        //preciso associar  cada item ao pedido correspondente
        pedido.setStatus(1); //novo pedido
        for (ItemPedido item: pedido.getItens()) {
            item.setPedido(pedido);
        }
        // vou totalizar o pedido pelos valor dos itens e aplicar uma regrinha
        Double total = 0.0, desconto = 0.0;
        for (ItemPedido item: pedido.getItens()) {
            total += item.getValorTotal();
        }
        pedido.setValorBruto(total);
        if (total >= 30.0){
            desconto = total * 0.10;
        }
        total = total - desconto;

        pedido.setDesconto(desconto);
        pedido.setValorTotal(total);
        return dao.save(pedido);
    }

    @Override
    public Pedido alterarDados(Pedido pedido) {
        return dao.save(pedido);
    }

    @Override
    public List<Pedido> recuperarTodos() {
        return (List<Pedido>) dao.findAll();
    }

    @Override
    public Pedido recuperarPeloNumero(Integer numPedido) {
        return dao.findById(numPedido).orElse(null);
    }

    @Override
    public List<Pedido> recuperarPorStatus(Integer status) {
        return dao.findAllByStatus(status);
    }

    @Override
    public List<FaturamentoMensal> recuperarFaturamento(Integer ano) {
        return dao.recuperarFaturamento(ano);
    }
}
