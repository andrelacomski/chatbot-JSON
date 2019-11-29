package models;

import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import views.ChatDiretoView;
import views.EmpregadoView;
import views.EmpregadorView;

public class ClienteTCP extends Thread {

    private Cliente cliente;
    private Socket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensagem;
    private EmpregadorView empregador;
    private EmpregadoView empregado;
    private ChatDiretoView chatDireto;
    private Recever recever;
    
    public ClienteTCP(Cliente cliente, EmpregadorView home) throws IOException {
        this.cliente = cliente;
        this.empregador = home;
    }

    public ClienteTCP(Cliente cliente, EmpregadoView home) throws IOException {
        this.cliente = cliente;
        this.empregado = home;
    }
    
    public void setChat(ChatDiretoView chatDireto){
        this.chatDireto = chatDireto;
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
            if(this.cliente.getTipo().equals("empregado"))
               this.recever = new Recever(in, empregado);
            else 
                this.recever = new Recever(in, empregador);
            this.recever.start();
            
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
            this.recever.setClose();
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
    
    public boolean mensagemDireta(Protocolo protocolo) throws IOException{
        Gson gson = new Gson();
        System.out.println("[ENVIANDO MENSAGEM]: " + gson.toJson(protocolo));
        out.writeUTF(gson.toJson(protocolo));
        return true;
    }
    
    public static void main(String[] args) throws IOException {
    }
}
