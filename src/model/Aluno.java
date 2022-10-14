package model;

public class Aluno extends Pessoa {

    protected double nota;

    public Aluno(String nome, long telefone, String dataNascimento, double nota) {
        super(nome, telefone, dataNascimento);
        this.nota = nota;
    }
    public Aluno(Integer id, String nome, long telefone, String dataNascimento, double nota) {
        super(id, nome, telefone, dataNascimento);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return id + " - " + "Aluno: " + nome + ", nota: " + nota + ", telefone " + telefone + ", Data nascimento: " + dataNascimento;
    }

    @Override
    public String dataCadastro(){
        return "Cadastrado com sucesso no dia: " + cadastro;
    }

    @Override
    public String dataAlteracao(){
        return "Alteração feita no dia " + alteracao;
    }
}
