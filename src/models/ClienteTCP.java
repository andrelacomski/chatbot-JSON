package models;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import models.Cliente;
import models.Protocolo;

/**
 *
 * @author lacomski
 */

public class ClienteTCP {

    private Cliente cliente;
    private Socket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensagem;

    public ClienteTCP(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public boolean conectar() throws IOException {
        System.out.println("Tentando conexão no host: " + this.cliente.getIp()+ ":" + this.cliente.getPorta());
        try {
            this.serverSocket = new Socket(this.cliente.getIp(), this.cliente.getPorta());
            this.out = new DataOutputStream(this.serverSocket.getOutputStream());
            this.in = new DataInputStream(this.serverSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println("Este host não existe: " + this.cliente.getIp());
            return false;
        } catch (IOException io) {
            System.out.println("Não foi possível obter I/O para o server: " + this.cliente.getIp());
            return false;
        }

        Protocolo protocolo = new Protocolo("login", this.cliente.getNome());
        Gson gson = new Gson();
        out.writeUTF(gson.toJson(protocolo));

        String resposta = this.in.readUTF();
        System.out.println("Resposta do servidor: " + resposta);
        if(resposta.equals("ok"))
            return true;
        else
            return false;
    }

    public boolean desconectar() throws IOException {
        Protocolo protocolo = new Protocolo("logout");
        Gson gson = new Gson();
        out.writeUTF(gson.toJson(protocolo));
        String resposta = this.in.readUTF();
        System.out.println("Resposta do servidor: " + resposta);
        if(resposta.equals("ok")){
            this.out.close();
            this.in.close();
            this.serverSocket.close();
            System.out.println("Desconectado.");
            return true;            
        } else return false;
    }

    public boolean enviarMensagem() throws IOException {
//        System.out.println("Entrada de dados: " + this.getMensagem());
//        Cliente cliente = new Cliente();
//        Gson gson = new Gson();
//         
//        out.writeUTF(gson.toJson(cliente));
//        String retorno = this.getMensagem() + " " + this.in.readUTF();
//        this.setMensagem(retorno);
        return true;
    }

    public static void main(String[] args) throws IOException {
        
    }

}
