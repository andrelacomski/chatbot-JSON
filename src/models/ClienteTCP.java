package models;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import views.HomeView;

public class ClienteTCP extends Thread {

    private Cliente cliente;
    private Socket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensagem;
    private HomeView home;

    public ClienteTCP(Cliente cliente, HomeView home) throws IOException {
        this.cliente = cliente;
        this.home = home;
        //conectar();
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public boolean conectar() throws IOException {
        System.out.println("[CLIENTE]: Tentando conexão no host: " + this.cliente.getIp() + ":" + this.cliente.getPorta());
        try {
            this.serverSocket = new Socket(this.cliente.getIp(), this.cliente.getPorta());

            this.out = new DataOutputStream(this.serverSocket.getOutputStream());
            this.in = new DataInputStream(this.serverSocket.getInputStream());
            new Recever(in, home).start();
            Protocolo protocolo = new Protocolo("login", this.cliente.getNome());
            Gson gson = new Gson();
            out.writeUTF(gson.toJson(protocolo));
            return true;

        } catch (UnknownHostException e) {
            System.out.println("[CLIENTE]: Este host não existe: " + this.cliente.getIp());
            return false;
        } catch (IOException io) {
            System.out.println(io.toString());
            System.out.println("[CLIENTE]: Não foi possível obter I/O para o server: " + this.cliente.getIp());
            return false;
        }
     }

    public boolean desconectar() throws IOException {
        Protocolo protocolo = new Protocolo("logout");
        Gson gson = new Gson();
        out.writeUTF(gson.toJson(protocolo));
        this.out.close();
        this.in.close();
        this.serverSocket.close();
        System.out.println("[CLIENTE]: Desconectado.");
        return true;
    }

    public boolean enviarMensagem() throws IOException {
        System.out.println("[CLIENTE]: Enviando mensagem: " + this.getMensagem());
        Protocolo protocolo = new Protocolo("broadcast");
        protocolo.setMensagem(this.getMensagem());
        Gson gson = new Gson();
        out.writeUTF(gson.toJson(protocolo));
        return true;
    }

    public static void main(String[] args) throws IOException {
    }
}
