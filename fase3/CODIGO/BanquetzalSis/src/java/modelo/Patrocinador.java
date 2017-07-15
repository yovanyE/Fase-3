
package modelo;

public class Patrocinador {
    private int idPatrocinador;
    private String nombre;

    public Patrocinador() {
    }

    public Patrocinador(int idPatrocinador, String nombre) {
        this.idPatrocinador = idPatrocinador;
        this.nombre = nombre;
    }

    public int getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(int idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
