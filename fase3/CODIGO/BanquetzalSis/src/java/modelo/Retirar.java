
package modelo;
public class Retirar {
    public double retira;
    public String fecha;
    public int numeroCui;
    public int numeroCuenta;

    public Retirar() {
    }

    public Retirar(double retira, String fecha, int numeroCui, int numeroCuenta) {
        this.retira = retira;
        this.fecha = fecha;
        this.numeroCui = numeroCui;
        this.numeroCuenta = numeroCuenta;
    }

    public double getRetira() {
        return retira;
    }

    public void setRetira(double retira) {
        this.retira = retira;
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
