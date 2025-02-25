package br.com.espacomulher.ecommerce.service.produto;

import br.com.espacomulher.ecommerce.dao.ProdutoDAO;
import br.com.espacomulher.ecommerce.model.Categoria;
import br.com.espacomulher.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO dao;

    @Override
    public Produto cadastrarNovo(Produto novo) {
        return dao.save(novo);
    }

    @Override
    public Produto alterarProduro(Produto produto) {
        return dao.save(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return dao.findByOrderByNomeAsc();
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavraChave) {
        return dao.findByNomeContaining(palavraChave);
    }

    @Override
    public Produto buscarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public List<Produto> buscarPorCategoria(Categoria categoria) {
        return dao.findByCategoriasContaining(categoria);
    }


}
