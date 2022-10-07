package br.univille.novostalentos.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity, @Id, e @GeneratedValue(Strategy = GenerationType.IDENTITY)
// Criam automaticamente a tabela, a Primary Key, e os campos do nosso BD.
@Entity//Nome da tabela
public class Cliente {
    @Id//Seta como a chave primary
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera automaticamente os campos da tabela no BD.
    private long id;
    @Column(length = 1000, nullable = false)//Aqui configura o tamanho do campo e aviso que ele não pode ser vaziu
    private String nome;
    @Column(length = 3000)
    private String endereco;
    private String sexo;
 //   @Temporal(value = TemporalType.DATE)//aqui eu especifico, que quero somente a data, excluindo horas e minutos. Isso pq o DATE, cria uma TIMESTAMP, que é um tipo de arquivo que cria pontos temporais (minutos, horas, dia, mês e ano).
    private Date dataNascimento;
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }    
    
}
