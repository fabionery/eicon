package com.fabio.eicon.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabio.eicon.dto.PedidoDTO;
import com.fabio.eicon.entity.Pedido;

public class PedidoServiceTest {
	
	@Autowired
	private PedidoService service;
	
	private static Date data;
	private static Integer numeroControle;
	
	@Mock
	private static List<PedidoDTO> pedidosDTO;
	
	@Mock
	private static PedidoDTO pedidoDTO;

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
		pedidoDTO = new PedidoDTO(
				1, data, anyString(), anyDouble(), anyDouble(), anyInt(), anyInt()
				);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void naoDevePesquisarPedido() throws Exception {

		try {
			service.pesquisar(numeroControle, data);
			fail();
		} catch (Exception e) {
			assertThat("Erro ao gerar pesquisa!");
		}
	}
	
	@Test
	public void naoDeveSalvar() throws Exception {

		try {
			service.salvar(pedidosDTO);
			fail();
		} catch (Exception e) {
			assertThat("erro ao salvar pedido!");
		}
	}
	
	@Test
	public void naoDeveconverterDTO() throws Exception {

		try {
			service.convertDTO(pedidoDTO);
			fail();
		} catch (Exception e) {
			assertThat("erro ao converter objeto!");
		}
	}
	
	@Test
	public void naoVerificaData() throws Exception {

		try {
			service.verificaData(pedidoDTO);
			fail();
		} catch (Exception e) {
			assertThat("erro ao verificar data");
		}
	}
	
	@Test
	public void naoVerificaSeExisteControle() throws Exception {
		try {
			service.verificaSeExisteControle(pedidoDTO);
		} catch (Exception e) {
			assertThat("Número de pedido já está cadastrado");
		}	
	}
	
	@Test
	public void deveRetornarPesquisa() {
		assertThat(pedidoDTO.getCodigoCliente(), is(0));
	}

}
