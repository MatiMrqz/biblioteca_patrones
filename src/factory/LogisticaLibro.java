package factory;

public class LogisticaLibro {
    public static Libro fabrica(String tipo, String titulo, String autor, String isbn, String editorial ) {
        if(tipo.equals("fisico")) return new LibroFisico(titulo,autor,isbn,editorial);
        else if(tipo.equals("digital")) return new LibroDigital(titulo,autor,isbn,editorial);
        else return null;
    }
}
