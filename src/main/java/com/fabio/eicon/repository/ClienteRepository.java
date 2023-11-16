package com.fabio.eicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabio.eicon.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
