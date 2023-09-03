package net.rhuanrocha.samplerestful.repositories;

import net.rhuanrocha.samplerestful.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Optional<Produto> findById(Long id);
    List<Produto> findAll();
    Produto save(Produto produto);
    void delete(Produto produto);
    Produto update(Produto produto);
}
