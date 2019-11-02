package models;

import java.io.DataOutputStream;

public class Cliente {

    public int porta;
    public String nome;
    public String ip;
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

    public Cliente(String nome, String ip, int porta, boolean status) {
        this.nome = nome;
        this.ip = ip;
        this.porta = porta;
//        this.status = status;
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

//    public boolean getStatus() {
//        return this.status;
//    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public DataOutputStream getSaidaCliente() {
        return saidaCliente;
    }
}
