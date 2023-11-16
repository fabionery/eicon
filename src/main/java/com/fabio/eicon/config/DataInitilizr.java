package com.fabio.eicon.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fabio.eicon.entity.Cliente;
import com.fabio.eicon.repository.ClienteRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	ClienteRepository repository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		List<Cliente> clientes = repository.findAll();

		if (clientes.isEmpty()) {

			createCliente(1);
			createCliente(2);
			createCliente(3);
			createCliente(4);
			createCliente(5);
			createCliente(6);
			createCliente(7);
			createCliente(8);
			createCliente(9);
			createCliente(10);
			
		}
		
	}
	
	public void createCliente(Integer codigoCliente) {
		
		Cliente cliente = new Cliente();
		cliente.setCodigoCliente(codigoCliente);
		
		repository.save(cliente);
		
	}

}
