package edu.estudo.servicos;

import java.util.HashMap;
import java.util.Map;

import edu.estudo.dominio.Cliente;
import edu.estudo.dominio.Pedido;

public class PedidoService {

    private Map<Integer, Pedido> pedidoMap = new HashMap<>();
    private int id;

    public PedidoService(){
        
    }

    public Pedido criar(Cliente cliente){
        if(cliente == null) throw new IllegalArgumentException();

        this.id ++;

        Pedido pedido = new Pedido(id, cliente);

        pedidoMap.put(id, pedido);
        
        return pedido;

    }

    public void excluir(int id){

        Pedido pedido = findById(id);

        pedidoMap.remove(pedido.getId());

    }

    public Pedido findById(int id){
        try{
            return pedidoMap.get(id);

        }catch(NullPointerException ex){
            System.out.println("Pedido de número " + id + " não encontrado");
            
            throw ex;
        }

    }

}
