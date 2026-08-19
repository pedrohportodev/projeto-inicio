package dev.pedrohporto.projeto_inicio.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties("hibernateLazyInitializer")
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_bf", nullable = false)
    private BigDecimal porcentagemBF;
}
