package models;

public class Servico {

    private String cargo;
    private String descricao;
    private float salario;
    private Cliente empregador;

    public Servico(String cargo, String descricao, float salario, Cliente empregador) {
        this.cargo = cargo;
        this.descricao = descricao;
        this.salario = salario;
        this.empregador = empregador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Cliente getEmpregador() {
        return empregador;
    }

    public void setEmpregador(Cliente empregador) {
        this.empregador = empregador;
    }
    
    
}
