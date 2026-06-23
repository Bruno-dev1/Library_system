package Library_system;

import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(List<Livro> livro) {
        livros = livro;
    }


    public  void setNewBook(String nome, String autor){
        Livro livro = new Livro(nome,autor,true);
        this.livros.add(livro);

    }
    public void listarLivros(){
        for(Livro liv:livros){
            System.out.println("Título : "+ liv.getTitulo());
            System.out.println("Autor : "+ liv.getAutor());
            System.out.println("Disponibilidade: "+ liv.disponibilidade());
            System.out.println("---------------");

        }
    }
    public Livro emprestarLivro(int index){
        Livro emp = livros.get(index-1);
        livros.get(index-1).trocarDisponilidade(0); ;
        return emp;

    }
}