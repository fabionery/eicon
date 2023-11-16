package com.fabio.eicon.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.eicon.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Optional<Pedido> findByNumeroControleAndDtCadastro(Integer numeroControle, Date dtCadastro);
	
	Optional<Pedido> findByNumeroControle(Integer numeroControle);
}
