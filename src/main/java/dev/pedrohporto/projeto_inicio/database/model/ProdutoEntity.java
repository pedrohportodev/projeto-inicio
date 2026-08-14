package dev.pedrohporto.projeto_inicio.database.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoEntity {
    private Integer id;
    private String nome;
    private BigDecimal preco;
    private Integer qntd;

}
