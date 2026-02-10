package edu.estudo.servicos;

import edu.estudo.dominio.Cliente;
import edu.estudo.dominio.Pedido;

public class PedidoService {

    public PedidoService(){
        
    }

    public Pedido criar(Cliente cliente){
        if(cliente == null) throw new IllegalArgumentException();

        Pedido pedido = new Pedido(cliente);
        
        return pedido;

    }

}
