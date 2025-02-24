package br.com.espacomulher.ecommerce.service.categoria;

import br.com.espacomulher.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    public Categoria criaNova(Categoria nova);
    public Categoria alterar(Categoria categoria);
    public List<Categoria> listarTudo();
    public void apagarCategoria(Integer id);
}
