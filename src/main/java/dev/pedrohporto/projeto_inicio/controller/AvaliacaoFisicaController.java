package dev.pedrohporto.projeto_inicio.controller;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacoesFisicasProjection;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import dev.pedrohporto.projeto_inicio.service.AvaliacaoFisicasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacaoFisicasService.getAllAvaliacoes();
    }
    @GetMapping("/page/{page}/size/{size}")
    @ResponseStatus(HttpStatus.OK)
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoes(@PathVariable Integer page,
                                                              @PathVariable Integer size){
        return avaliacaoFisicasService.getAllAvaliacoesPageable(page,size);
    }


}
