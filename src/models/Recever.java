package models;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import views.HomeView;

public class Recever extends Thread {

    DataInputStream in;
    HomeView home;

    public Recever(DataInputStream in, HomeView home) {
        this.in = in;
        this.home = home;
    }

    @Override
    public void run() {
        String recebe;
        boolean close = false;
        try {
            while ((recebe = this.in.readUTF()) != null) { // ler dados do cliente
                
                System.out.println(recebe);
                ListaClientes lista = new Gson().fromJson(recebe, ListaClientes.class);
                home.preencherLista((ArrayList<Cliente>) lista.getClientes());
                        
                if (close) {
                    break;
                }
            }
        } catch (IOException ex) {
//            Logger.getLogger(Recever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
