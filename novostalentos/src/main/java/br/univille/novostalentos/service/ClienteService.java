package br.univille.novostalentos.service;

import java.util.List;
import br.univille.novostalentos.entity.Cliente;

public interface ClienteService { //A interface serve quando eu criar um padrão de comunicação entre as classes java
    List<Cliente> getAll();
    Cliente save(Cliente cliente);
    Cliente findById(long id);
    void delete(long id);
    List<Cliente> findByNome(String nome);
}
