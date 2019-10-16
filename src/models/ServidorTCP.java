package models;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorTCP extends Thread {

    protected Socket clienteSocket;
    protected Cliente cliente;
    public static int qtdClientes;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite a porta: ");
            int porta = entrada.nextInt();
            serverSocket = new ServerSocket(porta);
            System.out.println("Servidor online.");
            try {
                while (true) {
                    System.out.println("Aguardando conexão do cliente...");
                    new ServidorTCP(serverSocket.accept()); // aceita conexão
                }
            } catch (IOException e) {
                System.err.println("Conexão falhou.");
                System.exit(1);
            }
        } catch (IOException io) {
            System.err.println("Não foi possível abrir a porta: " + serverSocket.getLocalPort());
            System.exit(1);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.err.println("Não foi possível fechar a porta.");
                System.exit(1);
            }
        }
    }

    private ServidorTCP(Socket clienteSocket) {
        this.clienteSocket = clienteSocket; // recebe o cliente
        start(); // inicia a thread
    }

    public void run() {
        System.out.println("Nova cliente em Thread Iniciada.");
        try {

            DataOutputStream out = new DataOutputStream(clienteSocket.getOutputStream()); // prepara para enviar os dados
            DataInputStream in = new DataInputStream(this.clienteSocket.getInputStream()); // prepara para receber os dados

            this.cliente = new Cliente(clienteSocket.getInetAddress().toString(), clienteSocket.getPort(), " ", out);

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
