package Library_system;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BaseUsuarios {
    private ArrayList<Usuario> users;

    public BaseUsuarios(){
        users = new ArrayList<>();
    }
    public BaseUsuarios(ArrayList<Usuario> users){
        this.users = users;
    }

    public void setUsers(String nom,int idade, int endereco) {
        Usuario user = new Usuario(nom, idade, endereco);
        users.add(user);
    }
    public void setUsers(Usuario user) {

        users.add(user);
    }

    
    public Usuario encontrarPessoa(int adress){
        for (int i = 0; i < users.size(); i++) {
            if(adress == users.get(i).getMatricula()){
                return users.get(i);
            }
        }
        return users.get(adress);
    }
    public void listarUsuarios(){
        for( Usuario user: users){
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

            System.out.println("Relatório criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
