package com.fabio.eicon.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.eicon.dto.PedidoDTO;
import com.fabio.eicon.entity.Cliente;
import com.fabio.eicon.entity.Pedido;
import com.fabio.eicon.repository.ClienteRepository;
import com.fabio.eicon.repository.PedidoRepository;

@Service
@Transactional
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public List<Pedido> salvar(List<PedidoDTO> list) throws Exception {
		if (list == null) {
	        return null;
	    }
		
		List<Pedido> result = new ArrayList<>();
		for (PedidoDTO pedido : list) {
			list.remove(null);
			verificaSeExisteControle(pedido);
			verificaData(pedido);
			calculoProduto(pedido);
			Pedido itemPedido = convertDTO(pedido);
			if (pedido != null) {
				result.add(itemPedido);
			}
	    }
		repository.saveAll(result);
		return result;
		
	}

	private Pedido convertDTO(PedidoDTO pedido) {
		Pedido itemPedido = new Pedido();
		itemPedido.setNumeroControle(pedido.getNumeroControle());
		itemPedido.setDtCadastro(pedido.getDtCadastro());
		itemPedido.setNomeProduto(pedido.getNomeProduto());
		itemPedido.setValor(pedido.getValor());
		itemPedido.setValortotal(pedido.getValortotal());
		itemPedido.setQtdProduto(pedido.getQtdProduto());
		Cliente cliente = clienteRepository.findByCodigoCliente(pedido.getCodigoCliente());
		itemPedido.setCliente(cliente);
		return itemPedido;
	}

	private void calculoProduto(PedidoDTO pedido) {
		if (pedido.getQtdProduto() == null) {
			pedido.setQtdProduto(1);
		} else if (pedido.getQtdProduto() > 5 && pedido.getQtdProduto() < 10) {
			double valorTotal = pedido.getValor() * pedido.getQtdProduto(); 
			double valorDesconto = valorTotal * 0.05;
			pedido.setValortotal(valorTotal - valorDesconto);
		} else if (pedido.getQtdProduto() >= 10) {
			double valorTotal = pedido.getValor() * pedido.getQtdProduto(); 
			double valorDesconto = valorTotal * 0.10;
			pedido.setValortotal(valorTotal - valorDesconto);
		} else {
			pedido.setValortotal(pedido.getValor() * pedido.getQtdProduto());
		}
	}

	private void verificaData(PedidoDTO pedido) {
		if(pedido.getDtCadastro() == null) {
			pedido.setDtCadastro(new Date(System.currentTimeMillis()));
		}
	}

	private void verificaSeExisteControle(PedidoDTO pedido) throws Exception {
		List<Pedido> optPedido = repository.findByNumeroControle(pedido.getNumeroControle());
		if(!optPedido.isEmpty()) {
			throw new Exception("Número de pedido já está cadastrado");
		}
	}

}
