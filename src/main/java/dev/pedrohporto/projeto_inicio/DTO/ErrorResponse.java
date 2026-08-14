package dev.pedrohporto.projeto_inicio.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ErrorResponse {
private String message;
private Integer status;
}
