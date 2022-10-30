package br.univille.novostalentos.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;


//@Entity, @Id, e @GeneratedValue(Strategy = GenerationType.IDENTITY)
// Criam automaticamente a tabela, a Primary Key, e os campos do nosso BD.
@Entity//Nome da tabela
public class Cliente {
    @Id//Seta como a chave primary
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera automaticamente os campos da tabela no BD.
    private long id;
    @Column(length = 1000, nullable = false)//Aqui configura o tamanho do campo e aviso que ele não pode ser vaziu
    @NotBlank(message = "Campo nome não pode ser em branco") //Ele não permite que o campo seja em branco, inclusive inserindo uma mensagem
    private String nome;
    @Column(length = 3000)
    private String endereco;
    @Pattern(regexp = "Masculino|Feminino", flags = Pattern.Flag.CANON_EQ, message = "Valor inválido, utilize Masculino ou Feminino")  //Ele permite que você use uma linguagem chamada expressões de usuários para escrever uma regra
    private String sexo;
    @Temporal(value = TemporalType.DATE)//aqui eu especifico, que quero somente a data, excluindo horas e minutos. Isso pq o DATE, cria uma TIMESTAMP, que é um tipo de arquivo que cria pontos temporais (minutos, horas, dia, mês e ano).
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date dataNascimento;
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}) //Cascade = me deixa configurar o que vai acontecer com a classe assossiativa se acontecer alguma cisa com a classe principal. CascadeType.All faz com que tudo que eu fizer com o produto vai ser replicado na cidade, inclusive incluir elementos e excluir elementos. Porém essa anotação evita que isso aconteça.
    private Cidade cidadeResidencia;//Inicialmente da um erro ao inserir um objeto (cidade) em uma classe com a notação @Entity, já que essa notação envia os dados para o BD, porém o BD não sabe como gravar essa informação
                                    //Para resolver eu devo inserir uma ForeignKey, ensinando com a multiplicidade e navegabilidade dessa app, através da notação @ManyToOne
    public Cidade getCidadeResidencia() {
        return cidadeResidencia;
    }
    public void setCidadeResidencia(Cidade cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }
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
