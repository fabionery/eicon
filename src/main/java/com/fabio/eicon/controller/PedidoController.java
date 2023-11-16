package com.fabio.eicon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.eicon.entity.Pedido;
import com.fabio.eicon.entity.Pedidos;
import com.fabio.eicon.repository.PedidoRepository;
import com.fabio.eicon.service.PedidoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public List<Pedido> getPedido() {
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	@ApiOperation(value="salvar com json")
	public List<Pedido> salvarPedido(@RequestBody Pedidos pedidos) throws Exception {
		return service.salvar(pedidos.getPedidos());
	}
	
}
