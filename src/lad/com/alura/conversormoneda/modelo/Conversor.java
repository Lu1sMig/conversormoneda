package lad.com.alura.conversormoneda.modelo;

import lad.com.alura.conversormoneda.principal.ConversorApp;

import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    //10 Interactuando con el usuario
    public static void exibirMenu() {
        System.out.println("*********CAMBIO DE DIVISAS*********");
        System.out.println("1) Dolar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dolar");
        System.out.println("3) Dólar => Real Brasileño");
        System.out.println("4) Real Brasileño =>> Dolar");
        System.out.println("5) Dólar => Peso Colombiano\");");
        System.out.println("6) Peso  Colombiano =>> Dolar");
        System.out.println("7) Salir");
        System.out.println("------------------------");
        System.out.println("Elije una opción valida:");
        System.out.println("*******************************************\n");
    }
    public static boolean opcionesSeleccionMenu(){
        return false;
    }
    //Crola el fujo del menu e invoca a la conversión
    public static boolean eleccionUserMenu() {
        //presenta el interface del usuario
        exibirMenu();
        Scanner lectura = new Scanner(System.in);
        var opcion = lectura.nextLine(); //Lee valor ingresado

        if (opcion.equals("7")) {
            System.out.println("Gracias por usar el conversor.");
            return true; //corta ejecución del programa
        }

        // Usando map en lugar de switch para obtener valores de modenas por un Map, como mejores practicas,
        Map<String, String[]> conversiones = Map.of(
                "1", new String[]{"USD", "ARS"},
                "2", new String[]{"ARS", "USD"},
                "3", new String[]{"USD", "BRL"},
                "4", new String[]{"BRL", "USD"},
                "5", new String[]{"USD", "COP"},
                "6", new String[]{"COP", "USD"}
        );
        if (!conversiones.containsKey(opcion)) {
            System.out.println("⚠ Opción inválida. Intente de nuevo.");
            return false;
        }

        String[] monedas = conversiones.get(opcion);
        String monedaOrigen = monedas[0];
        String monedaDestino = monedas[1];
        // Solicita el valor numérico a convertir
        System.out.println("Ingrese el valor que desea convertir:");
        double valor;
        try {
            valor = Double.parseDouble(lectura.nextLine());
            //valor negativo
            if (valor <= 0) {
                System.out.println("⚠ El valor debe ser mayor que cero. Intente de nuevo.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠ Valor inválido. Intente de nuevo.");
            return false;
        }

        // Construye la URL para la consulta
        String apiKey = "5352bea3b84fc033a3f51fef";  // 2. Consumo de API
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaOrigen + "/" + monedaDestino;
         //System.out.println(url);
        try {
            // Solicita el valor numérico a convertir llamando al metodo moderno con record + Gson
            double tasa = ConversorApp.obtenerTasa(url);
            double resultado = valor * tasa;

            System.out.printf("El valor %.2f %s equivale a %.2f %s%n", valor, monedaOrigen, resultado, monedaDestino);

            // Guarda historial de conversiones
            guardarHistorial(monedaOrigen, monedaDestino, valor, resultado);
        } catch (Exception e) {    // 5. Manejo de errores
            System.out.println("Error al obtener el tipo de cambio: " + e.getMessage());
        }

        return false; // continuar ejecución
    }
    private static void guardarHistorial(String origen, String destino, double valorOriginal, double resultado) {
        try (FileWriter writer = new FileWriter("src/lad/com/alura/conversormoneda/historial/historialconsultas.txt", true)) {
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(String.format("[%s] %.2f %s => %.2f %s%n", fecha, valorOriginal, origen, resultado, destino));
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el historial: " + e.getMessage());
        }
    }
}
