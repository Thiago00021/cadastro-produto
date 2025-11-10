package com.thiago.cadastro_produto.business;

import com.thiago.cadastro_produto.infrastructure.entitys.Produto;
import com.thiago.cadastro_produto.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Produto produto){
        repository.saveAndFlush(produto);
    }

    public Produto buscarProdutoPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarProdutoPorNome(String nome){
        repository.deleteByNome(nome);
    }

    public void atualizarProdutoPorId(UUID id, Produto produto){
        Produto produtoEntity = repository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        Produto produtoAtualizado = Produto.builder()
                .nome(produto.getNome() != null ? produto.getNome(): produtoEntity.getNome())
                .preco(produto.getPreco() != null ? produto.getPreco(): produtoEntity.getPreco())
                .id(produtoEntity.getId())
                .build();
        repository.saveAndFlush(produtoAtualizado);
    }
}
