package br.com.espacomulher.ecommerce.service.variante;

import br.com.espacomulher.ecommerce.model.Produto;
import br.com.espacomulher.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {
    public Variante adicionarNova (Variante nova);
    public Variante alterarDados (Variante variante);
    public List<Variante> recuperarPorProduto (Produto p);
    public Variante recuperarPeloId(Integer id);
}
