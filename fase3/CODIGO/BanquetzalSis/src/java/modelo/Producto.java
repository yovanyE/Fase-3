
package modelo;
public class Producto {
    private String nombre;
    private int idPatrocinador;

    public Producto() {
    }

    public Producto(String nombre, int idPatrocinador) {
        this.nombre = nombre;
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }
}
