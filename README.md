# 💱 Conversor de Monedas en Java

Este proyecto es una aplicación de línea de comandos en Java que permite convertir entre diferentes monedas utilizando la API pública [ExchangeRate-API](https://www.exchangerate-api.com/). Implementa buenas prácticas modernas como uso de `HttpClient`, `record`, manejo de errores, Gson para deserialización, persistencia de historial y un menú interactivo con `Map`.

---

## 🧩 Características

* Conversión de monedas en tiempo real mediante una API externa.
* Menú interactivo con selección de monedas.
* Uso de `record` para mapear la respuesta JSON de la API.
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
conversor-moneda/
├── src/
│ └── lad/com/alura/conversormoneda/
│ ├── principal/
│ │ └── ConversorApp.java # Clase principal con flujo principal y API
│ ├── modelo/
│ │ ├── Conversor.java # Lógica del menú, conversiones, historial
│ │ └── ConversionResponse.java # Record para respuesta JSON
│ └── historial/
│ └── historialconsultas.txt # Archivo de historial de conversiones

---

## 🛠️ Instalación y uso

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/conversor-moneda-java.git

2. Asegúrate de tener Java 17+ y agregar la biblioteca Gson al classpath.
3. Ejecuta la aplicación:
   ```bash
   java lad.com.alura.conversormoneda.principal.ConversorApp
   
4. Sigue el menú para convertir monedas.

## Monedas disponibles
Dólar estadounidense (USD)
Peso argentino (ARS)
Real brasileño (BRL)
Peso colombiano (COP)

## Posibles mejoras
Interfaz gráfica con Swing o JavaFX.
Integración con más monedas usando Map<String, String[]>.
Leer monedas desde un archivo externo (JSON o properties).
Validaciones más robustas y pruebas unitarias.
Internacionalización (i18n).
Visualización de historial en tabla.
