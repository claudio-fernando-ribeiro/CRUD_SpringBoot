package br.univille.novostalentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.univille.novostalentos.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long>{
    //List<Venda> findByNomeIgnoreCaseContaining(@Param("id") Long id);
}
