
package modelo;
public class OrdenProducto {
    private int idProductos;
    private int numeroCuenta;

    public OrdenProducto() {
    }

    public OrdenProducto(int idProductos, int numeroCuenta) {
        this.idProductos = idProductos;
        this.numeroCuenta = numeroCuenta;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
}
