package com.fabio.eicon.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fabio.eicon.entity.Pedido;
import com.fabio.eicon.entity.Pedidos;
import com.fabio.eicon.repository.PedidoRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class PedidoService {
	
	private PedidoRepository repository;
	
	@Transactional
	public List<Pedido> salvar(List<Pedido> pedidos) throws Exception {
		if (pedidos == null) {
	        return pedidos;
	    }
		
		for (Pedido pedido : pedidos) {
			Optional<Pedido> optPedido = repository.findByNumeroControle(pedido.getNumeroControle());
			if(optPedido.isPresent()) {
				throw new Exception("Número de pedido já está cadastrado");
			}
			if(pedido.getDtCadastro() == null) {
				pedido.setDtCadastro(new Date(System.currentTimeMillis()));
			}
			if (pedido.getQtdProduto() == null) {
				pedido.setQtdProduto(1);
			} else if (pedido.getQtdProduto() > 5 && pedido.getQtdProduto() < 10) {
				double valorTotal = pedido.getValor() * pedido.getQtdProduto(); 
				double valorDesconto = valorTotal * 0.05;
				pedido.setValortotal(valorTotal - valorDesconto);
			} else if (pedido.getQtdProduto() > 10) {
				double valorTotal = pedido.getValor() * pedido.getQtdProduto(); 
				double valorDesconto = valorTotal * 0.10;
				pedido.setValortotal(valorTotal - valorDesconto);
			}
	        repository.save(pedido);
	    }
		return pedidos;
		
	}

}
