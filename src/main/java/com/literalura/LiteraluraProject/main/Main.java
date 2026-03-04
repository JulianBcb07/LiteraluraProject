package com.literalura.LiteraluraProject.main;

import com.literalura.LiteraluraProject.repository.LibroRepository;
import com.literalura.LiteraluraProject.service.APIConexion;
import com.literalura.LiteraluraProject.service.ConvierteDatos;

import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private APIConexion APIConexion = new APIConexion();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository libroRepository;

    public Main(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void muestraElMenu() {
        var opcion = 1;
        while(opcion !=0) {
            var menu = """
                    ===================================
                    Elija una opció del menú:
                    
                    1- Buscar libro por título
                    2- Listar libros registrados
                    3- Listar autores registrados
                    4- Listar autores vivos en un determinado año
                    5- Listar libros por idioma
                    
                    0- Salir
                    =================================== 
                    """;
            System.out.println(menu);
            opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosYear();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción invalida");
                }
        }
    }

    private void buscarLibroPorTitulo() {

    }

    private void listarLibrosRegistrados() {

    }

    private void listarAutoresRegistrados() {

    }

    private void listarAutoresVivosYear() {

    }

    private void listarLibrosPorIdioma() {

    }

}
