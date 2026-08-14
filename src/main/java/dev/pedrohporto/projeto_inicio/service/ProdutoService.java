package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.ProdutoDTO;
import dev.pedrohporto.projeto_inicio.database.model.ProdutoEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static final List<ProdutoEntity> PRODUTOS = List.of(

            ProdutoEntity.builder()
                    .id(1)
                    .nome("Iphone 17")
                    .preco(new BigDecimal (17500))
                    .qntd(10).build(),
            ProdutoEntity.builder()
                    .id(2)
                    .nome("Notebook")
                    .preco(new BigDecimal(5000))
                    .qntd(15).build(),
            ProdutoEntity.builder()
                    .id(3)
                    .nome("S26")
                    .preco(new BigDecimal(7800))
                    .qntd(22).build()
  );
    public List<ProdutoEntity> findAll(){
        return  new ArrayList<>(PRODUTOS);
    }
    public ProdutoEntity createProduct(ProdutoDTO produtoDTO){
        Integer identificador = PRODUTOS.stream()
                .mapToInt(ProdutoEntity::getId)
                .max()
                .orElse(0) + 1;

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .id(identificador)
                .nome(produtoDTO.getNome())
                .preco(produtoDTO.getPreco())
                .qntd(produtoDTO.getQntd())
                .build();

        PRODUTOS.add(novoProduto);
        return novoProduto;
    }
}
