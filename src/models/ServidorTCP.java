package models;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;
import models.Cliente;

/**
 *
 * @author lacomski
 */


public class ServidorTCP extends Thread{

    protected Socket clienteSocket;
    protected Cliente cliente;
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try{
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite a porta: ");
            int porta = entrada.nextInt();
            serverSocket = new ServerSocket(porta);
            System.out.println("Servidor online.");
            try{
                while(true){
                    System.out.println("Aguardando conexão do cliente...");
                    new ServidorTCP(serverSocket.accept()); // aceita conexão
                }
            }
            catch(IOException e){
                System.err.println("Conexão falhou.");
                System.exit(1);
            }
        }
        catch (IOException io){
            System.err.println("Não foi possível abrir a porta: " + serverSocket.getLocalPort());
            System.exit(1);
        }
        finally{
            try{
                serverSocket.close();
            }
            catch(IOException e){
                System.err.println("Não foi possível fechar a porta.");
                System.exit(1);
            }
        }
    }
        
        private ServidorTCP (Socket clienteSocket){
            this.clienteSocket = clienteSocket; // recebe o cliente
            start(); // inicia a thread
        }    
        
        public void run (){
            System.out.println("Nova cliente em Thread Iniciada.");
            try{
                DataOutputStream out = new DataOutputStream(clienteSocket.getOutputStream()); // prepara para enviar os dados
                DataInputStream in = new DataInputStream(this.clienteSocket.getInputStream()); // prepara para receber os dados
               
                String recebe; boolean close = false;
                while((recebe = in.readUTF()) != null){ // ler dados do cliente
                    Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                    switch(protocolo.getAction()){
                        case "login":
                            this.cliente = new Cliente(1, protocolo.getNome(), 
                                                       clienteSocket.getInetAddress().toString(),
                                                        clienteSocket.getPort(), true);
                            System.out.println("Cliente conectado: " + cliente.getNome());
                            
                            out.writeUTF("ok");
                            break;
                        case "logout":
                            out.writeUTF("ok");
                            out.close();
                            in.close();                           
                            clienteSocket.close();
                            cliente.setStatus(false);
                            close = true;
                            break;
                    }
                    if(close)
                        break;
                }
                
            }
            catch (IOException e){
                System.out.println("Erro ao desconectar o Cliente: " + this.clienteSocket.getLocalAddress().getHostAddress());
            }
            System.out.println("Cliente desconectado: " + this.cliente.getNome());
        }            
}
