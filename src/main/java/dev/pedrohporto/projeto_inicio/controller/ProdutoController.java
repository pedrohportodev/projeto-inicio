package dev.pedrohporto.projeto_inicio.controller;

import dev.pedrohporto.projeto_inicio.DTO.ProdutoDTO;
import dev.pedrohporto.projeto_inicio.database.model.ProdutoEntity;
import dev.pedrohporto.projeto_inicio.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor // Anotação para não precisar criar um construtor toda vez que utilizar uma dependencia
public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll(){
        return  produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.createProduct(produtoDTO);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
public ProdutoEntity updateProduct(@PathVariable Integer id,
        @RequestBody ProdutoDTO produtoDTO){
           return produtoService.atualizarProduto(produtoDTO,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id){
        produtoService.removerProduto(id);
    }
}