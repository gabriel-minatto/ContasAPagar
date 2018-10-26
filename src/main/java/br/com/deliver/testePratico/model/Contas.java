package br.com.deliver.testePratico.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Contas {

    @Id
    @Column
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private Double valor;

    @Column
    private Double valorCorrigido;

    @Column
    private Date dataVencimento;

    @Column
    private Date dataPagamento;

    @Column
    private Integer diasAtraso;

    public Contas() {

    }

    public Contas(String nome, Double valor, Double valorCorrigido, Date dataVencimento, Date dataPagamento, Integer diasAtraso) {
        this.nome = nome;
        this.valor = valor;
        this.valorCorrigido = valorCorrigido;
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
        this.diasAtraso = diasAtraso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Double getValorCorrigido() {
        return valorCorrigido;
    }

    public void setValorCorrigido(Double valorCorrigido) {
        this.valorCorrigido = valorCorrigido;
    }

    public Integer getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(Integer diasAtraso) {
        this.diasAtraso = diasAtraso;
    }
}
