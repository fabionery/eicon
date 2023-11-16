package com.fabio.eicon.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="numero_controle")
	private Integer numeroControle;
	
	@Column(name="dt_cadastro")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dtCadastro;

	@Column(name="nome_produto")
	private String nomeProduto;
	
	@Column(name="valor_unidade")
	private Double valor;
	
	@Column(name="valor_total")
	private Double valorTotal;
	
	@Column(name="qtd_produto")
	private Integer qtdProduto;
	
	@JoinColumn(name="codigo_cliente_pedido")
	@JsonProperty("codigoClientePedido")
    @ManyToOne(cascade=CascadeType.PERSIST)
	private Cliente cliente;

//	public Pedido(
//			Integer numeroControle,
//			Date dtCadastro,
//			String nomeProduto,
//			Double valor,
//			Double valorTotal,
//			Integer qtdProduto,
//			Cliente cliente) {
//        this.numeroControle = numeroControle;
//        this.dtCadastro = dtCadastro;
//        this.nomeProduto = nomeProduto;
//        this.valor = valor;
//        this.valorTotal = valorTotal;
//        this.qtdProduto = qtdProduto;
//        this.cliente = cliente;
//    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroControle() {
		return numeroControle;
	}

	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValortotal() {
		return valorTotal;
	}

	public void setValortotal(Double valortotal) {
		this.valorTotal = valortotal;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
