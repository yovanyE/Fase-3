package modelo;

public class Prestamo {
    private double cantidadDinero;
    private int numeroCui;
    private int modalidad;
    private String fecha;

    public Prestamo() {
    }

    public Prestamo(double cantidadDinero, int numeroCui, int modalidad, String fecha) {
        this.cantidadDinero = cantidadDinero;
        this.numeroCui = numeroCui;
        this.modalidad = modalidad;
        this.fecha = fecha;
    }

    public double getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public int getNumeroCui() {
        return numeroCui;
    }

    public void setNumeroCui(int numeroCui) {
        this.numeroCui = numeroCui;
    }

    public int getModalidad() {
        return modalidad;
    }

    public void setModalidad(int modalidad) {
        this.modalidad = modalidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
