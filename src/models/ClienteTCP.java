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

    private String serverHost;
    private int port;
    private Socket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensagem;

    public ClienteTCP(String servidor, int porta) {
        this.serverHost = servidor;
        this.port = porta;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public String getServerHost() {
        return this.serverHost;
    }

    public int getPort() {
        return this.port;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public boolean conectar() throws IOException {
        System.out.println("Tentando conexão no host: " + this.getServerHost() + ":" + this.getPort());
        try {
            this.serverSocket = new Socket(this.getServerHost(), this.getPort());
            this.out = new DataOutputStream(this.serverSocket.getOutputStream());
            this.in = new DataInputStream(this.serverSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println("Este host não existe: " + this.serverHost);
            return false;
        } catch (IOException io) {
            System.out.println("Não foi possível obter I/O para o server: " + this.serverHost);
            return false;
        }

        Protocolo protocolo = new Protocolo("login", "Cliente");
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
        this.out.close();
        this.in.close();
        this.serverSocket.close();
        System.out.println("DESCONECTADO!");
        return true;
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
