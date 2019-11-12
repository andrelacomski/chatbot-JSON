package models;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.objects.NativeArray;
import views.HomeView;

public class Recever extends Thread {

    private final DataInputStream in;
    private final HomeView home;

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
                Gson gson = new Gson();
                switch(protocolo.getAction()){
                    case "listarUsuarios":
                        this.home.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        break;
                    case "listarServicos":
                        this.home.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        break;
                    case "broadcast":
                        this.home.preencherListaChat(protocolo.getMensagem());
                        break;
                }
                
                if (close)
                    break;             
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());

        }
    }
}
