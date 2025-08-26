import factory.Libro;
import factory.LibroDigital;
import factory.LibroFisico;
import factory.LogisticaLibro;
import singleton.Database;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("------------------PARTE 1");
        // Parte 1, instancia de Singleton (DB)
        Database database = Database.getInstance();
        // Mostrar listado de libros (vacío)
        database.listLibros();
        //Creación de libros
        LibroDigital librod1 = new LibroDigital("libro 1", "Autor1", "ISBN1", "Editorial1");
        LibroFisico librof1 = new LibroFisico("libro 2", "Autor2", "ISBN2", "Editorial2");
        //Carga en database y listado de libros
        database.addLibro(librod1);
        database.addLibro(librof1);
        database.listLibros();

        //Demostración de misma instancia
        Database database2 = Database.getInstance();
        System.out.println("Las instancias son iguales? " + database2.equals(database) );
        System.out.println("------------------PARTE 2");
        //Parte 2, Creacion de libros con factory
        // Creación de libros designando tipo y demostrar que son del tipo correcto
        Libro libro1 = LogisticaLibro.fabrica("fisico","TituloFabrica1","Autor1","ISBN1","Editorial1");
        Libro libro2 = LogisticaLibro.fabrica("digital", "TituloFabrica2","Autor2","ISBN2","Editorial2");

        System.out.println("LIBRO 1 (creado tipo fisico)");
        System.out.println(libro1);
        System.out.println(libro1.getClass());
        System.out.println("LIBRO 2 (creado tipo digital)");
        System.out.println(libro2);
        System.out.println(libro2.getClass());
    }
}