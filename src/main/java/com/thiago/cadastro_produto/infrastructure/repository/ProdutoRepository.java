package com.thiago.cadastro_produto.infrastructure.repository;

import com.thiago.cadastro_produto.infrastructure.entitys.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    Optional<Produto> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}


