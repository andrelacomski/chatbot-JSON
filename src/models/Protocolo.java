package models;

import java.util.List;

public class Protocolo {
    private String action;
    private String nome;
    private String mensagem;
    private Servico servico;
    private List <Cliente> usuarios;
    private List <Servico> servicos;

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

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Servico getServico() {
        return servico;
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
        return this.usuarios;
    }
    
    public void setClientes(List<Cliente> clientes){
        this.usuarios = clientes;
    }

    public List<Servico> getServicos(){
        return this.servicos;
    }
    
    public void setServicos(List<Servico> servicos){
        this.servicos = servicos;
    }
}
