package edu.estudo.dominio;

public class Pedido {

    private int id;

    private Cliente cliente;

    private ItensPedido itensPedido;


    public Pedido(int id, Cliente cliente, ItensPedido itensPedido){

        this.cliente = cliente;
        this.itensPedido = itensPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
