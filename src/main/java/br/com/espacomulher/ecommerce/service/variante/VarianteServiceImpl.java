package br.com.espacomulher.ecommerce.service.variante;

import br.com.espacomulher.ecommerce.dao.VarianteDAO;
import br.com.espacomulher.ecommerce.model.Produto;
import br.com.espacomulher.ecommerce.model.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService{

    @Autowired
    private VarianteDAO dao;

    @Override
    public Variante adicionarNova(Variante nova) {
        return dao.save(nova);
    }

    @Override
    public Variante alterarDados(Variante variante) {
        return dao.save(variante);
    }

    @Override
    public List<Variante> recuperarPorProduto(Produto p) {
        return dao.findByProduto(p);
    }

    @Override
    public Variante recuperarPeloId(Integer id) {
        return dao.findById(id).orElse(null);
    }
}
