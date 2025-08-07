package lad.com.alura.conversormoneda.principal;

import lad.com.alura.conversormoneda.modelo.Conversor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAppModAnt {
    //Función de ejecución de la apliación
    public static void main(String[] args) throws IOException, InterruptedException  {
        boolean salir = false;
        while (!salir) {
            salir = Conversor.eleccionUserMenu(); //reutilizar menu
        }
        System.out.println("Finalizó la ejecución del programa!");
    }
    // Función de responsabilidad unica de llamado HTTP
    private static String realizarPeticionHttp(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> respuesta = client.send(request, HttpResponse.BodyHandlers.ofString());
        return respuesta.body();
    }
    // Función principal que obtiene la tasa de conversión
    public static double obtenerTasa(String urlFinal) throws IOException, InterruptedException {
        // 1. Obtiene respuesta JSON como String desde API
        String cuerpoJson = realizarPeticionHttp(urlFinal);
        // 2. Convierte JSON en objeto para extraer el campo
        JsonElement elemento = JsonParser.parseString(cuerpoJson);
        JsonObject objectRoot = elemento.getAsJsonObject();
        // 3. Devuelve solo el campo "conversion_rate"
        return objectRoot.get("conversion_rate").getAsDouble();
    }
}