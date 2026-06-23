package Library_system;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(boolean disponivel){
        this.disponivel = disponivel;
    }
     public Livro(String name ,String autor,boolean disponivel){
        this.titulo = name;
        this.autor = autor;
        this.disponivel = disponivel;
    }
    public String disponibilidade(){
        if (disponivel) {
            return "Disponível";
        }else{
            return "indisponível";
        }
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
    public void trocarDisponilidade(int i){
        if (i == 1) {
            this.disponivel = true;
        }else{
            this.disponivel = false;
        }
    }
}