package dev.pedrohporto.projeto_inicio.database.repository;

import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; // Importação necessária

import java.util.List;
import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Long> {

    Optional<AlunosEntity> findByEmail(String email);

    // CORREÇÃO: Nome corrigido para plural e parâmetro adicionado com @Param
    @Query(value = "SELECT a FROM AlunosEntity a JOIN FETCH a.avaliacoesFisicas WHERE a.id = :alunoId")
    Optional<AlunosEntity> findIdFetch(@Param("alunoId") Long alunoId);
}
