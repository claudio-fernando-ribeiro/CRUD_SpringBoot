package br.univille.novostalentos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH}) //por padrão tudo que acontece com uma classe, acontece com o outra, no caso, ex. se eu apagar a venda, eu apago o cliente.
    private Cliente comprador;

    @OneToMany(cascade = CascadeType.ALL) //Cascade faz com que o java propague as alterações que estão acontecendo na classe base para as classes filhas. Nesse caso usasse o ALL pq a venda e os itens "andam juntos".
    @JoinColumn(name = "venda_id") //Quando criamos uma assossiação OneToMany (um para muitos), a variável não pode ser do tipo de uma classe, ela precisa ser uma Interface, no caso da ArrayList, a interface é uma "List" 
    private List<ItemVenda> colItens = new ArrayList<>();
    

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Cliente getComprador() {
        return comprador;
    }
    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }
    public List<ItemVenda> getColItens() {
        return colItens;
    }
    public void setColItens(List<ItemVenda> colItens) {
        this.colItens = colItens;
    }
  
}