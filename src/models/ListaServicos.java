package models;

import java.util.ArrayList;
import java.util.List;

public class ListaServicos {

    private static ListaServicos uniqueInstance;
    private final String action = "listarServicos";
    private final List<Servico> servicos = new ArrayList<>();

    private ListaServicos() {
    }

    public static synchronized ListaServicos getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaServicos();
        }

        return uniqueInstance;
    }

    public List<Servico> getClientes() {
        return this.servicos;
    }

    public void setClientes(Servico servico) {
        this.servicos.add(servico);
    }
}
