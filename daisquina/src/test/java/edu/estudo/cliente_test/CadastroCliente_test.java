package edu.estudo.cliente_test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estudo.dominio.Cliente;
import edu.estudo.servicos.ClienteService;

public class CadastroCliente_test {

    private ClienteService clienteService;

    public CadastroCliente_test(){
        this.clienteService = new ClienteService();
    }

    @Test
    public void clienteDeveSerCriado(){
        Cliente cliente = dadosCliente();
        Cliente clienteCriar = clienteService.criar(cliente);

        assertEquals("Afonso", clienteCriar.getNome());

    }

    @Test
    public void clienteDeveSerEncontrado(){
        Cliente cliente = dadosCliente();

        Cliente clienteCriado = clienteService.criar(cliente);

        assertEquals("Afonso", clienteService.findById(1).getNome());

    }

    //helper
    private Cliente dadosCliente(){
        Cliente cliente = new Cliente("Afonso", "af@gmail.com", "123456a");

        return cliente;
    }

}
