package menu;

import java.time.LocalDateTime;

public class Menu {

    public static void menu() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|         "+mensagem()+" Seja bem vindo(a)!               |");
        System.out.println("+------------------------------------------------------+");
    }

    public static void menu1() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|           Digite a opção correspondente:             |");
        System.out.println("+------------------------------------------------------+");
        System.out.println("| 1 - Cadastrar                                        |");
        System.out.println("| 2 - Visualizar                                       |");
        System.out.println("| 3 - Atualizar                                        |");
        System.out.println("| 4 - Excluir                                          |");
        System.out.println("| 0 - Sair                                             |");
        System.out.println("+------------------------------------------------------+");
    }


    public static void menu2() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|              Cadastro de usuário                     |");
        System.out.println("+------------------------------------------------------+");
    }

    public static void menu3() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|          Lista de usuários cadastrados               |");
        System.out.println("+------------------------------------------------------+");
    }

    public static void menu4() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|    Digite o número do usuário que deseja atualizar   |");
        System.out.println("+------------------------------------------------------+");
    }

    public static void menu5() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|     Digite o número do usuário que deseja excluir    |");
        System.out.println("+------------------------------------------------------+");
    }

    public static void menu6() {
        System.out.println("\n\n");
        System.out.println("+------------------------------------------------------+");
        System.out.println("|   Obrigada por utilizar nossos serviços!" + mensagem()+ "  |");
        System.out.println("+------------------------------------------------------+");
    }

    public static String mensagem() {
        String saudacao;
        LocalDateTime agora = LocalDateTime.now();
        if (agora.getHour() >= 0 && agora.getHour() < 12) {
            saudacao = "   Bom dia!";
        } else if (agora.getHour() >= 12 && agora.getHour() < 18) {
            saudacao = " Boa tarde!";
        } else {
            saudacao = " Boa noite!";
        }
        return saudacao;
    }
}
