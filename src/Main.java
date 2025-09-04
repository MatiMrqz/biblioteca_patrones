import abstractfactory.AbstractFactory;
import abstractfactory.InterfazUI;
import abstractfactory.Render;
import builder.Usuario;
import factory.Libro;
import factory.LibroDigital;
import factory.LibroFisico;
import factory.LogisticaLibro;
import prototype.Prestamo;
import singleton.Database;

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

        // PARTE 3, Abstract Factory
        System.out.println("------------------PARTE 3");
        System.out.println("Implementación de Abstract factory. Debe crear UI Admin primero y luego UI Usuario");
        InterfazUI adminUIFactory = AbstractFactory.obtenerInterfaz("Admin");
        Render ui = adminUIFactory.crearInterfaz();
        ui.pintar(); //Debe mostrar la interfaz de Administrador

        InterfazUI userUIFactory = AbstractFactory.obtenerInterfaz("Usuario");
        Render ui2 = userUIFactory.crearInterfaz();
        ui2.pintar();

        //PARTE 4, Patron Builder
        System.out.println("---------------PARTE 4");
        System.out.println("Implementación de Builder.");
        Usuario user1 = new Usuario.Builder()
                .setNombre("Fulanito")
                .setEmail("fulanito@email.com")
                .build();

        Usuario user2 = new Usuario.Builder()
                .setNombre("Menganito")
                .setTelefono("123456789")
                .setDireccion("Calle Falsa 123")
                .build();

        System.out.println(user1);
        System.out.println(user2);

        //PARTE 5, Patron Prototype
        System.out.println("---------------PARTE 5");
        System.out.println("Implementación de Prototype");
        Prestamo prestamo = new Prestamo("Moby Dick", "Pepe", "1/01/2025", "1/03/2025");

        Prestamo copia = prestamo.clone();
        copia.setLibro("El Principito");

        Prestamo copia2 = prestamo.clone();
        copia2.setLibro("El Eternauta");

        System.out.println("Objeto original: " + prestamo);
        System.out.println("Objeto copia: " + copia);
        System.out.println("Objeto copia2: " + copia2);
    }
}