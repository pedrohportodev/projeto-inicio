package dev.pedrohporto.projeto_inicio.DTO;

import jakarta.validation.constraints.NotBlank;

public record AlunoDTO(
        @NotBlank(message = " O nome é obrigatorio")
        String nome,
        @NotBlank(message = " O Grupo muscular  é obrigatorio")
        String email) {

}
