package prototype;

import lombok.Setter;

@Setter
public class Prestamo implements Cloneable{
    private String libro;
    private String usuario;
    private String fechaInicio;
    private String fechaFin;

    public Prestamo(String libro, String usuario, String fechaInicio, String fechaFin){
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public Prestamo clone() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return "Prestamo Detalle - Libro: "+ this.libro+ " - Usuario: "+ this.usuario + " - Fecha Inicio prestamo: " +this.fechaInicio+ " - Fecha Fin prestamo: " +this.fechaFin;
    }
}