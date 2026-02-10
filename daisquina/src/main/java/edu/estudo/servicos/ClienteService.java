package edu.estudo.servicos;

import java.util.HashMap;
import java.util.Map;

import edu.estudo.dominio.Cliente;
import edu.estudo.excecoes.EntidadeNaoEncontradaException;

public class ClienteService {

    private Map<Integer, Cliente> clienteMap = new HashMap<>();
    private Integer id;

    public ClienteService(){
        this.id = 0;

    }

    public Cliente criar(Cliente cliente){
        id++;

        clienteMap.put(id, cliente);

        Cliente novoCliente = new Cliente(cliente.getNome(),
         cliente.getEmail(), cliente.getSenha());

        return novoCliente;
    }


    public Cliente findById(Integer id){

        if(!clienteMap.containsKey(id)) throw new EntidadeNaoEncontradaException("Cliente com id "+ id +" não foi encontrado");

        return clienteMap.get(id);

    }


}
