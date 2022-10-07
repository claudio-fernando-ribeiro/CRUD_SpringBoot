package br.univille.novostalentos.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import br.univille.novostalentos.entity.Cidade;


@Repository //Interface é um contrato entre duas classes, onde elas "conversam" entre os métodos
public interface CidadeRepository extends JpaRepository <Cidade,Long> {
    List<Cidade> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
} //o JpaRepository é um dos tipos de repository que tem no spring Data
