package Library_system;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(List<Livro> livros) {
        // Copia para uma lista mutável, evitando UnsupportedOperationException
        this.livros = new ArrayList<>(livros);
    }

    public void setNewBook(String nome, String autor) {
        Livro livro = new Livro(nome, autor, true);
        this.livros.add(livro);
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        for (int i = 0; i < livros.size(); i++) {
            Livro liv = livros.get(i);
            System.out.println((i + 1) + " - Título : " + liv.getTitulo());
            System.out.println("    Autor : " + liv.getAutor());
            System.out.println("    Disponibilidade: " + liv.disponibilidade());
            System.out.println("---------------");
        }
    }

    public Livro emprestarLivro(int index) {
        if (index < 1 || index > livros.size()) {
            System.out.println("Índice inválido.");
            return null;
        }
        Livro emp = livros.get(index - 1);
        if (!emp.isDisponivel()) {
            System.out.println("Este livro já está emprestado.");
            return null;
        }
        emp.setDisponivel(false);
        return emp;
    }
}
