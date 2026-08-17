package dev.pedrohporto.projeto_inicio.database.repository;
import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Long> {
}
