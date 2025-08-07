# <img width="51.2" height="51.2" alt="image" src="https://github.com/user-attachments/assets/7fb1fa68-5989-43e6-810f-044920877ec8" /> Conversor de Monedas en Java

Este proyecto es una aplicación de línea de comandos en Java que permite convertir entre diferentes tipos de monedas utilizando la API pública [ExchangeRate-API](https://www.exchangerate-api.com/). 

Este proyecto es parte del Challenge Back End ONE - G8, con al finalidad de aplicar conocimientos de conceptos tales como el consumo de API, herencia, polimorfismo, listas, entre otros, adicionalmente se implementas buenas prácticas modernas como uso de `HttpClient`, `record`, manejo de errores, Gson para deserialización, persistencia de historial y un menú interactivo con `Map`.

Se desarrollo dos metodos de desearilizacion tanto con Gson/record (ConversorApp.java) y JsonParser (ConversorAppModAnt.java), los cuales sepueden ejecutar desde la carpeta pincipal

---

## 🧩 Características

* Conversión de monedas en tiempo real mediante una API externa.
* Menú interactivo con selección de monedas.
* Uso de `record` para mapear la respuesta JSON de la API, ejecutandose desde ..\Principal\ConversorApp.java.
* Uso de JsonParser para mapear la respuesta JSON de la API, ejecutandose desde ..\PrincipalConversorAppModAnt.java.
* Manejo moderno de excepciones.
* Escritura de historial en archivo de texto.
* Buenas prácticas de separación de responsabilidades.

---

## 💻 Tecnologías usadas

* Java 17 o superior
* Gson (para deserialización JSON)
* API ExchangeRate (versión gratuita)
* Consola Java (`System.in`, `System.out`)
* Java HttpClient (`java.net.http`)

---

## 📂 Estructura del proyecto

```plaintext
conversor-moneda/
├── src/
│   └── lad/com/alura/conversormoneda/
│       ├── principal/
│       │   ├── ConversorApp.java            # Clase principal con flujo de ejecución con record
│       │   └── ConversorAppModAnt.java      # Clase principal con flujo de ejecución con JsonParser
│       ├── modelo/
│       │   ├── Conversor.java               # Lógica de menú, conversiones y validación
│       │   ├── ConversionResponse.java      # Record para mapear la respuesta JSON de la API
│       │   ├── Divisa.java                  # Futura mejora de carga de divisas
│       │   └── GeneradorArchivo.java        # Futura mejora de generador de archivos
│       └── historial/
│           └── historialconsultas.txt       # Registro de conversiones realizadas
```
## 🛠️ Instalación y uso

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/conversor-moneda-java.git

2. Asegúrate de tener Java 17+ y agregar la biblioteca Gson al classpath.
3. Ejecuta la aplicación:
   ```bash
   java lad.com.alura.conversormoneda.principal.ConversorApp
   
4. Sigue el menú para convertir monedas.
   
   Por ejemplo, para lo mostrado en la iamgen, se seleccio la opcion 1 y se ingreso el valor de 100 para el cambio.

<img width="400" height="402" alt="image" src="https://github.com/user-attachments/assets/7993e5e4-2247-4aad-adf5-b53da58265ec" />


## Monedas disponibles

Esta versión tiene las siguientes monedas disponibles
* Dólar estadounidense (USD)
* Peso argentino (ARS)
* Real brasileño (BRL)
* Peso colombiano (COP)

## Futuras lobores para mejoras

1. Interfaz gráfica con Swing o JavaFX.
2. Integración con más monedas usando Map<String, String[]>.
3. Poder leer monedas desde un archivo externo (JSON o properties).
4. Trabajar en los log o historiales en tabla.
