package br.univille.novostalentos.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String nome;
    @Column(length = 3000)
    private String descricao;
    private float valor;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) //Cascade = me deixa configurar o que vai acontecer com a classe assossiativa se acontecer alguma cisa com a classe principal. CascadeType.All faz com que tudo que eu fizer com o produto vai ser replicado na cidade, inclusive incluir elementos e excluir elementos. 
    private Cidade cidadeProduto;
    
    
    public Cidade getCidadeProduto() {
        return cidadeProduto;
    }
    public void setCidadeProduto(Cidade cidadeProduto) {
        this.cidadeProduto = cidadeProduto;
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
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}
