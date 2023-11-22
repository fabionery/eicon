package com.fabio.eicon.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyInt;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabio.eicon.entity.Pedido;

public class PedidoServiceTest {
	
	@Autowired
	private PedidoService service;
	private static Date data;
	private static Integer numeroControle;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		data = new Date(30);
		numeroControle = 1;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void naoDeveGerarPedido() throws Exception {

		try {
			service.pesquisar(numeroControle, data);
			fail();
		} catch (Exception e) {
			assertThat("Erro ao gerar pesquisa!");
		}
	}

}
