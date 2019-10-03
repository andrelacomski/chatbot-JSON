package servidortcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import com.google.gson.Gson;
import servidortcp.models.Cliente;

/**
 *
 * @author lacomski
 */


public class ServidorTCP extends Thread{

    protected Socket clienteSocket;
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try{
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite a porta: ");
            int porta = entrada.nextInt();
            serverSocket = new ServerSocket(porta);
            System.out.println("Conexão estabelicida!");
            try{
                while(true){
                    System.out.println("Aguardando conexão...");
                    new ServidorTCP(serverSocket.accept()); // aceita conexão
                }
            }
            catch(IOException e){
                System.err.println("Conexão falhou.");
                System.exit(1);
            }
        }
        catch (IOException io){
            System.err.println("Não foi possível abrir a porta: 8080");
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
            System.out.println("Nova comunicação em Thread Iniciada!");
            try{
                DataOutputStream out = new DataOutputStream(clienteSocket.getOutputStream()); // prepara para enviar os dados
                DataInputStream in = new DataInputStream(this.clienteSocket.getInputStream());
               
                String recebe;
                while((recebe = in.readUTF()) != null){ // ler dados do cliente
                    Cliente inputLine = new Gson().fromJson(recebe, Cliente.class);
                    selecionadorTarefas(inputLine);
                    out.writeUTF("");
                }
                out.close();
                in.close();
                clienteSocket.close();
            }
            catch (IOException e){
                System.out.println("Cliente desconectado: " + this.clienteSocket.getLocalAddress().getHostAddress());
            }
        }            
        
        public void selecionadorTarefas(Cliente cliente){
            
        }
}
