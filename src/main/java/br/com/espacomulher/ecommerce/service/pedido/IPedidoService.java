package br.com.espacomulher.ecommerce.service.pedido;

import br.com.espacomulher.ecommerce.dto.FaturamentoMensal;
import br.com.espacomulher.ecommerce.model.Pedido;
import org.springframework.objenesis.instantiator.perc.PercInstantiator;

import java.util.List;

public interface IPedidoService {

    public Pedido criarNovoPedido(Pedido pedido);
    public Pedido alterarDados(Pedido pedido);
    public List<Pedido> recuperarTodos();
    public Pedido recuperarPeloNumero(Integer numPedido);
    public List<Pedido> recuperarPorStatus(Integer status);
    public List<FaturamentoMensal> recuperarFaturamento(Integer ano);
}
