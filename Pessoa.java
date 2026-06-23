package Library_system;

public abstract class Pessoa {
    private String nome;
    private int idade;
    

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getnome(){
        return this.nome;
    }

    public abstract void exibirInfo();

    public int getIdade() {
        return idade;
    }
}