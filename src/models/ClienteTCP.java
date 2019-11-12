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
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
            Protocolo protocolo = new Protocolo("login", this.cliente.getNome(), this.cliente.getTipo());
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
        try{
            Protocolo protocolo = new Protocolo("logout");
            Gson gson = new Gson();
            out.writeUTF(gson.toJson(protocolo));
            this.out.close();
            this.in.close();
            this.serverSocket.close();            
        } catch(IOException ex){
            System.out.println("[CLIENTE]: Problema para desconectar. " + ex.getMessage());
        }
        System.out.println("[CLIENTE]: Desconectado.");
        return true;
    }

    public boolean enviarMensagem() throws IOException {
        try{
            System.out.println("[CLIENTE]: Enviando mensagem: " + this.getMensagem());
            Protocolo protocolo = new Protocolo("broadcast");
            protocolo.setMensagem(this.getMensagem());
            Gson gson = new Gson();
            out.writeUTF(gson.toJson(protocolo));
        } catch(IOException ex){
            System.out.println("[CLIENTE]: Problema ao enviar mensagem. " + ex.getMessage());
        }
        return true;
    }

    public boolean cadastrarServico(Servico servico) throws IOException{
        try{
            System.out.println("[CLIENTE]: Cadastrando serviço: " + servico.getCargo());
            Protocolo protocolo = new Protocolo("cadastrarServico");
            protocolo.setServico(servico);
            Gson gson = new Gson();
            out.writeUTF(gson.toJson(protocolo));            
        } catch(IOException ex){
            System.out.println("[CLIENTE]: Problema para cadastrar serviço. " + ex.getMessage());
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
    }
}
