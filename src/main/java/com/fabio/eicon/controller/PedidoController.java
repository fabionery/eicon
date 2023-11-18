package com.fabio.eicon.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fabio.eicon.dto.PedidoDTO;
import com.fabio.eicon.dto.PedidosDTO;
import com.fabio.eicon.entity.Pedido;
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
	public ResponseEntity<List<Pedido>> getPedido(
			@RequestParam(value = "numeroControle", required = false, defaultValue = "")Integer numeroControle,
			@RequestParam(value = "dtCadastro", required = false, defaultValue = "")Date dtCadastro) throws Exception {
		
		List<Pedido> result = service.pesquisar(numeroControle, dtCadastro);
		
		return new ResponseEntity<List<Pedido>>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "pesquisa")
	public List<Pedido> getPedidoTodos() {
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	@ResponseBody
	@ApiOperation(value="salvar")
	public ResponseEntity<List<PedidoDTO>> salvarPedido(@RequestBody PedidosDTO pedidos) throws Exception {
		
		service.salvar(pedidos.getPedidos());
		
		return new ResponseEntity<List<PedidoDTO>>(pedidos.getPedidos(), HttpStatus.OK); 
	}
	
}
