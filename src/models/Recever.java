package models;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import views.ChatDiretoView;
import views.EmpregadoView;
import views.EmpregadorView;

public class Recever extends Thread {

    private final DataInputStream in;
    private EmpregadorView empregador;
    private EmpregadoView empregado;
    private String tipo;
    private ArrayList<Protocolo> interessados;
    private boolean close;

    public void setClose() {
        this.close = true;
    }

    public Recever(DataInputStream in, EmpregadorView home) {
        this.in = in;
        this.empregador = home;
        this.tipo = "empregador";
        this.interessados = new ArrayList();
    }

    public Recever(DataInputStream in, EmpregadoView home) {
        this.in = in;
        this.empregado = home;
        this.tipo = "empregado";
    }

    @Override
    public void run() {
        String recebe;
        this.close = false;
        try {
            while ((recebe = this.in.readUTF()) != null && !this.close) { // ler dados do cliente
                System.out.println(recebe);
                Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                switch (protocolo.getAction()) {
                    case "listarUsuarios":
                        if (this.tipo.equals("empregado")) {
                            this.empregado.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        } else {
                            this.empregador.preencherListaOnline((ArrayList<Cliente>) protocolo.getClientes());
                        }
                        break;
                    case "listarServicos":
                        if (this.tipo.equals("empregado")) {
                            this.empregado.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        } else {
                            this.empregador.preencherListaServicos((ArrayList<Servico>) protocolo.getServicos());
                        }
                        break;
                    case "broadcast":
                        if (this.tipo.equals("empregado")) {
                            this.empregado.preencherListaChat(protocolo.getMensagem());
                        } else {
                            this.empregador.preencherListaChat(protocolo.getMensagem());
                        }
                        break;

                    case "contratacao":
                        this.empregado.contratado(protocolo.getServico());
                        break;
                    case "listarInteressados":
                        this.interessados.add(protocolo);
                        this.empregador.preencherListaInteressados(this.interessados);
                        break;
                    case "mensagemDireta":
                        protocolo.setMensagem(protocolo.getRemetente().getNome() + ": " + protocolo.getMensagem());
                        if (this.tipo.equals("empregado")) {
                            ArrayList<ChatDiretoView> auxiliar = this.empregado.getChat();
                            boolean achou = false;
                            for (ChatDiretoView chats : auxiliar) {
                                if (chats.getCliente().getIp().equals(protocolo.getRemetente().getIp())
                                        && chats.getCliente().getPorta() == protocolo.getRemetente().getPorta()
                                        && chats.getCliente().getNome().equals(protocolo.getRemetente().getNome())) {
                                    chats.preencheMensagem(protocolo.getMensagem());
                                    achou = true;
                                    break;
                                }
                            }
                            if (!achou) {
                                Cliente clienteDireto = new Cliente(protocolo.getRemetente().getNome(),
                                        protocolo.getRemetente().getIp(),
                                        protocolo.getRemetente().getPorta());

                                ChatDiretoView chatDireto = new ChatDiretoView(this.empregado.getClienteTCP(), clienteDireto);
                                auxiliar.add(chatDireto);
                                chatDireto.setVisible(true);
                                chatDireto.preencheMensagem(protocolo.getMensagem());
                            }
                        } else {
                            ArrayList<ChatDiretoView> auxiliar = this.empregador.getChat();
                            boolean achou = false;
                            for (ChatDiretoView chats : auxiliar) {
                                if (chats.getCliente().getIp().equals(protocolo.getRemetente().getIp())
                                        && chats.getCliente().getPorta() == protocolo.getRemetente().getPorta()
                                        && chats.getCliente().getNome().equals(protocolo.getRemetente().getNome())) {
                                    chats.preencheMensagem(protocolo.getMensagem());
                                    achou = true;
                                    break;
                                }
                            }
                            if (!achou) {
                                Cliente clienteDireto = new Cliente(protocolo.getRemetente().getNome(),
                                        protocolo.getRemetente().getIp(),
                                        protocolo.getRemetente().getPorta());

                                ChatDiretoView chatDireto = new ChatDiretoView(this.empregador.getClienteTCP(), clienteDireto);
                                auxiliar.add(chatDireto);
                                chatDireto.setVisible(true);
                                chatDireto.preencheMensagem(protocolo.getMensagem());
                            }
                        }
                }
            }
        } catch (IOException ex) {
            if (!close) {
                if (this.tipo.equals("empregado")) {
                    this.empregado.servidorClose();
                } else {
                    this.empregador.servidorClose();
                }
            }
        }

    }
}
