import exception.SistemaException;
import menu.Menu;
import model.Pessoa;
import service.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Service service = new Service(sc);

        Menu.menu();
        Thread.sleep(1500l);

        boolean continua = true;
        do {
            try{
                Menu.menu1();
                int opcao1 = sc.nextInt();
                sc.nextLine();

                switch (opcao1){
                    case 1:
                        Menu.menu2();
                        service.cadastrar();
                        break;

                    case 2:
                        Menu.menu3();
                        List<Pessoa> cadastrados = service.mostrarCadastrados();
                        if (cadastrados.size() <= 0) {
                            System.out.println("Nenhum usuário cadastrado");
                        }
                        break;
                    case 3:
                        Menu.menu4();
                        cadastrados = service.mostrarCadastrados();
                        if (cadastrados.size() <= 0) {
                            System.out.println("Nenhum usuário cadastrado");
                            break;
                        }
                        service.atualizar();
                        break;
                    case 4:
                        Menu.menu5();
                        cadastrados = service.mostrarCadastrados();
                        if (cadastrados.size() <= 0) {
                            System.out.println("Nenhum usuário cadastrado");
                            break;
                        }
                        Integer id = sc.nextInt();
                        service.excluir(id);
                        break;
                    case 0:
                        continua = false;
                        break;
                    default:
                        System.out.println("Alternativa inválida. Tente novamente!");
                        break;
                }
            }catch(SistemaException e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("Opção inválida");
                sc.next();
            } finally {
                Thread.sleep(1500l);
            }

        } while(continua);

        Menu.menu6();
    }
}