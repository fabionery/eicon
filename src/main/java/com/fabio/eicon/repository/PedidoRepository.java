package com.fabio.eicon.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.eicon.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByNumeroControleAndDtCadastro(Integer numeroControle, Date dtCadastro);
	
	List<Pedido> findByNumeroControle(Integer numeroControle);

	List<Pedido> findByNumeroControleAndDtCadastro(Optional<Integer> numeroPedido, Optional<Date> dtCadastro);

	List<Pedido> findByDtCadastro(Date dtCadastro);

}
