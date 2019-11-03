package models;

import java.util.ArrayList;
import java.util.List;

public class Protocolo {
    private String action;
    private String nome;
    private String mensagem;
    private List <Cliente> clientes = new ArrayList<>();
    private List <Servico> servicos = new ArrayList<>();

    public Protocolo(String action){
        this.action = action;
    }
    
    public Protocolo(String action, String nome){
        this.action = action;
        this.nome = nome;
    }
       
    public void setAction(String action) {
        this.action = action;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getAction() {
        return action;
    }

    public String getNome() {
        return nome;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public List<Cliente> getClientes(){
        return this.clientes;
    }
    
    public void setClientes(List<Cliente> clientes){
        this.clientes = clientes;
    }

    public List<Servico> getServicos(){
        return this.servicos;
    }
    
    public void setServicos(List<Servico> servicos){
        this.servicos = servicos;
    }

}
