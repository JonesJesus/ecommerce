package br.com.espacomulher.ecommerce.service.produto;

import br.com.espacomulher.ecommerce.model.Categoria;
import br.com.espacomulher.ecommerce.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProdutoService {
    public Produto cadastrarNovo(Produto novo);
    public Produto alterarProduro(Produto produto);
    public Page<Produto> recuperarTodos(int numPagina);
    public List<Produto> recuperarPorPalavraChave(String palavraChave);
    public Produto buscarPeloId(Integer id);
    public List<Produto> buscarPorCategoria(Categoria categoria);
}
