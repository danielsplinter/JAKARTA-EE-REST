package net.rhuanrocha.samplerestful.repositories.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import net.rhuanrocha.samplerestful.entity.Produto;
import net.rhuanrocha.samplerestful.repositories.ProdutoRepository;
import net.rhuanrocha.samplerestful.services.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryImpl implements ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Produto> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Produto.class, id));
    }

    public List<Produto> findAll() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto save(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }

    public Produto update(Produto produto) {
        entityManager.merge(produto);
        return produto;
    }

    public void delete(Produto produto) {
        entityManager.remove(produto);
    }
}