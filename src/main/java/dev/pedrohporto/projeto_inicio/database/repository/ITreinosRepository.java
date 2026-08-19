package dev.pedrohporto.projeto_inicio.database.repository;
import dev.pedrohporto.projeto_inicio.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Long> {
    Optional<TreinosEntity> findByNomeAndAluno_Id(String nome, Long alunoId);}
