package dev.pedrohporto.projeto_inicio.database.repository;
import dev.pedrohporto.projeto_inicio.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Long> {
}
