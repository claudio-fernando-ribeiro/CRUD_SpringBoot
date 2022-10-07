package br.univille.novostalentos.service;

import java.util.List;
import br.univille.novostalentos.entity.Cidade;

public interface CidadeService { //Esse método oferece um método na camada de serviço, onde permite que a cidade possa fazer buscar a partir de um campo determinado (no caso ID)
    List<Cidade> getAll();
    Cidade save(Cidade cidade);
    Cidade findById(long id);
}
