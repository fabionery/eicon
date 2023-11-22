package com.fabio.eicon.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
	
	public List<Pedido> pesquisar(Integer numeroControle, Date dtCadastro) throws Exception {
		try {
			if (numeroControle == null && dtCadastro == null) {
				return repository.findAll();
			} else if (numeroControle != null && dtCadastro == null) {
				return repository.findByNumeroControle(numeroControle);
			} else if (numeroControle == null && dtCadastro != null) {
				return repository.findByDtCadastro(dtCadastro);
			} else {
				return repository.findByNumeroControleAndDtCadastro(numeroControle, dtCadastro);
			}
		} catch (Exception e) {
			throw new Exception("Erro ao gerar pesquisa!", e); 
		}
	}
	
	@Transactional
	public List<Pedido> salvar(List<PedidoDTO> list) throws Exception {
		Assert.notNull(list, "lista não pode ser null");
		try {
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
		} catch (Exception e) {
			throw new Exception("erro ao salvar pedido!", e);
		}
		
		
	}

	public Pedido convertDTO(PedidoDTO pedido) throws Exception {
		Assert.notNull(pedido, "pedido convert não pode ser null");
		try {
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
		} catch (Exception e) {
			 throw new Exception("erro ao converter objeto!", e);
		}
	}

	public void calculoProduto(PedidoDTO pedido) throws Exception {
		Assert.notNull(pedido, "pedido calculo não pode ser null");
		try {
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
		} catch (Exception e) {
			 throw new Exception("erro ao calcular", e);
		}
	}

	public void verificaData(PedidoDTO pedido) throws Exception {
		Assert.notNull(pedido, "data não pode ser null");
		try {
			if(pedido.getDtCadastro() == null) {
				pedido.setDtCadastro(new Date(System.currentTimeMillis()));
			}
		} catch (Exception e) {
			 throw new Exception("erro ao verificar data", e);
		}
		if(pedido.getDtCadastro() == null) {
			pedido.setDtCadastro(new Date(System.currentTimeMillis()));
		}
	}

	public void verificaSeExisteControle(PedidoDTO pedido) throws Exception {
		List<Pedido> optPedido = repository.findByNumeroControle(pedido.getNumeroControle());
		if(!optPedido.isEmpty()) {
			throw new Exception("Número de pedido já está cadastrado");
		}
	}

}
