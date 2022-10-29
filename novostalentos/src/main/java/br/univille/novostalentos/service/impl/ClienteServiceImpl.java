package br.univille.novostalentos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.novostalentos.entity.Cliente;
import br.univille.novostalentos.repository.ClienteRepository;
import br.univille.novostalentos.service.ClienteService;

@Service // tem que ter a anotação, senão haverá erro. 
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repositorio;

    @Override
    public List<Cliente> getAll() {
        // TODO Auto-generated method stub
        return repositorio.findAll();
    } // Aqui eu aceito o contrato com a interface do ClienteService.

    @Override
    public Cliente save(Cliente cliente) {
        return repositorio.save(cliente);
    }

    @Override
    public Cliente findById(long id) {            //Como existe a possibilidade de não existir
        var resultado = repositorio.findById(id); //o Id, eu digo "Se o resultado da pesquisa
        if(resultado.isPresent()){                //existir, você me volta ele",
            return resultado.get();               //se ele não existir, me volta um
        }                                         //um novo Cliente. Assim garanto que sempre
        return new Cliente();                     //volta algo.
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
        
    }

    @Override 
    public List<Cliente> findByNome(String nome) { //Esse método foi criado para ajudar na implementação da API, quando buscar por nomes (Like no MySQL). Ela não possui nenhuma ligação direta com o restante da aplicação
        return repositorio.findByNomeIgnoreCaseContaining(nome);
    }
     
}
