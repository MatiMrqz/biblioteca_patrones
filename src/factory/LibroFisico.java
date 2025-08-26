package factory;

public class LibroFisico extends Libro{
    public LibroFisico(String titulo, String autor, String isbn, String editorial) {
        super(titulo,autor,isbn,editorial);
    }
    @Override
    public String tipoLibro() {
        return "Fisico";
    }
}
