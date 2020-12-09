package rangonaweb.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;
import rangonaweb.entity.Cliente;
import rangonaweb.entity.Endereco;
import rangonaweb.entity.Pedido;
import rangonaweb.enumerations.MenuBebidas;
import rangonaweb.enumerations.MenuQuentinha;

public class ProdutoTestJunit {
	@Test
	public void testeRecibo(){

		Endereco endereco = new Endereco("Dom Jos� Gaspar","34004-600", "Belo Horizonte", "Cora��o Eucar�stico", "Minas Gerais", "115");
		Cliente cliente = new Cliente("441.397.580-40","Pietro",endereco);
		Pedido pedidoAtual = new Pedido(cliente , MenuQuentinha.PRATO_EXECUTIVO, MenuBebidas.CERVEJA, LocalDateTime.now(), 2);
		
		Pedido pedidoEsperado = new Pedido(cliente , MenuQuentinha.PRATO_EXECUTIVO, MenuBebidas.CERVEJA, LocalDateTime.now(), 2);
		pedidoEsperado.setQuantidade(2);

		assertEquals(pedidoEsperado.toString(), pedidoAtual.toString());   // testa o recibo dos pedidos e verifica se est� correto
	}
	
	@Test
	public void testeClienteNaoNulo(){

		Endereco endereco = new Endereco("Dom Jos� Gaspar","34004-600", "Belo Horizonte", "Cora��o Eucar�stico", "Minas Gerais", "115");
		Cliente cliente = new Cliente("441.397.580-40","Pietro",endereco);
		Pedido pedidoAtual = new Pedido(cliente , MenuQuentinha.PRATO_EXECUTIVO, MenuBebidas.CERVEJA, LocalDateTime.now(), 2);

		assertNotNull(pedidoAtual.getCliente());
	}
	
	@Test
	public void testQuantidade(){
		
		Endereco endereco = new Endereco("Dom Jos� Gaspar","34004-600", "Belo Horizonte", "Cora��o Eucar�stico", "Minas Gerais", "115");
		Cliente cliente = new Cliente("441.397.580-40","Pietro",endereco);
		Pedido pedidoAtual = new Pedido(cliente , MenuQuentinha.PRATO_EXECUTIVO, MenuBebidas.CERVEJA, LocalDateTime.now(), 2);

		assertEquals(2,pedidoAtual.getQuantidade());
	
	}
	
	@Test
	public void testPedidoNaoNulo(){
		
		Endereco endereco = new Endereco("Dom Jos� Gaspar","34004-600", "Belo Horizonte", "Cora��o Eucar�stico", "Minas Gerais", "115");
		Cliente cliente = new Cliente("441.397.580-40","Pietro",endereco);
		Pedido pedidoAtual = new Pedido(cliente , MenuQuentinha.PRATO_EXECUTIVO, MenuBebidas.CERVEJA, LocalDateTime.now(), 2);
		
		assertNotNull(pedidoAtual);
	}
}
