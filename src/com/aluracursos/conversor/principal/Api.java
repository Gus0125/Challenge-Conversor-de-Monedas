package com.aluracursos.conversor.principal;
import com.aluracursos.conversor.modelos.DivisasExchange;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {
    private static final String API_KEY = "1c9ca82090dde98693727c7b";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    // Método para obtener las tasas de conversión de la API
    public static DivisasExchange obtenerConversionRates(String divisaOrigen, String divisaDestino, double cantidad) {
        HttpClient client = HttpClient.newHttpClient();
        // Construir la URL para la solicitud a la API
        String urlStr = BASE_URL + API_KEY + "/pair/" + divisaOrigen + "/" + divisaDestino + "/" + cantidad;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            double conversionResult = gson.fromJson(response.body(), ConversionResponse.class).conversion_result;
            return new DivisasExchange(conversionResult);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de conversión: " + e.getMessage());
            return null;
        }
    }

    // Clase interna para representar la respuesta JSON de la API
    private static class ConversionResponse {
        double conversion_result;
    }
}
