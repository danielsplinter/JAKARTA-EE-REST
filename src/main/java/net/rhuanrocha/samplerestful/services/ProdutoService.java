package net.rhuanrocha.samplerestful.services;

import net.rhuanrocha.samplerestful.entity.Produto;

import java.util.List;

public interface ProdutoService {
    Produto findById(Long id);
    List<Produto> findAll();
    Produto save(Produto produto);
    void deleteById(Long id);
}
