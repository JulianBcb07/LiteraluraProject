package com.literalura.LiteraluraProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ConvierteDatos implements IConvierteDatos {

    // Convertir de json a una clase en java

    public ObjectMapper objectMapper = new ObjectMapper();

    // Recibe un json y una clase de tipo generico
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e ) {
            throw new RuntimeException("Error al transformas el JSON", e);
        }
    }

}


