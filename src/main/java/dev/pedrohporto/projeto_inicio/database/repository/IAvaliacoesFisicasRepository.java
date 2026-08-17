package dev.pedrohporto.projeto_inicio.database.repository;

import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity,Long> {
}
