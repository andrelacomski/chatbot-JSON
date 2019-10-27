package models;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;
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
            System.out.println("[SocketThreadIOException]: " + e.getMessage());
        }
    }
    
    @Override
    public void run() {
        System.out.println("Nova cliente iniciado. Aguardando o login...");
        try {
            String recebe;
            boolean close = false;
            while ((recebe = in.readUTF()) != null) { // ler dados do cliente
                Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                switch (protocolo.getAction()) {
                    case "login":
                        this.login(protocolo, out);
                        break;
                    case "logout":
                        out.close();
                        in.close();
                        clienteSocket.close();
                        cliente.setStatus(false);
                        close = true;
                        break;
                }
                if (close) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao desconectar o Cliente: " + this.clienteSocket.getLocalAddress().getHostAddress());
        }
        System.out.println("Cliente desconectado: " + this.cliente.getNome());

        ListaClientes ctrlCliente = ListaClientes.getInstance();
        ctrlCliente.getClientes().remove(this.cliente);
        Gson gson = new Gson();
        System.out.println(gson.toJson(ctrlCliente.getClientes()));
        for (Cliente client : ctrlCliente.getClientes()) {
            try {
                client.saidaCliente.writeUTF(gson.toJson(ctrlCliente.getClientes()));
            } catch (IOException ex) {
                Logger.getLogger(ServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void login(Protocolo protocolo, DataOutputStream out) throws IOException {
        this.cliente.setNome(protocolo.getNome());
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        ctrlCliente.setClientes(this.cliente);
        qtdClientes = ctrlCliente.qtdClientes();
        Gson gson = new Gson();
        System.out.println(gson.toJson(ctrlCliente.getClientes()));
        for (Cliente client : ctrlCliente.getClientes()) {
            client.saidaCliente.writeUTF(gson.toJson(ctrlCliente.getClientes()));
        }
        System.out.println("Cliente conectado: " + this.cliente.getNome());
    }

}
