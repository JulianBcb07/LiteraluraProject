package com.literalura.LiteraluraProject.main;

import com.literalura.LiteraluraProject.model.Autor;
import com.literalura.LiteraluraProject.model.Datos;
import com.literalura.LiteraluraProject.model.DatosLibros;
import com.literalura.LiteraluraProject.model.Libro;
import com.literalura.LiteraluraProject.repository.AutorRepository;
import com.literalura.LiteraluraProject.repository.LibroRepository;
import com.literalura.LiteraluraProject.service.APIConexion;
import com.literalura.LiteraluraProject.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private Scanner sc = new Scanner(System.in);
    private APIConexion APIConexion = new APIConexion();
    private final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    public Main(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
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
        System.out.println("Ingrese el titulo del libro que desea buscar:");
        var nombreLibro = sc.nextLine();
        var json = APIConexion.obetenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "%20"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibros> libroBuscado = datosBusqueda.Libros().stream()
                .filter(l -> l.titulo().toUpperCase().contains(nombreLibro.toUpperCase()))
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado: " + libroBuscado.get());

            Optional<Libro> libroExistente = libroRepository.findByTituloIgnoreCase(libroBuscado.get().titulo());

            if (libroExistente.isPresent()) {
                System.out.println("\n-------------------------------------------");
                System.out.println("¡AVISO: El libro '" + libroExistente.get().getTitulo() + "' ya está registrado!");
                System.out.println("-------------------------------------------\n");
            } else {

                DatosLibros datosLibro = libroBuscado.get();
                Libro libro = new Libro(datosLibro);

                var datosAutor = datosLibro.autor().get(0);

                Autor autor = autorRepository.findByNombreIgnoreCase(datosAutor.nombre())
                        .orElseGet(() -> {
                            Autor nuevoAutor = new Autor(datosAutor);
                            return autorRepository.save(nuevoAutor);
                        });

                libro.setAutor(autor);
                libroRepository.save(libro);

                System.out.println("-------------------------------------------");
                System.out.println("Libro y Autor registrados con éxito");
                System.out.println("-------------------------------------------");
            }
        } else {
            System.out.println("Libro no encontrado en la API.");
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> listarLibros = libroRepository.listarLibros();
        if (listarLibros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            listarLibros.forEach(l -> {
                System.out.printf("""
                    -------------- LIBRO -------------
                    Título:    %s
                    Autor:     %s
                    Idioma:    %s
                    Descargas: %.0f
                    ----------------------------------
                    %n""",
                        l.getTitulo(),
                        l.getAutor().getNombre(),
                        l.getIdioma(),
                        l.getNumeroDescargas());
            });
        }
    }

    private void listarAutoresRegistrados() {
        List<Autor> listarAutores = autorRepository.findAll();

        if(listarAutores.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos");
        } else {
            listarAutores.forEach(a -> {

                String tituloLibros = a.getLibros().stream().map(Libro::getTitulo).collect(Collectors.joining(", "));

                    System.out.printf("""
                            Autor: %s
                            Fecha de nacimiento: %s
                            Fecha de fallecimiento: %s
                            Libros: [%s]
                            %n""",
                            a.getNombre(),
                            a.getFechaNacimiento(),
                            a.getFechaFallecimiento() != null ? a.getFechaFallecimiento() : "N/A",
                            tituloLibros
                            );
            });
        }

    }

    private void listarAutoresVivosYear() {

    }

    private void listarLibrosPorIdioma() {

    }

}
