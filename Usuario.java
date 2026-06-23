package Library_system;

public class Usuario extends Pessoa {
    private int matricula;
    private Livro emprestado;

    public Usuario(String nome, int idade, int matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Nome :" + super.getnome());
        System.out.println("Usuário: " + matricula);

    }

    public void setEmprestado(Livro emprestado) {
        this.emprestado = emprestado;
    }

    public int getMatricula() {
        return matricula;
    }
}