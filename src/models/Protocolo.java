package models;

import java.util.List;

public class Protocolo {

    private String action;
    private String nome;
    private String mensagem;
    private Servico servico;
    private String tipo;
    private Cliente remetente;
    private Cliente destinatario;
    private List<Cliente> usuarios;
    private List<Cliente> interessados;
    private List<Servico> servicos;

    public Protocolo() {
    }

    public Protocolo(String action) {
        this.action = action;
    }

    public Protocolo(String action, String nome, String tipo) {
        this.action = action;
        this.nome = nome;
        this.tipo = tipo;
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

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUsuarios(List<Cliente> usuarios) {
        this.usuarios = usuarios;
    }

    public void setRemetente(Cliente remetente) {
        this.remetente = remetente;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    public void setClientes(List<Cliente> clientes) {
        this.usuarios = clientes;
    }

    public void setInteressados(List<Cliente> interessados) {
        this.interessados = interessados;
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

    public List<Cliente> getClientes() {
        return this.usuarios;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public String getTipo() {
        return tipo;
    }

    public List<Cliente> getUsuarios() {
        return usuarios;
    }

    public Cliente getRemetente() {
        return remetente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public List<Cliente> getInteressados() {
        return interessados;
    }
}
