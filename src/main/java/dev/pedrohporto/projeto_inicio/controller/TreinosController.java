package dev.pedrohporto.projeto_inicio.controller;

import dev.pedrohporto.projeto_inicio.DTO.TreinoDTO;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import dev.pedrohporto.projeto_inicio.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/treinos")
@RequiredArgsConstructor
public class TreinosController {
    private final TreinoService treinoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarTreino(@Valid @RequestBody TreinoDTO treinoDTO) throws NotFoundException, BadRequestException {
        treinoService.criarTreino(treinoDTO);
    }


}
