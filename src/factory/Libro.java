package factory;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editorial;

    public abstract String tipoLibro();

    @Override
    public String toString() {
        return  "Libro "+this.tipoLibro()+ ": " + this.titulo + " | Autor: " + this.autor + " | ISBN: " + this.isbn + " | Editorial: " + this.editorial;
    }
}
