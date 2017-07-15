package controlador;

import DBaseDato.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import modelo.Agencia;
import modelo.Empleado;
import modelo.Patrocinador;
import modelo.Producto;
import reporte.*;

public class EmpleadoController {

    public String registrarEmpleado(int numeroCui, String nombre, String apellido, String direccion, String telefono, int idAgencia, int idRol, String login, String password) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarEmpleado(?,?,?,?,?,?,?,?,?)");
            procedimiento.setInt(1, numeroCui);
            procedimiento.setString(2, nombre);
            procedimiento.setString(3, apellido);
            procedimiento.setString(4, direccion);
            procedimiento.setString(5, telefono);
            procedimiento.setInt(6, idAgencia);
            procedimiento.setInt(7, idRol);
            procedimiento.setString(8, login);
            procedimiento.setString(9, password);
            int rs = procedimiento.executeUpdate();
            if (rs > 0) {
                respuesta = "empleado registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Empleado buscarEmpleado(int cui) {
        Empleado empleadoB = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_busuqedaEmpleado(?)");
            procedimiento.setInt(1, cui);
            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                empleadoB = new Empleado();
                empleadoB.setCui(resultado.getInt(1));
                empleadoB.setNombre(resultado.getString(2));
                empleadoB.setApellidos(resultado.getString(3));
                empleadoB.setDireccion(resultado.getString(4));
                empleadoB.setTelefono(resultado.getString(5));
                empleadoB.setIdAgencia(resultado.getInt(6));
                empleadoB.setIdRol(resultado.getInt(7));
                empleadoB.setLogin(resultado.getString(8));
                empleadoB.setPassword(resultado.getString(9));

                return empleadoB;
            }
        } catch (Exception e) {
        }
        return empleadoB;
    }

    public Empleado eliminarEmpleado(int cui) {
        Empleado elimina = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarEmpleado(?)");
            procedimiento.setInt(1, cui);

            ResultSet resultado = procedimiento.executeQuery();

            if (resultado.next()) {
                elimina = new Empleado();
                elimina.setCui(resultado.getInt(1));
                elimina.setNombre(resultado.getString(2));
                elimina.setApellidos(resultado.getString(3));
                elimina.setDireccion(resultado.getString(4));
                elimina.setTelefono(resultado.getString(5));
                elimina.setIdAgencia(resultado.getInt(6));
                elimina.setIdRol(resultado.getInt(7));
                elimina.setLogin(resultado.getString(8));
                elimina.setPassword(resultado.getString(9));
                return elimina;
            }
        } catch (Exception e) {

        }

        return elimina;
    }

    public Empleado modificarEmpleado(int cui, String nombre, String apellidos, String direccion, String telefono, int idAgencia, int idrol, String login, String password) {
        Empleado modificar = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_modificarEmpleado(?,?,?,?,?,?,?,?,?)");
            procedimiento.setInt(1, cui);
            procedimiento.setString(2, nombre);
            procedimiento.setString(3, apellidos);
            procedimiento.setString(4, direccion);
            procedimiento.setString(5, telefono);
            procedimiento.setInt(6, idAgencia);
            procedimiento.setInt(7, idrol);
            procedimiento.setString(8, login);
            procedimiento.setString(9, password);

            ResultSet resultado = procedimiento.executeQuery();

            if (resultado.next()) {
                modificar = new Empleado();
                modificar.setCui(resultado.getInt(1));
                modificar.setNombre(resultado.getString(2));
                modificar.setApellidos(resultado.getString(3));
                modificar.setDireccion(resultado.getString(4));
                modificar.setTelefono(resultado.getString(5));
                modificar.setIdAgencia(resultado.getInt(6));
                modificar.setIdRol(resultado.getInt(7));
                modificar.setLogin(resultado.getString(8));
                modificar.setPassword(resultado.getString(9));
                return modificar;
            }
        } catch (Exception e) {

        }
        return modificar;
    }

    public Empleado loginEmpleado(String login, String password) {
        Empleado log = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_autenticarEmpleado(?,?)");
            procedimiento.setString(1, login);
            procedimiento.setString(2, password);

            ResultSet rs = procedimiento.executeQuery();
            if (rs.next()) {
                log = new Empleado();
                log.setCui(rs.getInt(1));
                log.setNombre(rs.getString(2));
                log.setApellidos(rs.getString(3));
                log.setDireccion(rs.getString(4));
                log.setTelefono(rs.getString(5));
                log.setIdAgencia(rs.getInt(6));
                log.setIdRol(rs.getInt(7));
                log.setLogin(rs.getString(8));
                log.setPassword(rs.getString(9));
                return log;
            }
        } catch (Exception e) {

        }
        return log;
    }

    public String registrarAgencia(String nombre, String direccion) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarAgencia(?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, direccion);

            int rs = procedimiento.executeUpdate();
            if (rs > 0) {
                respuesta = "Agencia registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Agencia buscarAgencia(String nombre) {
        Agencia agenciaB = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarAgencia(?)");
            procedimiento.setString(1, nombre);
            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                agenciaB = new Agencia();
                agenciaB.setNombre(resultado.getString(1));
                agenciaB.setDireccion(resultado.getString(2));
                return agenciaB;
            }
        } catch (Exception e) {
        }
        return agenciaB;
    }

    public Agencia eliminAgencia(String nombre) {
        Agencia elimina = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarAgencia(?)");
            procedimiento.setString(1, nombre);

            ResultSet resultado = procedimiento.executeQuery();

            if (resultado.next()) {
                elimina = new Agencia();
                elimina.setNombre(resultado.getString(1));
                elimina.setDireccion(resultado.getString(2));

                return elimina;
            }
        } catch (Exception e) {
        }
        return elimina;
    }

    public Agencia modificarAgencia(String nombre, String direccion) {
        Agencia modificar = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_modificarAgencia(?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, direccion);

            ResultSet resultado = procedimiento.executeQuery();

            if (resultado.next()) {
                modificar = new Agencia();
                modificar.setNombre(resultado.getString(2));
                modificar.setDireccion(resultado.getString(4));

                return modificar;
            }
        } catch (Exception e) {

        }
        return modificar;
    }

    public String registrarProveedor(String nombre) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarPatrocinador(?)");
            procedimiento.setString(1, nombre);

            int rs = procedimiento.executeUpdate();
            if (rs > 0) {
                respuesta = "proveedor registrado";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Patrocinador buscarProveedor(String nombre) {
        Patrocinador PatrocinadorB = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarPatrocinador(?)");
            procedimiento.setString(1, nombre);
            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                PatrocinadorB = new Patrocinador();
                PatrocinadorB.setNombre(resultado.getString(1));

                return PatrocinadorB;
            }
        } catch (Exception e) {
        }
        return PatrocinadorB;
    }

    public String registrarProducto(String nombre, int idPatrocinador) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarProductos(?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setInt(2, idPatrocinador);

            int rs = procedimiento.executeUpdate();
            if (rs > 0) {
                respuesta = "producto registrado";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Producto buscarProducto(String nombre) {
        Producto productoB = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarProducto(?)");
            procedimiento.setString(1, nombre);
            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                productoB = new Producto();
                productoB.setNombre(resultado.getString(1));
                productoB.setIdPatrocinador(resultado.getInt(2));

                return productoB;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productoB;
    }

    public void generarReporteProducto() {
        Map parametros = new HashMap();
        ReporteProductoSolicitado.generarReporteProducto("productoSolicitado.jasper", parametros, "reporte Producto");
    }

    public void generarReportePatrocinador() {
        Map parametros = new HashMap();
        ReportePatrocinadorSolicitado.generarReportePatrocinador("reportePatrocinadorSolicitado.jasper", parametros, "reporte Patrocinador");
    }
}
