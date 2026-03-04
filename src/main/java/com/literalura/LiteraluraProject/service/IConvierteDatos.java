package com.literalura.LiteraluraProject.service;

public interface IConvierteDatos {

    // El uso de <T> T significa que es un metodo generico
    <T> T obtenerDatos(String json, Class<T> clase);

}
