package models;

import java.util.ArrayList;

public class Protocolo {
    private String action;
    private String nome;
    private String mensagem;
    private ArrayList servico;

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
}
