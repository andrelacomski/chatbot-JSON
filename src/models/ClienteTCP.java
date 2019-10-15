package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.List;
import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *
 * @author lacomski
 */

public class ClienteTCP {

    private Cliente cliente;
    private Socket serverSocket;
    private DataOutputStream out;
    private DataInputStream in;
    private String mensagem;

    public ClienteTCP(Cliente cliente) throws IOException {
        this.cliente = cliente;
        conectar();
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    /**
     *
     * @throws IOException
     */
    public boolean conectar() throws IOException {
        System.out.println("Tentando conexão no host: " + this.cliente.getIp()+ ":" + this.cliente.getPorta());
        try {
            this.serverSocket = new Socket(this.cliente.getIp(), this.cliente.getPorta());
            
            this.out = new DataOutputStream(this.serverSocket.getOutputStream());
            this.in = new DataInputStream(this.serverSocket.getInputStream());

            String recebe ;
            boolean close = false;
            
            Protocolo protocolo = new Protocolo("login", this.cliente.getNome());
            Gson gson = new Gson();
            out.writeUTF(gson.toJson(protocolo));
            
            while ((recebe = in.readUTF()) != null) { // ler dados do cliente
//                Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
//                List<Cliente> yourClassList = new Gson().fromJson(recebe, listType);
                //List clientes = new Gson().frosmJson(recebe, List<Cliente>);
                
                
                
                System.out.println(recebe);
                Type listType = new TypeToken<ArrayList<Cliente>>(){}.getType();
                ArrayList<Cliente> lista = new Gson().fromJson(recebe, listType);
                
//                Cliente[] cliente = new Gson().fromJson(recebe, Cliente[].class);
//                ArrayList<Cliente> lista = new ArrayList<>(Arrays.asList(cliente));
                
//                System.out.println(lista);
                for(Cliente c: lista){
                    System.out.println(c.getNome());
                }
                
                if (close) {
                    break;
                }
            }
            
        } catch (UnknownHostException e) {
            System.out.println("Este host não existe: " + this.cliente.getIp());
            return false;
        } catch (IOException io) {
            System.out.println(io.toString());
            System.out.println("Não foi possível obter I/O para o server: " + this.cliente.getIp());
            return false;
        }

        String resposta = this.in.readUTF();
        System.out.println("Resposta do servidor: " + resposta);
        return resposta.equals("ok");
    }

    public boolean desconectar() throws IOException {
        Protocolo protocolo = new Protocolo("logout");
        Gson gson = new Gson();
        out.writeUTF(gson.toJson(protocolo));
        String resposta = this.in.readUTF();
        System.out.println("Resposta do servidor: " + resposta);
        if(resposta.equals("ok")){
            this.out.close();
            this.in.close();
            this.serverSocket.close();
            System.out.println("Desconectado.");
            return true;            
        } else return false;
    }

    public boolean enviarMensagem() throws IOException {
        System.out.println("Entrada de dados: " + this.getMensagem());
        Cliente cliente = new Cliente("",20000,"", null);
        Gson gson = new Gson();
         
        out.writeUTF(gson.toJson(cliente));
        String retorno = this.getMensagem() + " " + this.in.readUTF();
        this.setMensagem(retorno);
        return true;
    }

    public static void main(String[] args) throws IOException {
    }
}
