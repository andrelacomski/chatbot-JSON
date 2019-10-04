package models;

/**
 *
 * @author lacomski
 */
public class Protocolo {
    private String action;
    private String nome;

    
    public Protocolo(String action, String nome){
        this.action = action;
        this.nome = nome;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAction() {
        return action;
    }

    public String getNome() {
        return nome;
    }
}
