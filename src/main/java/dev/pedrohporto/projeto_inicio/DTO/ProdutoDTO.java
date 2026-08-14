package dev.pedrohporto.projeto_inicio.DTO;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProdutoDTO {
    private String nome;
    private BigDecimal preco;
    private Integer qntd;

}
