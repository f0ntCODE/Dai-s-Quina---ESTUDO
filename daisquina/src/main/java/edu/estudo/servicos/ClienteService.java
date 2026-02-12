package edu.estudo.servicos;

import java.util.HashMap;
import java.util.Map;

import edu.estudo.dominio.Cliente;
import edu.estudo.excecoes.EntidadeNaoEncontradaException;

public class ClienteService {

    private Map<Integer, Cliente> clienteMap = new HashMap<>();
    private int id = 0;

    public ClienteService(){

    }

    public Cliente criar(Cliente cliente){
        id ++;
        try{
            cliente.setId(id);
            clienteMap.put(id, cliente);
         
            return cliente;
        
        }catch(NullPointerException ex){
            System.out.println("Dado de cliente obteve um erro: " + ex.getMessage());

            throw ex;
        }
    }

    public Cliente editar(int id, Cliente cliente){
        
        try{
            Cliente dadosCliente = findById(id);        
            if(cliente.getEmail() != null) dadosCliente.setEmail(cliente.getEmail());;
            if(cliente.getSenha() != null) dadosCliente.setSenha(cliente.getSenha());;
            if(cliente.getNome() != null) dadosCliente.setNome(cliente.getNome());;

            dadosCliente = clienteMap.replace(id, dadosCliente);        return dadosCliente;

        }catch(EntidadeNaoEncontradaException ex){
            System.out.println("Houve um erro ao encontrar uma entidade: " + ex.getMessage());

            throw ex;
        }

    }

    public void excluir(int id){
        clienteMap.remove(id);

    }


    public Cliente findById(Integer id){

        if(!clienteMap.containsKey(id)) throw new EntidadeNaoEncontradaException("Cliente com id "+ id +" não foi encontrado");

        return clienteMap.get(id);

    }

}
