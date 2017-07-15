
package modelo;

public class Cheque {
    private String descripcion;
    private double cantidad;
    private String fechaPago;
    private int numeroCuenta;

    public Cheque() {
    }

    public Cheque(String descripcion, double cantidad, String fechaPago, int numeroCuenta) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.fechaPago = fechaPago;
        this.numeroCuenta = numeroCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
}
