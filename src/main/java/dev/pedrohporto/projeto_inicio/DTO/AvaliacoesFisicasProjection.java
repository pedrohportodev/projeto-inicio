package dev.pedrohporto.projeto_inicio.DTO;

import java.math.BigDecimal;

public interface AvaliacoesFisicasProjection {
    Long getIdAluno();
    String getNomeAluno();
    Long getIdAvaliacao();
    BigDecimal getPeso();
    BigDecimal getAltura();
    BigDecimal getPorcentagemBF();
}
