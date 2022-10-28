package br.univille.novostalentos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.univille.novostalentos.entity.Produto;


@Repository
public interface ProdutoRepository //um contrato de comumincação, a interface não executa
    extends JpaRepository<Produto,Long>{//Herdamos outra interface, informando qual a classe que representa nossos dados, e no segundo param o tipo de dados da chave primária ou identificador do nosso objeto 
    List<Produto> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
    }

