package com.fabio.eicon.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Double valortotal;
	
	@Column(name="qtd_produto")
	private Integer qtdProduto;
	
	@Column(name="codigo_cliente")
	@OneToMany
	private Set<Cliente> usuario;

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
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Set<Cliente> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Cliente> usuario) {
		this.usuario = usuario;
	}
	
	
}
