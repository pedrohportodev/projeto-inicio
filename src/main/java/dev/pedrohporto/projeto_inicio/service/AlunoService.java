package dev.pedrohporto.projeto_inicio.service;

import dev.pedrohporto.projeto_inicio.DTO.AlunoDTO;
import dev.pedrohporto.projeto_inicio.DTO.AvaliacaoFisicaDTO;
import dev.pedrohporto.projeto_inicio.database.model.AlunosEntity;
import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import dev.pedrohporto.projeto_inicio.database.model.TreinosEntity;
import dev.pedrohporto.projeto_inicio.database.repository.IAlunosRepository;
import dev.pedrohporto.projeto_inicio.database.repository.IAvaliacoesFisicasRepository;
import dev.pedrohporto.projeto_inicio.database.repository.ITreinosRepository;
import dev.pedrohporto.projeto_inicio.exception.BadRequestException;
import dev.pedrohporto.projeto_inicio.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final IAlunosRepository alunosRepository;
    private final ITreinosRepository treinosRepository;
    private final IAvaliacoesFisicasRepository avaliacoesFisicasRepository;

    public List<AlunosEntity> findAll(){
        return alunosRepository.findAll();
    }
    public void criarAluno(AlunoDTO alunoDTO) throws BadRequestException {
       AlunosEntity alunos = alunosRepository.findByEmail(alunoDTO.email())
                .orElse(null);
       if(alunos != null){
           throw new BadRequestException("Aluno já cadastrado com esse email");
       }
       alunosRepository.save(AlunosEntity.builder()
                       .nome(alunoDTO.nome())
                       .email(alunoDTO.email())
               .build());

    }
    public AvaliacaoFisicaDTO getAvaliacoesFisicas(Long alunoId) throws NotFoundException {
     AlunosEntity aluno =alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacoesFisicas();
        if(avaliacao == null){
            throw new NotFoundException("Avaliação fisica não encontrada para este aluno");
        }
        return new AvaliacaoFisicaDTO(
                avaliacao.getId(),
                avaliacao.getPeso(),
                avaliacao.getAltura(),
                avaliacao.getPorcentagemBF()
        );

    }
    @Transactional
    public void deletarAluno(Long alunoId) throws NotFoundException{
        AlunosEntity aluno =alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));
        List<Long> treinoAlunosIds = aluno.getTreinos().stream()
                .map(TreinosEntity::getId)
                .toList();
        treinosRepository.deleteAllById(treinoAlunosIds);


        alunosRepository.deleteById(alunoId);
        avaliacoesFisicasRepository.deleteById(aluno.getAvaliacoesFisicas().getId());

    }
}
