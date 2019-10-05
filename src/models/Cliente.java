package models;

/**
 *
 * @author lacomski
 */
public class Cliente {
    private int id;
    private int porta;
    private String nome;
    private String ip;
    private boolean status;
    
    public Cliente(String ip, int porta, String nome){
        this.ip = ip;
        this.porta = porta;
        this.nome = nome;
    }
    
    public Cliente(int id, String nome, String ip, int porta, boolean status){
        this.id = id;
        this.nome = nome;
        this.ip = ip;
        this.porta = porta;
        this.status = status;
    }
    
    public int getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPorta() {
        return this.porta;
    }

    public boolean getStatus(){
        return this.status;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }    
}