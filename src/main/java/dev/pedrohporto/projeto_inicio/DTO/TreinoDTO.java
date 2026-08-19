package dev.pedrohporto.projeto_inicio.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record TreinoDTO(
        @NotNull Long aluno,
        @NotBlank String nome,
        @NotEmpty List<Long> exerciciosIds

        ) {
}
