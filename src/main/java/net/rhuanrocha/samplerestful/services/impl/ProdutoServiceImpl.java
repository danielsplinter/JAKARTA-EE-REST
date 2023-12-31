package net.rhuanrocha.samplerestful.services.impl;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import net.rhuanrocha.samplerestful.entity.Produto;
import net.rhuanrocha.samplerestful.repositories.ProdutoRepository;
import net.rhuanrocha.samplerestful.services.ProdutoService;
import net.rhuanrocha.samplerestful.services.exceptions.ProductNotFoundException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Stateless
public class ProdutoServiceImpl implements ProdutoService {
    @Inject
    ProdutoRepository produtoRepository;

    @Override
    public Produto findById(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado"));
        return produto;
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto save(Produto produto) {
        produto.setUltimaAtualizacao(LocalDateTime.now(ZoneId.of("UTC")));

        if(produto.getId() == null){
            produto.setDataCadastro(LocalDateTime.now(ZoneId.of("UTC")));
            produtoRepository.save(produto);
            return produto;
        }

        produtoRepository.update(produto);

        return produto;
    }

    @Override
    public void deleteById(Long id) {
        Produto produtoEncontrado = findById(id);
        produtoRepository.delete(produtoEncontrado);
    }
}
