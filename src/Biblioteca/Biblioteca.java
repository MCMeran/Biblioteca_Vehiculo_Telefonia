/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Biblioteca;

import java.util.ArrayList;
import java.time.LocalDate;

public class Biblioteca {
    
    public static void main(String[] args) {
        // Crear los libros
        Libro libro1 = new Libro("El Quijote", "Cervantes", "ISBN001");
            Libro libro2 = new Libro("Cien Años de Soledad", "García Márquez", "ISBN002");

        // Crear el usuario
        Usuario usuario1 = new Usuario("Miguelangel", "U001");
        System.out.println("-----------------------------------------------------------");

        // Consultar la disponibilidad inicial
        System.out.println("Disponibilidad inicial:");
        System.out.println("El Quijote: " + (libro1.consultarDisponibilidad() ? "Disponible" : "No disponible"));
        System.out.println("Cien Años de Soledad: " + (libro2.consultarDisponibilidad() ? "Disponible" : "No disponible"));
        System.out.println("-----------------------------------------------------------");
        
        // Crear préstamo de El Quijote
        System.out.println("--- Prestando 'El Quijote' ---");
        Prestamo prestamo1 = new Prestamo(usuario1, libro1);
        
        // Consultar disponibilidad después del préstamo

        System.out.println("----------Disponibilidad actual de los Libros -------------");
        
        System.out.println("El Quijote: " + (libro1.consultarDisponibilidad() ? "Disponible" : "No disponible"));
        System.out.println("Cien Años de Soledad: " + (libro2.consultarDisponibilidad() ? "Disponible" : "No disponible"));
        

        System.out.println("-----------------------------------------------------------");
        // Devolver los libro
        
        System.out.println("--- Devolviendo 'El Quijote' ---");
        usuario1.devolverLibro(libro1);

        // Consultar la disponibilidad después de devolverlo
        System.out.println("El Quijote: " + (libro1.consultarDisponibilidad() ? "Disponible" : "No disponible"));
        System.out.println("Cien Años de Soledad: " + (libro2.consultarDisponibilidad() ? "Disponible" : "No disponible"));

    }
}

// Clase Libro
class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponible = true;

    public Libro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public boolean consultarDisponibilidad() {
        return disponible;
    }

    public void prestarLibro() {
        if (disponible) {
            disponible = false;
            System.out.println("Libro prestado: " + titulo);
        } else {
            System.out.println("El libro '" + titulo + "' no está disponible.");
        }
    }

    public void devolverLibro() {
        disponible = true;
        System.out.println("Libro devuelto: " + titulo);
    }
}

// Clase Usuario
class Usuario {
    private String nombre;
    private String id;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void prestarLibro(Libro libro) {
        if (libro.consultarDisponibilidad()) {
            libro.prestarLibro();
            librosPrestados.add(libro);
        } else {
            System.out.println(" No se pudo prestar el libro: " + libro);
        }
    }

    public void devolverLibro(Libro libro) {
        if (librosPrestados.remove(libro)) {
            libro.devolverLibro();
        } else {
            System.out.println("El usuario no tenía este libro prestado.");
        }
    }
}

// Clase Prestamo
class Prestamo {
    private LocalDate fecha;
    private Usuario usuario;
    private Libro libro;

    public Prestamo(Usuario usuario, Libro libro) {
        this.fecha = LocalDate.now();
        this.usuario = usuario;
        this.libro = libro;
        usuario.prestarLibro(libro);
        System.out.println(" Préstamo registrado en fecha: " + fecha);
    }
}

