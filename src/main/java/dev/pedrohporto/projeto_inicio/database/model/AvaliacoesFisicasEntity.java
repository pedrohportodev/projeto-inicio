package dev.pedrohporto.projeto_inicio.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal peso;
    private BigDecimal altura;
    @Column(name = "porcentagem_bf")
    private BigDecimal porcentagemBF;
}
