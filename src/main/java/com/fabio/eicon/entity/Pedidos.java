package com.fabio.eicon.entity;

import java.util.List;

import javax.validation.Valid;


public class Pedidos {

	@Valid
	private List<Pedido> pedidos;

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
