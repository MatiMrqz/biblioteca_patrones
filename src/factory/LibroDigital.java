package factory;

public class LibroDigital extends Libro {
    public LibroDigital(String titulo, String autor, String isbn, String editorial) {
        super(titulo,autor,isbn,editorial);
    }
    @Override
    public String tipoLibro() {
        return "Digital";
    }
}
