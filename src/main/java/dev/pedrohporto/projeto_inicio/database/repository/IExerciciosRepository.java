package dev.pedrohporto.projeto_inicio.database.repository;

import dev.pedrohporto.projeto_inicio.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Long> {

 List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

 @Query(value = """
       SELECT e FROM ExerciciosEntity e
        WHERE UPPER(e.grupoMuscular) = UPPER(:grupoMuscular)""")
 List<ExerciciosEntity> findAllByGrupoMuscularJpql(@Param("grupoMuscular") String grupoMuscular);
}
