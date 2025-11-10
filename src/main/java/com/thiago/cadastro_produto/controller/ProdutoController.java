package com.thiago.cadastro_produto.controller;

import com.thiago.cadastro_produto.business.ProdutoService;
import com.thiago.cadastro_produto.infrastructure.entitys.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto) {
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Produto> buscarProdutoPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoService.buscarProdutoPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarProdutoPorNome(@RequestParam String nome){
        produtoService.deletarProdutoPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Produto> atualizarProdutoPorId(@RequestParam UUID id, @RequestBody Produto produto){
        produtoService.atualizarProdutoPorId(id,produto);
        return ResponseEntity.ok().build();
    }

}
