package dev.pedrohporto.projeto_inicio.controller;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import dev.pedrohporto.projeto_inicio.service.AvaliacaoFisicasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacao")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicasService avaliacaoFisicasService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacao(@Valid @RequestBody AvaliacaoFisicaDTO avaliacaoFisicaDTO) throws NotFoundException, BadRequestException {
        avaliacaoFisicasService.criarAvaliacao(avaliacaoFisicaDTO);
    }


}
