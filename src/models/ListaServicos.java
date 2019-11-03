package models;

import java.util.ArrayList;
import java.util.List;

public class ListaServicos {

    private static ListaServicos uniqueInstance;
    private final List<Servico> servicos = new ArrayList<>();

    private ListaServicos() {
    }

    public static synchronized ListaServicos getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new ListaServicos();
        return uniqueInstance;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public void setServicos(Servico servico) {
        this.servicos.add(servico);
    }
}
