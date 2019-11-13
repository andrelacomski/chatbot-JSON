package models;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import views.ChatDiretoView;
import views.EmpregadoView;
import views.EmpregadorView;

public class Recever extends Thread {

    private final DataInputStream in;
    private EmpregadorView empregador;
    private EmpregadoView empregado;
    private String tipo;
    private ChatDiretoView chat;

    public Recever(DataInputStream in, EmpregadorView home) {
        this.in = in;
        this.empregador = home;
        this.tipo = "empregador";
    }

    public Recever(DataInputStream in, EmpregadoView home) {
        this.in = in;
        this.empregado = home;
        this.tipo = "empregado";
    }
    
    
    public void setChatDiretoView(ChatDiretoView chat){
        this.chat = chat;
    }
    
    public ChatDiretoView getChatDiretoView(){
        return this.chat;
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
                        if(this.tipo.equals("empregado"))
                            this.empregado.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        else
                            this.empregador.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        break;
                    case "listarServicos":
                        if(this.tipo.equals("empregado"))
                            this.empregado.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        else
                            this.empregador.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        break;
                    case "broadcast":
                        if(this.tipo.equals("empregado"))
                            this.empregado.preencherListaChat(protocolo.getMensagem());
                        else
                            this.empregador.preencherListaChat(protocolo.getMensagem());
                        break;
                    case "mensagemDireta":
                        if(this.tipo.equals("empregado"))
                            System.out.println("MENSAGEM DIRETA RECEBIDA: " + recebe);
                        else
                            System.out.println("MENSAGEM DIRETA RECEBIDA: " + recebe);
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
