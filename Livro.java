package Library_system;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Livro(String titulo, String autor, boolean disponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    public String disponibilidade() {
        if (disponivel) {
            return "Disponível";
        } else {
            return "Indisponível";
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }
}
