package dev.pedrohporto.projeto_inicio.controller;

import dev.pedrohporto.projeto_inicio.DTO.AlunoDTO;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.DTO.ExercicioDTO;
import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import dev.pedrohporto.projeto_inicio.database.model.ExerciciosEntity;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import dev.pedrohporto.projeto_inicio.service.AlunoService;
import dev.pedrohporto.projeto_inicio.service.ExerciciosService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {
private final AlunoService alunoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDTO alunoDTO) throws BadRequestException {
        alunoService.criarAluno(alunoDTO);
    }
    @GetMapping("/{alunoId}/avaliacao")
    @ResponseStatus(HttpStatus.OK)
    public AvaliacaoFisicaDTO getAvaliacaoFisica(@PathVariable Long alunoId) throws NotFoundException {
        return  alunoService.getAvaliacoesFisicas(alunoId);
    }
    @DeleteMapping("/{alunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAluno(@PathVariable Long alunoId) throws NotFoundException {
        alunoService.deletarAluno(alunoId);
    }
}
