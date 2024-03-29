package models;

import java.util.ArrayList;
import java.util.List;

public class ListaServicos {
    
    private static ListaServicos uniqueInstance;
    private final List<Servico> servicos = new ArrayList<>();
    
    private ListaServicos() {
    }
    
    public static synchronized ListaServicos getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ListaServicos();
        }
        return uniqueInstance;
    }
    
    public List<Servico> getServicos() {
        return this.servicos;
    }
    
    public void setServicos(Servico servico) {
        this.servicos.add(servico);
    }
    
    public Servico getServico(Servico servico) {
        for (Servico service : this.servicos) {
            if (servico.getCargo().equals(service.getCargo())
                    && servico.getDescricao().equals(service.getDescricao())
                    && servico.getSalario() == service.getSalario()
                    && servico.getEmpregador().getNome().equals(service.getEmpregador().getNome())
                    && servico.getEmpregador().getPorta() == service.getEmpregador().getPorta()) {
                return service;
            }
        }
        return null;
    }
    
}
