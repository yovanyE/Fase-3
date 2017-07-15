
package modelo;
public class Deposito {
    private double deposita;
    private String fecha;
    private int numeroCui;
    private int numeroCuenta;

    public Deposito() {
    }

    public Deposito(double deposita, String fecha, int numeroCui, int numeroCuenta) {
        this.deposita = deposita;
        this.fecha = fecha;
        this.numeroCui = numeroCui;
        this.numeroCuenta = numeroCuenta;
    }

    public double getDeposita() {
        return deposita;
    }

    public void setDeposita(double deposita) {
        this.deposita = deposita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumeroCui() {
        return numeroCui;
    }

    public void setNumeroCui(int numeroCui) {
        this.numeroCui = numeroCui;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
}
