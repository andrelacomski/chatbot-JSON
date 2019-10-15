package models;

import java.util.ArrayList;



public class ListaClientes {
 
    private static ListaClientes uniqueInstance;
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    
    private ListaClientes() {
    }
 
    public static synchronized ListaClientes getInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new ListaClientes();
        }
 
        return uniqueInstance;
    }
    
    public int qtdClientes(){
        return this.clientes.size();
    }
    
    public ArrayList<Cliente> getClientes(){
        return this.clientes;
    }
    public void setClientes(Cliente cliente){
        this.clientes.add(cliente);
    }
}