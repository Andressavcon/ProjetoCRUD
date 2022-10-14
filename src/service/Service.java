package service;

import exception.SistemaException;
import model.Aluno;
import model.Pessoa;
import repository.Repository;

import java.util.List;
import java.util.Scanner;

public class Service {

    Scanner sc;
    Repository<Pessoa> repository = new Repository<>();

    public Service(Scanner sc) {
        this.sc = sc;
    }

    public void cadastrar(){
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o telefone: ");
        long telefone = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite a data de nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.println("O usuário possui nota? (S/N) ");
        String pergunta = sc.nextLine();

        if (pergunta.equals("N") || pergunta.equals("n"))  {
            cadastraPessoa(nome, telefone, dataNascimento);
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println("Digite a nota para continuar: ");
                double nota = sc.nextDouble();

                if (nota <= 0 || nota > 10) {
                    System.out.println("Valor inválido");
                } else {
                    cadastraAluno(nome, telefone, dataNascimento, nota);
                    break;
                }
            }
        }
    }

    public void atualizar() {
        Integer idNovo = sc.nextInt();
        Pessoa idExistente = repository.buscar(idNovo);
        if (idExistente == null)  {
            System.out.println("Número incorreto");
            return;
        }
        sc.nextLine();
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o telefone: ");
        long telefone = sc.nextLong();
        sc.nextLine();
        System.out.println("Digite a data de nascimento: ");
        String dataNascimento = sc.nextLine();
        System.out.println("O usuário possui nota? (S/N) ");
        String pergunta = sc.nextLine();

        if (pergunta.equals("N") || pergunta.equals("n")) {
            atualizaPessoa(idNovo, nome, telefone, dataNascimento);
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println("Digite a nota para continuar: ");
                double nota = sc.nextDouble();
                if (nota <= 0 || nota > 10) {
                    System.out.println("Valor inválido");
                } else {
                    atualizaAluno(idNovo, nome, telefone, dataNascimento, nota);
                    break;
                }
            }
        }

    }

    public List<Pessoa> mostrarCadastrados(){
        List<Pessoa> pessoas = repository.buscarTodos();

        pessoas.forEach(v -> System.out.println(v.toString()));
        return pessoas;
    }

    public void excluir(Integer idParam) throws SistemaException {
        Pessoa pessoa = this.repository.buscar(idParam);

        if (pessoa == null) {
            throw new SistemaException("Usuário não encontrado");
        }
        repository.remover(idParam);
        System.out.println("Removido com sucesso");
    }

    public void cadastraPessoa(String nome, long telefone, String dataNascimento){
        Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento);
        repository.salvar(pessoa);
        System.out.println(pessoa.dataCadastro());
    }

    public void atualizaPessoa(Integer idNovo, String nome, long telefone, String dataNascimento){
        Pessoa pessoa = (new Pessoa(idNovo, nome, telefone, dataNascimento));
        repository.salvar(pessoa);
        System.out.println(pessoa.dataAlteracao());
    }

    public void cadastraAluno(String nome, long telefone, String dataNascimento, double nota){
        Aluno aluno = new Aluno(nome, telefone, dataNascimento, nota);
        repository.salvar(aluno);
        System.out.println(aluno.dataCadastro());
    }

    public void atualizaAluno(Integer idNovo, String nome, long telefone, String dataNascimento, double nota){
        Aluno aluno = (new Aluno(idNovo, nome, telefone, dataNascimento, nota));
        repository.salvar(aluno);
        System.out.println(aluno.dataAlteracao());
    }
}
