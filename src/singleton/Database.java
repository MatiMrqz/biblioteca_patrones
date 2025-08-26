package singleton;

import factory.Libro;

import java.util.ArrayList;

public class Database {
    protected static Database INSTANCE;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    private Database(){}
    public static Database getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public void addLibro(Libro libro){
        INSTANCE.libros.add(libro);
    }
    public void listLibros(){
        INSTANCE.libros.forEach( libro -> System.out.println(libro.toString()) );
    }
}
