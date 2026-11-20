package Library_system;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BaseUsuarios {
    private ArrayList<Usuario> users;

    public BaseUsuarios() {
        users = new ArrayList<>();
    }

    public BaseUsuarios(ArrayList<Usuario> users) {
        this.users = users;
    }

    public void setUsers(String nome, int idade, int matricula) {
        Usuario user = new Usuario(nome, idade, matricula);
        users.add(user);
    }

    public void setUsers(Usuario user) {
        users.add(user);
    }

    /**
     * Busca um usuário pela matrícula.
     * Retorna null se nenhum usuário com essa matrícula for encontrado.
     */
    public Usuario encontrarPessoa(int matricula) {
        for (Usuario user : users) {
            if (user.getMatricula() == matricula) {
                return user;
            }
        }
        return null; // matrícula não encontrada
    }

    public void listarUsuarios() {
        if (users.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario user : users) {
            user.exibirInfo();
        }
    }

    public void criarRelatorio() {
        Path caminho = Paths.get("Relatorio.txt");

        try {
            StringBuilder relatorio = new StringBuilder();

            relatorio.append("===== RELATÓRIO DE USUÁRIOS =====\n\n");

            for (Usuario user : users) {
                relatorio.append("Nome: ")
                        .append(user.getnome())
                        .append("\n");

                relatorio.append("Idade: ")
                        .append(user.getIdade())
                        .append("\n");

                relatorio.append("Matrícula: ")
                        .append(user.getMatricula())
                        .append("\n");

                relatorio.append("-------------------------\n");
            }

            Files.write(caminho, relatorio.toString().getBytes());

            System.out.println("Relatório criado com sucesso em: " + caminho.toAbsolutePath());

        } catch (Exception e) {
            System.out.println("Erro ao criar relatório: " + e.getMessage());
        }
    }
}
