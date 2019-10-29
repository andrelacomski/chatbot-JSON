package models;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import views.ServidorView;

/**
 *
 * @author lacomski
 */
public class Servidor implements Runnable{

    protected ServerSocket server;
    protected ServidorView main;
    protected boolean conected = true;

    public Servidor(int porta, ServidorView main){
        System.out.println("[SERVIDOR]: Iniciando SERVIDOR...");
        try {
            this.main = main;
            server = new ServerSocket(porta);
            System.out.println("[SERVIDOR]: SERVIDOR Iniciado!");
        }
        catch (IOException e) {
            System.out.println("[IOException]: "+ e.getMessage());
        }
        catch (Exception e ){
            System.out.println("[Exception]: "+ e.getMessage());
        }
    }

   @Override
    public void run() {
        try {
            while(conected){
                Socket socket = server.accept();
                new Thread(new ServidorTCP(socket, main)).start();
            }
        } catch (IOException e) {
            System.out.println("[ServidorThreadIOException]: "+ e.getMessage());
        }
    }

    public void stop(){
        try {
            server.close();
            conected = false;
            System.out.println("[SERVIDOR]: SERVIDOR está FECHADO....!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
