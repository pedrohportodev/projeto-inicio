package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.ExercicioDTO;
import dev.pedrohporto.projeto_inicio.database.model.ExerciciosEntity;
import dev.pedrohporto.projeto_inicio.database.repository.IExerciciosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {
private final IExerciciosRepository exerciciosRepository;

public List<ExerciciosEntity> findAll(){
    return exerciciosRepository.findAll();
}
    public void save(ExercicioDTO exercicioDTO) {

        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exercicioDTO.nome())
                .grupoMuscular(exercicioDTO.grupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);
    }
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular){
    return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }

}
