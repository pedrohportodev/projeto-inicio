package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import dev.pedrohporto.projeto_inicio.database.repository.IAlunosRepository;
import dev.pedrohporto.projeto_inicio.database.repository.IAvaliacoesFisicasRepository;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicasService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public void criarAvaliacao(AvaliacaoFisicaDTO avaliacaoDTO) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoDTO.alunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
        AvaliacoesFisicasEntity avaliacoesFisicas = aluno.getAvaliacoesFisicas();
        if (avaliacoesFisicas != null) {
            throw new BadRequestException("Avaliação fisica ja cadastrada para este aluno");
        }
        avaliacoesFisicas = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoDTO.peso())
                .altura(avaliacaoDTO.altura())
                .porcentagemBF(avaliacaoDTO.porcentagemBF()).build();
         avaliacoesFisicas = avaliacoesFisicasRepository.save(avaliacoesFisicas);
         aluno.setAvaliacoesFisicas(avaliacoesFisicas);
         alunosRepository.save(aluno);
    }

}
