package edu.estudo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.estudo.dominio.Cliente;
import edu.estudo.dominio.Pedido;
import edu.estudo.servicos.PedidoService;

public class AppTest {

    private PedidoService pedidoService;

    public AppTest(){
        this.pedidoService = new PedidoService();
    }
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void deveCriarUmPedido(){

        PedidoService pedidoService = new PedidoService();
        Cliente cliente = new Cliente("Afonso", "Afonso@gmail.com", "12345");

        Pedido pedidoCriado = pedidoService.criar(cliente);

        assertEquals("Afonso", pedidoCriado.getCliente().getNome());
    }

    @Test
    public void clienteNaoPodeSerNuloParaCriarPedido(){
        Cliente cliente = null;

        assertThrows(IllegalArgumentException.class, 
            () -> pedidoService.criar(cliente)
        ); 
    }
    
}
