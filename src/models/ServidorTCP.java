package models;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import views.ServidorView;

public class ServidorTCP extends Thread {

    protected Socket clienteSocket;
    protected Cliente cliente;
    protected ArrayList<Protocolo> listaInteressados = new ArrayList();
    protected ServidorView main;
    protected DataOutputStream out;
    protected DataInputStream in;
    protected static int qtdClientes;
    protected static int porta;

    public ServidorTCP(Socket socket, ServidorView main) {
        this.main = main;
        this.clienteSocket = socket;
        try {
            out = new DataOutputStream(clienteSocket.getOutputStream()); // prepara para enviar os dados
            in = new DataInputStream(this.clienteSocket.getInputStream()); // prepara para receber os dado
            this.cliente = new Cliente(clienteSocket.getInetAddress().getHostAddress().toString(), clienteSocket.getPort(), " ", out);
        } catch (IOException e) {
            System.out.println("[SERVIDOR]: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        System.out.println("[SERVIDOR]: Nova cliente iniciado. Aguardando o login...");
        try {
            String recebe;
            boolean close = false;
            while ((recebe = in.readUTF()) != null) { // ler dados do cliente
                Protocolo protocolo = new Gson().fromJson(recebe, Protocolo.class);
                switch (protocolo.getAction()) {
                    case "login":
                        this.cliente.setNome(protocolo.getNome());
                        this.cliente.setTipo(protocolo.getTipo());
                        this.login(protocolo, out);
                        break;
                    case "logout":
                        out.close();
                        in.close();
                        clienteSocket.close();
                        this.desconectar();
                        close = true;
                        break;
                    case "broadcast":
                        this.broadcast(protocolo, out);
                        break;
                    case "cadastrarServico":
                        protocolo.getServico().setEmpregador(cliente);
                        this.cadastrarServico(protocolo, out);
                        break;
                    case "mensagemDireta":
                        this.mensagemDireta(protocolo, out);
                        break;
                    case "interesseServico":
                        this.interesseServico(protocolo, out);
                        break;
                    case "contratacao":
                        this.contratacao(protocolo, out);
                        break;
                }
                if (close) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("[SERVIDOR]: Conexão perdida com o Cliente: " + this.cliente.getNome());
            try {
                this.desconectar();
            } catch (IOException ex) {
                System.out.println("[SERVIDOR]: Erro ao remover cliente com conexão perdida");
            }
        }
    }

    public void login(Protocolo protocolo, DataOutputStream out) throws IOException {
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        ListaServicos ctrlServico = ListaServicos.getInstance();
        Gson gson = new Gson();
        Protocolo envioUsuarios = new Protocolo("listarUsuarios");
        Protocolo envioServicos = new Protocolo("listarServicos");

        ctrlCliente.setClientes(this.cliente);
        envioUsuarios.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());
        envioServicos.setServicos((ArrayList<Servico>) ctrlServico.getServicos());
        main.preencheListaServicos((ArrayList<Servico>) ctrlServico.getServicos());

        for (Cliente client : ctrlCliente.getClientes()) {
            client.saidaCliente.writeUTF(gson.toJson(envioUsuarios));
            client.saidaCliente.writeUTF(gson.toJson(envioServicos));
        }

        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente));
        System.out.println("[SERVIÇOS]: " + gson.toJson(ctrlServico));
        System.out.println("[SERVIDOR]: Cliente conectado: " + this.cliente.getNome());
    }

    public void desconectar() throws IOException {
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarUsuarios");

        ctrlCliente.getClientes().remove(this.cliente);
        envio.setClientes((ArrayList<Cliente>) ctrlCliente.getClientes());
        main.preencheListaOnline((ArrayList<Cliente>) ctrlCliente.getClientes());

        for (Cliente client : ctrlCliente.getClientes()) {
            client.saidaCliente.writeUTF(gson.toJson(envio));
        }

        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente.getClientes()));
        System.out.println("[SERVIDOR]: Cliente desconectado: " + this.cliente.getNome());
    }

    public void broadcast(Protocolo protocolo, DataOutputStream out) throws IOException {
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Protocolo envio = new Protocolo("broadcast");
        Gson gson = new Gson();
        String mensagem = cliente.getNome() + ": " + protocolo.getMensagem();

        envio.setMensagem(mensagem);
        main.preencheListaChatGlobal(mensagem);

        for (Cliente client : ctrlCliente.getClientes()) {
            client.saidaCliente.writeUTF(gson.toJson(envio));
        }

        System.out.println("[" + cliente.getNome() + "]: " + protocolo.getMensagem());
    }

    public void cadastrarServico(Protocolo protocolo, DataOutputStream out) throws IOException {
        ListaServicos ctrlServico = ListaServicos.getInstance();
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarServicos");

        ctrlServico.setServicos(protocolo.getServico());
        envio.setServicos((ArrayList<Servico>) ctrlServico.getServicos());
        main.preencheListaServicos((ArrayList<Servico>) ctrlServico.getServicos());

        for (Cliente client : ctrlCliente.getClientes()) {
            client.saidaCliente.writeUTF(gson.toJson(envio));
        }

        System.out.println("[ONLINES]: " + gson.toJson(ctrlCliente.getClientes()));
        System.out.println("[SERVIÇOS]: " + gson.toJson(ctrlServico.getServicos()));
        System.out.println("[SERVIDOR]: " + protocolo.getServico().getCargo());
    }

    public void mensagemDireta(Protocolo protocolo, DataOutputStream out) throws IOException {
        boolean online = false;
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        Protocolo envio = new Protocolo("mensagemDireta");
        Gson gson = new Gson();
        envio.setRemetente(this.cliente);
        envio.setMensagem(protocolo.getMensagem());

        for (Cliente client : ctrlCliente.getClientes()) {
            if (client.getIp().equals(protocolo.getDestinatario().getIp())
                    && client.getNome().equals(protocolo.getDestinatario().getNome())
                    && client.getPorta() == protocolo.getDestinatario().getPorta()) {
                client.saidaCliente.writeUTF(gson.toJson(envio));
                online = true;
                break;
            }
        }
        if (!online) {
            envio.setRemetente(protocolo.getDestinatario());
            envio.setMensagem("Olá, estou offline e não vou conseguir ver sua mensagem!");
            out.writeUTF(gson.toJson(envio));
        }
        System.out.println("MENSAGEM DIRETA RECEBIDA:" + gson.toJson(protocolo));
        System.out.println("MENSAGEM DIRETA ENVIADA:" + gson.toJson(envio));
    }

    public void interesseServico(Protocolo protocolo, DataOutputStream out) throws IOException {
        boolean acho = false;
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("listarInteressados");
        ListaClientes ctrlCliente = ListaClientes.getInstance();
        envio.setServico(protocolo.getServico());

        for (Protocolo listaInteressado : listaInteressados) {
            if (listaInteressado.getServico().getCargo().equals(protocolo.getServico().getCargo())
                    && listaInteressado.getServico().getDescricao().equals(protocolo.getServico().getDescricao())
                    && listaInteressado.getServico().getSalario() == protocolo.getServico().getSalario()) {
                listaInteressado.getInteressados().add(this.cliente);
                envio.setInteressados(listaInteressado.getInteressados());
                acho = true;
            }
        }
        for (Cliente client : ctrlCliente.getClientes()) {
            if (protocolo.getServico().getEmpregador().getIp().equals(client.getIp())
                    && protocolo.getServico().getEmpregador().getNome().equals(client.getNome())
                    && protocolo.getServico().getEmpregador().getPorta() == client.getPorta()) {
                if (acho) {
                    client.saidaCliente.writeUTF(gson.toJson(envio));
                } else {
                    Protocolo interessado = new Protocolo();
                    interessado.setServico(protocolo.getServico());
                    ArrayList<Cliente> c1 = new ArrayList();
                    c1.add(this.cliente);
                    interessado.setInteressados(c1);
                    listaInteressados.add(interessado);
                    envio.setInteressados(interessado.getInteressados());
                    client.saidaCliente.writeUTF(gson.toJson(envio));
                }
                break;
            }
        }
        System.out.println("[ENVIANDO LISTA DE INTERESSADOS]: " + gson.toJson(envio));
    }

    public void contratacao(Protocolo protocolo, DataOutputStream out) throws IOException {
        Gson gson = new Gson();
        Protocolo envio = new Protocolo("contratacao");
        Protocolo envioServicos = new Protocolo("listarServicos");

        ListaServicos ctrlServico = ListaServicos.getInstance();
        ListaClientes ctrlCliente = ListaClientes.getInstance();

        envio.setServico(protocolo.getServico());
        ctrlServico.getServicos().remove(ctrlServico.getServico(envio.getServico()));
        envioServicos.setServicos((ArrayList<Servico>) ctrlServico.getServicos());
        main.preencheListaServicos((ArrayList<Servico>) ctrlServico.getServicos());

        for (Cliente client : ctrlCliente.getClientes()) {
            if (protocolo.getDestinatario().getIp().equals(client.getIp())
                    && protocolo.getDestinatario().getNome().equals(client.getNome())
                    && protocolo.getDestinatario().getPorta() == client.getPorta()) {
                client.saidaCliente.writeUTF(gson.toJson(envio));
                client.saidaCliente.writeUTF(gson.toJson(envioServicos));
                System.out.println("[ENVIANDO CONTRAÇÃO PARA DESEMPREGADO]: " + gson.toJson(envio));
                break;
            }
            client.saidaCliente.writeUTF(gson.toJson(envioServicos));
        }
        System.out.println("[SERVIÇOS ATUALIZADOS]: " + gson.toJson(ctrlServico));

    }

}
