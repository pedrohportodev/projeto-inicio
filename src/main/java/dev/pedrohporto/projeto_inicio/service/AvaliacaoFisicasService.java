package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacoesFisicasProjection;
import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import dev.pedrohporto.projeto_inicio.database.repository.IAlunosRepository;
import dev.pedrohporto.projeto_inicio.database.repository.IAvaliacoesFisicasRepository;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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

         aluno.setAvaliacoesFisicas(avaliacoesFisicas);
         alunosRepository.save(aluno);
    }
    public List<AvaliacoesFisicasProjection> getAllAvaliacoes(){
        return avaliacoesFisicasRepository.getAllAvaliacoes();
    }
    public Page<AvaliacoesFisicasProjection> getAllAvaliacoesPageable(Integer page, Integer size){

        avaliacoesFisicasRepository.findAll(Sort.by("id").descending());

        return avaliacoesFisicasRepository.getAllAvaliacoesPage(PageRequest.of(page,size));
    }

}
