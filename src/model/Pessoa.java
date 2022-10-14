package model;

import util.Contador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pessoa implements Banco {
    protected Integer id;

    protected String nome;
    protected long telefone;
    protected String dataNascimento;

    DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    protected LocalDateTime dataCadastro = LocalDateTime.now();
    String cadastro = dataCadastro.format(formatacao);

    protected LocalDateTime dataAlteracao = LocalDateTime.now();
    String alteracao = dataAlteracao.format(formatacao);

    public Pessoa(String nome, long telefone, String dataNascimento) {
        this.id = Contador.proximoId();
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Pessoa(Integer id, String nome, long telefone, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        return id + " - " + "Pessoa: " +  nome + ", telefone " + telefone + ", Data nascimento: " + dataNascimento;
    }

    public String dataCadastro(){
        return "Cadastrado com sucesso no dia: " + cadastro;
    }

    public String dataAlteracao(){
        return "Alteração feita no dia " + alteracao;
    }
}
