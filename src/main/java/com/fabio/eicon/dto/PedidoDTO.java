package com.fabio.eicon.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fabio.eicon.entity.Pedido;
import com.fasterxml.jackson.annotation.JsonFormat;


public class PedidoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer numeroControle;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dtCadastro;

	private String nomeProduto;
	
	private Double valor;
	
	private Double valortotal;
	
	private Integer qtdProduto;
	
	private Integer codigoCliente;

	public void pedidoDTO(Pedido pedido) {
		this.numeroControle = pedido.getNumeroControle();
	    this.dtCadastro = pedido.getDtCadastro();
	    this.nomeProduto = pedido.getNomeProduto();
	    this.valor = pedido.getValor();
	    this.valortotal = pedido.getValortotal();
	    this.qtdProduto = pedido.getQtdProduto();
	    this.codigoCliente = pedido.getCliente().getCodigoCliente();
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

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	
}
