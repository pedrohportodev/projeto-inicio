package dev.pedrohporto.projeto_inicio.database.repository;

import dev.pedrohporto.projeto_inicio.DTO.AvaliacoesFisicasProjection;
import dev.pedrohporto.projeto_inicio.database.model.AvaliacoesFisicasEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import java.util.List;

public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity,Long> {
    @NativeQuery(value = """
        SELECT a.id  idAluno,
                       a.nome nomeAluno,
                               af.id idAvaliacao, af.altura altura, af.porcentagem_BF porcentagemBF 
                FROM avaliacoes_fisicas af
                INNER JOIN alunos a 
                ON a.avaliacao_fisica_id = af.id
                """)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes ();

    @NativeQuery(value = """
        SELECT a.id  idAluno,
                       a.nome nomeAluno,
                               af.id idAvaliacao, af.altura altura, af.porcentagem_BF porcentagemBF 
                FROM avaliacoes_fisicas af
                INNER JOIN alunos a 
                ON a.avaliacao_fisica_id = af.id
                """,
            countQuery = """
                    SELECT count(af.id)
                    FROM avaliacoes_fisicas af
                    INNER JOIN alunos a
                    On a.avaliacoes_fisica_id = af.id
                """
    )
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPage (Pageable pageable);

}
