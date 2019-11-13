package models;

import java.io.DataOutputStream;

public class Cliente {

    public int porta;
    public String nome;
    public String ip;
    public String tipo;
    public transient DataOutputStream saidaCliente;

    public void setSaidaCliente(DataOutputStream saidaCliente) {
        this.saidaCliente = saidaCliente;
    }

    public Cliente() {
    }

    public Cliente(String ip, int porta, String nome, DataOutputStream saidaCliente) {
        this.ip = ip;
        this.porta = porta;
        this.nome = nome;
        this.saidaCliente = saidaCliente;
    }

    public Cliente(String nome, String ip, int porta, String tipo) {
        this.nome = nome;
        this.ip = ip;
        this.porta = porta;
        this.tipo = tipo;
    }

    public Cliente(String nome, String ip, int porta) {
        this.nome = nome;
        this.ip = ip;
        this.porta = porta;
    }
    
    public String getIp() {
        return this.ip;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPorta() {
        return this.porta;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DataOutputStream getSaidaCliente() {
        return saidaCliente;
    }
}
