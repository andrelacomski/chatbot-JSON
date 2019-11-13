package models;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import java.util.ArrayList;
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
            this.cliente = new Cliente(clienteSocket.getInetAddress().getHostAddress().toString(), clienteSocket.getPort(), " ", out);
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
                      //  this.cliente.setTipo(protocolo.getTipo());
                        this.login(protocolo, out);
                        break;
                    case "logout":
                        out.close();
                        in.close();
                        clienteSocket.close();
                        this.desconectar(out);
                        close = true;
                        break;
                    case "broadcast":
                        this.broadcast(protocolo, out);
                        break;
                    case "cadastrarServico":
                        protocolo.getServico().setEmpregador(cliente);
                        this.cadastrarServico(protocolo, out);
                        break;
                    case "mensagemDireta":
                        this.mensagemDireta(protocolo, out);
                        break;
                }
                if (close)
                    break;
            }

        } catch (IOException e) {
            System.out.println("[SERVIDOR]: Conexão perdida com o Cliente: " + this.clienteSocket.getLocalAddress().getHostAddress());
        }
    }

    public void login(Protocolo protocolo, DataOutputStream out) throws IOException {
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        ListaServicos ctrlServico = ListaServicos.getInstance();
        Gson gson = new Gson();
        Protocolo envioUsuarios = new Protocolo("listarUsuarios");
        Protocolo envioServicos = new Protocolo("listarServicos");        

        this.cliente.setTipo(null);
        ctrlCliente.setClientes(this.cliente);
        envioUsuarios.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());
        envioServicos.setServicos((ArrayList<Servico>) ctrlServico.getServicos());
        main.preencheListaServicos((ArrayList<Servico>) ctrlServico.getServicos());
        
        for (Cliente client : ctrlCliente.getClientes()){
            client.saidaCliente.writeUTF(gson.toJson(envioUsuarios));
            client.saidaCliente.writeUTF(gson.toJson(envioServicos));
        }
    
        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente));
        System.out.println("[SERVIÇOS]: " + gson.toJson(ctrlServico));
        System.out.println("[SERVIDOR]: Cliente conectado: " + this.cliente.getNome());
    }
    
    public void desconectar(DataOutputStream out) throws IOException{
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarUsuarios");
        
        ctrlCliente.getClientes().remove(this.cliente);
        envio.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());
        
        for (Cliente client : ctrlCliente.getClientes())
            client.saidaCliente.writeUTF(gson.toJson(envio));
        
        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente.getClientes()));
        System.out.println("[SERVIDOR]: Cliente desconectado: " + this.cliente.getNome());
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

    public void cadastrarServico(Protocolo protocolo, DataOutputStream out) throws IOException{
        ListaServicos ctrlServico = ListaServicos.getInstance();
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarServicos");        

        ctrlServico.setServicos(protocolo.getServico());
        envio.setServicos((ArrayList<Servico>) ctrlServico.getServicos());
        main.preencheListaServicos((ArrayList<Servico>) ctrlServico.getServicos());
        
        for (Cliente client : ctrlCliente.getClientes())
            client.saidaCliente.writeUTF(gson.toJson(envio));
    

        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente.getClientes()));
        System.out.println("[SERVIÇOS]: " + gson.toJson(ctrlServico.getServicos()));
        System.out.println("[SERVIDOR]: " + protocolo.getServico().getCargo());
    }
    
    public void mensagemDireta(Protocolo protocolo, DataOutputStream out) throws IOException{
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Protocolo envio = new Protocolo("mensagemDireta");
        Gson gson = new Gson();
        envio.setRemetente(this.cliente);
        envio.setMensagem(protocolo.getMensagem());
    
        for(Cliente client: ctrlCliente.getClientes()){
            if(client.getIp().equals(protocolo.getDestinatario().getIp()) && 
               client.getNome().equals(protocolo.getDestinatario().getNome()) &&
               client.getPorta() == protocolo.getDestinatario().getPorta()){
                client.saidaCliente.writeUTF(gson.toJson(envio));
                break;
            }
        }
        
        System.out.println("MENSAGEM DIRETA RECEBIDA:" + gson.toJson(protocolo));
        System.out.println("MENSAGEM DIRETA ENVIADA:" + gson.toJson(envio));
    }
    
}
