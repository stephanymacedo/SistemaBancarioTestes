package negocio;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GerenciadoraClientesTest_Ex4 {

	private GerenciadoraClientes gerClientes;

	/*Teste básico da pesquisa de um cliente a partir do seu ID*/
	@Test
	public void testPesquisaCliente() {

		/*Montagem do cenário*/
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Stephany Macedo", 22, "stephanymacedo@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Heitor Macedo", 02, "heitormacedo@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/*Execução*/
		Cliente cliente = gerClientes.pesquisaCliente(1);
		
		/*Verificações*/
		assertThat(cliente.getId(), is(1));
		
	}
	
	/*Teste básico da remoção de um cliente a partir do seu ID*/
	@Test
	public void testRemoveCliente() {

		/*Montagem do cenário */
		
		// criando alguns clientes
		Cliente cliente01 = new Cliente(1, "Stephany Macedo", 22, "stephanymacedo@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(2, "Heitor Macedo", 02, "heitormacedo@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/*Execução*/
		boolean clienteRemovido = gerClientes.removeCliente(2);
		
		/* Verificações*/
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(2));
		
	}
	
}

