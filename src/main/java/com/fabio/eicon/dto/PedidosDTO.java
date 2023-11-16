package com.fabio.eicon.dto;

import java.io.Serializable;
import java.util.List;

public class PedidosDTO implements Serializable{
	
	private static final long serialVersionUID = 850738398554290872L;
	
	private List<PedidoDTO> pedidos;

	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	
}
