package lad.com.alura.conversormoneda.principal;

import com.google.gson.*;
import lad.com.alura.conversormoneda.modelo.ConversionResponse;
import lad.com.alura.conversormoneda.modelo.Conversor;
import lad.com.alura.conversormoneda.modelo.Divisa;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorApp {
    public static void main(String[] args) throws IOException, InterruptedException  {
        //Lo primero que se ejecuta
        while (!Conversor.eleccionUserMenu()) {
            //Usara el menu hasta que usuario presione 7
        }
        System.out.println("Finalizó la ejecución del programa!");
    }
    //IV.- Contruyendo el cliente de solicutudes (Httpclient)
    // Función de responsabilidad unica, creating HTTP solicitude, whit class `HttpClient`, `HttpRequest` y `HttpResponse`
    //VI.- Analisando la respuesta en formato Json - mostrar valores recuperados
    private static String realizarPeticionHttp(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println("Valores recuperados de API:\n");
        //String json = response.body();
        //System.out.println("Json:\n"+response.body());
        return respuesta.body();
    }
    // Obtiene la tasa de conversión entre 2 monedas (usando Gson + record)
    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
        // 1. Realiza la solicitud HTTP y recupera el cuerpo JSON como String
        // 2. Deserializa JSON con Gson al record ConversionResponse
        Gson gson = new GsonBuilder().create();
        ConversionResponse conversionResponse = gson.fromJson( realizarPeticionHttp(urlFinal), ConversionResponse.class);
        //System.out.println("Gson deserializado:\n" + conversionResponse);
        // 3. Retorna la tasa de conversión
        return conversionResponse.conversion_rate();
    }
}