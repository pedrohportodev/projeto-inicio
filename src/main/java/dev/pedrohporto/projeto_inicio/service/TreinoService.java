package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.TreinoDTO;
import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import dev.pedrohporto.projeto_inicio.database.model.ExerciciosEntity;
import dev.pedrohporto.projeto_inicio.database.model.TreinosEntity;
import dev.pedrohporto.projeto_inicio.database.repository.IAlunosRepository;
import dev.pedrohporto.projeto_inicio.database.repository.IExerciciosRepository;
import dev.pedrohporto.projeto_inicio.database.repository.ITreinosRepository;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {
    private final IExerciciosRepository exerciciosRepository;
    private final IAlunosRepository alunosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();
        AlunosEntity aluno =alunosRepository.findById(treinoDTO.aluno())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        TreinosEntity treinos = treinosRepository.findByNomeAndAluno_Id(treinoDTO.nome(),treinoDTO.aluno())
            .orElse(null);

        if(treinos != null){
            throw new BadRequestException(("Já existe um treino com es se nome para esse aluno !"));
        }
        for(Long exercicioId : treinoDTO.exerciciosIds()){
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException("Exercicio não encontrado"));
            exercicios.add(exercicio);
        }
        treinos = TreinosEntity.builder()
                .nome(treinoDTO.nome())
                .aluno(aluno)
                .exercicios(exercicios)
                .build();
    treinosRepository.save(treinos);
    }

    }

