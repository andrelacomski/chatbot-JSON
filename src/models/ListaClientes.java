package models;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {

    private static volatile ListaClientes instance = null;
    private static final Object lock = new Object();
    private final List<Cliente> clientes = new ArrayList<>();

    private ListaClientes() {
    }

    public static synchronized ListaClientes getInstance() {
        ListaClientes r;
        synchronized (lock) {
            r = instance;
            if (r == null) {
                r = new ListaClientes();
                instance = r;
            }
        }
        return r;
    }

    public int qtdClientes() {
        return this.clientes.size();
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);
    }
}
