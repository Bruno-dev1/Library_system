package Library_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Biblioteca hogs = new Biblioteca(List.of(
                new Livro("Crepusculo", "Stephenie Meyer", true),
                new Livro("Assim que acaba", "Colleen Hoover", true)
        ));

        Scanner input = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        String username = input.nextLine();

        ArrayList<Usuario> listaInicial = new ArrayList<>(List.of(
                new Usuario("Breno", 12, 3),
                new Usuario("Javar", 90, 4)
        ));
        BaseUsuarios base = new BaseUsuarios(listaInicial);

        // Cadastra o usuário atual com matrícula 0 apenas se ele informar um nome
        if (!username.isBlank()) {
            Usuario user = new Usuario(username, 0, 0);
            base.setUsers(user);
        }

        int resp = 99;
        while (resp != 0) {
            System.out.println("\n1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Cadastrar Usuário");
            System.out.println("5 - Listar Usuários");
            System.out.println("6 - Criar relatório");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            resp = input.nextInt();
            input.nextLine();

            switch (resp) {
                case 1:
                    System.out.println("Nome do livro:");
                    String nome = input.nextLine();
                    System.out.println("Autor:");
                    String autor = input.nextLine();
                    hogs.setNewBook(nome, autor);
                    System.out.println("Salvo com sucesso!");
                    break;

                case 2:
                    hogs.listarLivros();
                    break;

                case 3:
                    hogs.listarLivros();
                    System.out.println("Qual livro você quer? (número)");
                    int index = input.nextInt();
                    input.nextLine();

                    System.out.println("Para qual usuário? (matrícula)");
                    int matricula = input.nextInt();
                    input.nextLine();

                    Livro livroEmprestado = hogs.emprestarLivro(index);
                    if (livroEmprestado == null) {
                        break;
                    }

                    Usuario userEmp = base.encontrarPessoa(matricula);
                    if (userEmp == null) {
                        System.out.println("Usuário com matrícula " + matricula + " não encontrado.");
                        livroEmprestado.setDisponivel(true);
                    } else {
                        userEmp.setEmprestado(livroEmprestado);
                        System.out.println("Livro emprestado com sucesso para " + userEmp.getnome() + "!");
                    }
                    break;

                case 4:
                    System.out.println("Nome do novo usuário:");
                    String nomeUser = input.nextLine();
                    System.out.println("Idade:");
                    int idadeUser = input.nextInt();
                    input.nextLine();
                    System.out.println("Matrícula:");
                    int matriculaUser = input.nextInt();
                    input.nextLine();
                    base.setUsers(nomeUser, idadeUser, matriculaUser);
                    System.out.println("Usuário salvo com sucesso!");
                    break;

                case 5:
                    base.listarUsuarios();
                    break;

                case 6:
                    base.criarRelatorio();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }
}
