package lad.com.alura.conversormoneda.modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorArchivo {
    public void guardarJson(ConversionResponse conversionresponse) throws IOException {
        // 6. Escritura en archivo: Guarda un objeto ConversionResponse como .json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(conversionresponse.conversion_rate() + ".json");
        escritura.write(gson.toJson(conversionresponse));
        escritura.close();
    }
}