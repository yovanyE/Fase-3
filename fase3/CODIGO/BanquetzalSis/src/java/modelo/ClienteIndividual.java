package modelo;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class ClienteIndividual {
    private int numeroCui;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String telefono;
    private String direccion;
    private double sueldo;
    private String login;
    private String password;

    public ClienteIndividual() {
    }

    public ClienteIndividual(int numeroCui, String nombres, String apellidos, String fechaNacimiento, String telefono, String direccion, double sueldo, String login, String password) {
        this.numeroCui = numeroCui;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento =fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.sueldo = sueldo;
        this.login = login;
        this.password = password;
    }
    public int getNumeroCui() {
        return numeroCui;
    }

    public void setNumeroCui(int numeroCui) {
        this.numeroCui = numeroCui;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
   public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString(){
        return numeroCui+" "+nombres+" "+apellidos;
    }
    
}
