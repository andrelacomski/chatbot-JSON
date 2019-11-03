package models;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.ServidorView;

public class ServidorTCP extends Thread {

    protected Socket clienteSocket;
    protected Cliente cliente;
    protected ServidorView main;
    protected DataOutputStream out;
    protected DataInputStream in;
    protected static int qtdClientes;
    protected static int porta;

    public ServidorTCP(Socket socket, ServidorView main){
        this.main = main;
        this.clienteSocket = socket;
        try {
            out = new DataOutputStream(clienteSocket.getOutputStream()); // prepara para enviar os dados
            in = new DataInputStream(this.clienteSocket.getInputStream()); // prepara para receber os dado
            this.cliente = new Cliente(clienteSocket.getInetAddress().toString(), clienteSocket.getPort(), " ", out);
        } catch (IOException e) {
            System.out.println("[SERVIDOR]: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("[SERVIDOR]: Nova cliente iniciado. Aguardando o login...");
        try {
            String recebe;
            boolean close = false;
            while ((recebe = in.readUTF()) != null) { // ler dados do cliente
                Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                switch (protocolo.getAction()) {
                    case "login":
                        this.cliente.setNome(protocolo.getNome());
                        this.login(protocolo, out);
                        break;
                    case "logout":
                        out.close();
                        in.close();
                        clienteSocket.close();
                        close = true;
                        break;
                    case "broadcast":
                        this.broadcast(protocolo, out);
                        break;
                    case "cadastrarServico":
                        this.cadastrarServico(protocolo, out);
                        break;
                }
                if (close)
                    break;
            }

        } catch (IOException e) {
            System.out.println("[SERVIDOR]: Erro ao desconectar o Cliente: " + this.clienteSocket.getLocalAddress().getHostAddress());
        }

        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarUsuarios");
        
        ctrlCliente.getClientes().remove(this.cliente);
        envio.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());
        
        for (Cliente client : ctrlCliente.getClientes()) {
            try {
                client.saidaCliente.writeUTF(gson.toJson(envio));
            } catch (IOException ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente.getClientes()));
        System.out.println("[SERVIDOR]: Cliente desconectado: " + this.cliente.getNome());
    }

    public void login(Protocolo protocolo, DataOutputStream out) throws IOException {
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarUsuarios");
        
        ctrlCliente.setClientes(this.cliente);
        envio.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());
       
        for (Cliente client : ctrlCliente.getClientes())
            client.saidaCliente.writeUTF(gson.toJson(envio));
        
        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente));
        System.out.println("[SERVIDOR]: Cliente conectado: " + this.cliente.getNome());
    }
    
    public void broadcast(Protocolo protocolo, DataOutputStream out) throws IOException{
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Protocolo envio = new Protocolo("broadcast");
        Gson gson = new Gson();
        String mensagem = "[" + cliente.getNome() + "]: " + protocolo.getMensagem();
        
        envio.setMensagem(mensagem);
        main.preencheListaChatGlobal(mensagem);
        
        for (Cliente client : ctrlCliente.getClientes())
            client.saidaCliente.writeUTF(gson.toJson(envio));       
        
        System.out.println("[" + cliente.getNome() + "]: " + protocolo.getMensagem());
    }

    public void cadastrarServico(Protocolo protocolo, DataOutputStream out){
        
    }

}
