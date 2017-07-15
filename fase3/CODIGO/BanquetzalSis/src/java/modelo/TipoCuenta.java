package modelo;

public class TipoCuenta {
   private int idtipoCuenta;
   private String descripcion;

    public TipoCuenta() {
    }

    public TipoCuenta(int idtipoCuenta, String descripcion) {
        this.idtipoCuenta = idtipoCuenta;
        this.descripcion = descripcion;
    }

    public int getIdtipoCuenta() {
        return idtipoCuenta;
    }

    public void setIdtipoCuenta(int idtipoCuenta) {
        this.idtipoCuenta = idtipoCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   public String toString(){
       return descripcion;
   }
}
