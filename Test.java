package Library_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Biblioteca hogs = new Biblioteca(List.of(
                new Livro("Crepusculo","estranha",true),
                new Livro("Assim que acaba","Collen Hover",true)

        ));
        Scanner input = new Scanner(System.in);
        System.out.println("Qual o seu nome?");
        String username = input.nextLine();
        Usuario user = new Usuario(username, 0, 0);
        int resp = 99;
        ArrayList<Usuario> listaInicial = new ArrayList<>(List.of(
                new Usuario("Breno",12,3),
                new Usuario("javar",90,4)
        )


        );
        BaseUsuarios base = new BaseUsuarios(listaInicial){

        };
        base.setUsers(user);
        while (resp !=0) {
            
        
        System.out.println("1 - Cadastrar Library_system.Livro");
        System.out.println("2 - Listar Livros");
        System.out.println("3 - Emprestar Library_system.Livro");
        System.out.println("4 - Cadastrar Usuário");
        System.out.println("5 - Listar Usuários");
        System.out.println("0 - Sair");
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
                System.out.println("Qual livro você quer?");
                int index = input.nextInt();
                input.nextLine();
                
                System.out.println("Para qual usuário?");
                int adress = input.nextInt();
                input.nextLine();
                Livro livroEmprestado =hogs.emprestarLivro(index);

                try{
                    Usuario userEmp = base.encontrarPessoa(adress);
                    userEmp.setEmprestado(livroEmprestado);
                }catch (Exception e){
                    System.out.println("Erro");
                }

                System.out.println("Library_system.Livro emprestado com sucesso!");
                break;
            case 4:
                System.out.println("O nome do novo usuário");
                String nomeUser = input.nextLine();
                System.out.println("Idade do usuário");
                int idadeUser = input.nextInt();
                input.nextLine();
                System.out.println("Endereço");
                int adressUser = input.nextInt();
                input.nextLine();
                base.setUsers(nomeUser, idadeUser, adressUser);
                System.out.println("Usuário salvo com sucesso!");
                break;
            case 5:
                base.listarUsuarios();
                break;
            case 6 :
                base.criarRelatorio();
                break;
            default:
                break;
        }}




    }

}
