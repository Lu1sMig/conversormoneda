package lad.com.alura.conversormoneda.modelo;

public class Divisa {
    private String result;
    private String time_last_update_utc;
    private String time_next_update_utc;
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public Divisa(String result, String time_last_update_utc, String time_next_update_utc, String base_code, String target_code, double conversion_rate) {
        this.result = result;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

}
