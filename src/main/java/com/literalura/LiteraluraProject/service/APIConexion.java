package com.literalura.LiteraluraProject.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {

    public String obetenerDatos(String url) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        HttpResponse<String> response = null;

        try {
            // [Realiza la peticion a la API usando el metodo send que recibe dos parametros (request y el HttpResponse]
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // [Retorna el cuerpo del json]
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con la API", e);
        }
    }
}
