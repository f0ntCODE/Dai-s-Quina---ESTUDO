package edu.estudo.cliente_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import edu.estudo.dominio.Cliente;
import edu.estudo.excecoes.EntidadeNaoEncontradaException;
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

        clienteService.criar(cliente);

        assertEquals("Afonso", clienteService.findById(1).getNome());

    }

    @Test
    public void dadoClienteDeveSerEditado(){
        Cliente cliente = dadosCliente();
        Cliente clienteCriado = clienteService.criar(cliente);

        Cliente novosDadosCliente = dadosCliente();
        novosDadosCliente.setNome("Odair");

        Cliente clienteAtualizado = clienteService.editar(clienteCriado.getId(), novosDadosCliente);

        assertEquals("Odair", clienteAtualizado.getNome());

    }

    @Test
    public void clienteNaoPodeSerNulo(){
        Cliente cliente = null;

        assertThrows(NullPointerException.class, 

            () -> {
                clienteService.criar(cliente);
            });

    }

    @Test
    public void clienteDeveSerExcluido(){
        Cliente cliente = dadosCliente();
        Cliente clienteCriado = clienteService.criar(cliente);

        clienteService.excluir(clienteCriado.getId());

        assertThrows(EntidadeNaoEncontradaException.class,
            () -> {
                clienteService.findById(clienteCriado.getId());
            });

    }

    //helper
    private Cliente dadosCliente(){
        Cliente cliente = new Cliente("Afonso", "af@gmail.com", "123456a");

        return cliente;
    }

}
