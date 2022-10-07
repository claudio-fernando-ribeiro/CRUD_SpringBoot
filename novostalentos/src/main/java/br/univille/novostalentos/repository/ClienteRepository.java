package br.univille.novostalentos.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import br.univille.novostalentos.entity.Cliente;

@Repository
public interface ClienteRepository //um contrato de comumincação, a interface não executa
    extends JpaRepository<Cliente,Long>{//Herdamos outra interface, informando qual a classe que representa nossos dados, e no segundo param o tipo de dados da chave primária ou identificador do nosso objeto 
    List<Cliente> findByNomeIgnoreCaseContaining(@Param("nome") String nome);
}
