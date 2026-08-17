package dev.pedrohporto.projeto_inicio.DTO;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record AvaliacaoFisicaDTO(
       @NotNull
        Long alunoId,
       @NotNull
        BigDecimal peso,
       @NotNull
        BigDecimal altura,
       @NotNull
        BigDecimal porcentagemBF) {

}
