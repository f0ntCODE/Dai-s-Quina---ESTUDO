package edu.estudo.dominio;

import java.util.HashSet;
import java.util.Set;

public class ItensPedido {
    private int id;

    private Set<Mercadoria> mercadorias = new HashSet<>();


    public ItensPedido(int id, Set<Mercadoria> mercadorias) {
        this.id = id;
        this.mercadorias = mercadorias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(Set<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }

}
