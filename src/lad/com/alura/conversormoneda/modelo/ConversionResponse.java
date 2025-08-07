package lad.com.alura.conversormoneda.modelo;

// IV. Representación de datos con record
public record ConversionResponse(String result, String time_last_update_utc, String time_next_update_utc,
                                 String base_code, String target_code, double conversion_rate) {
    //    Json:
//    {
//    "documentation":"https://www.exchangerate-api.com/docs",
//    "terms_of_use":"https://www.exchangerate-api.com/terms",
//    "time_last_update_unix":1754438401,
//    "time_next_update_unix":1754524801,
//     -> "result":"success",
//    -> "time_last_update_utc":"Wed, 06 Aug 2025 00:00:01 +0000",
//    -> "time_next_update_utc":"Thu, 07 Aug 2025 00:00:01 +0000",
//    -> "base_code":"USD",
//    -> "target_code":"BRL",
//    -> "conversion_rate":5.5046}
//    El valor 56.00 USD equivale a 0.00 BRL
}
