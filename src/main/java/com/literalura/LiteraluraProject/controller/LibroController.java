package com.literalura.LiteraluraProject.controller;

import com.literalura.LiteraluraProject.model.Datos;
import com.literalura.LiteraluraProject.model.DatosLibros;
import com.literalura.LiteraluraProject.service.APIConexion;
import com.literalura.LiteraluraProject.service.ConvierteDatos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private APIConexion consumoAPI = new APIConexion();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";

    @GetMapping
    public String listerLibros(Datos datos) {
        var json = consumoAPI.obetenerDatos(URL_BASE);
        var datosConvertidos = conversor.obtenerDatos(json, DatosLibros.class);
        return null;
    }

}
