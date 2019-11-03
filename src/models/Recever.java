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
                Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                switch(protocolo.getAction()){
                    case "listarUsuarios":
                        home.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        break;
                    case "listarServicos":
                        home.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        break;
                    case "broadcast":
                        home.preencherListaChat(protocolo.getMensagem());
                        break;
                }
                
                if (close)
                    break;             
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
