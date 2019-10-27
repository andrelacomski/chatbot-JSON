package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.DataInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                Type listType = new TypeToken<ArrayList<Cliente>>() {
                }.getType();
                ArrayList<Cliente> lista = new Gson().fromJson(recebe, listType);
                
                home.preencherLista(lista);
                        
                if (close) {
                    break;
                }
            }
        } catch (IOException ex) {
//            Logger.getLogger(Recever.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
