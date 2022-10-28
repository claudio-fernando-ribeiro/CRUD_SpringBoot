package br.univille.novostalentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//uma entidade representa os dados que meu sistema está gerenciando, e isso vai para o banco de dados. 

@Entity //Aqui e (@Id e @GeneratedValue), eu informo que quero que eles vão ao meu banco de dados. 
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)//Ele é opcional, para personalizar a aplicação.
    private String nome;

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String toString(){
        return getNome();
    }
}
