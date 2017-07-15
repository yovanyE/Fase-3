package controlador;

import DBaseDato.Conexion;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import modelo.Cheque;
import modelo.ClienteIndividual;
import modelo.CuentaBancaria;
import modelo.Deposito;
import modelo.Prestamo;
import modelo.Retirar;
import modelo.TipoCuenta;
import reporte.GenerarReportePrestamo;

public class ClienteController {

    public String registrarClienteIndividual(int cui, String nombre, String apellido, String fechaNacimiento, String telefono, String direccion, double sueldo, String login, String password) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_agregarClienteindiv(?,?,?,?,?,?,?,?,?)");
            procedimiento.setInt(1, cui);
            procedimiento.setString(2, nombre);
            procedimiento.setString(3, apellido);
            procedimiento.setString(4, fechaNacimiento);
            procedimiento.setString(5, telefono);
            procedimiento.setString(6, direccion);
            procedimiento.setDouble(7, sueldo);
            procedimiento.setString(8, login);
            procedimiento.setString(9, password);

            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public String registrarClienteEmpresarial(String nombre, String direccion, String telefono, String login, String password) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registroEmpresa(?,?,?,?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, direccion);
            procedimiento.setString(3, telefono);
            procedimiento.setString(4, login);
            procedimiento.setString(5, password);

            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public String crearCuentaBancaria(int numeroCuenta, int idTipoCuenta, int idClienteindividual, int idClienteempresarial, double sueldo) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_crearCuentaBancaria(?,?,?,?,?)");
            procedimiento.setInt(1, numeroCuenta);
            procedimiento.setInt(2, idTipoCuenta);
            procedimiento.setInt(3, idClienteindividual);
            procedimiento.setInt(4, idClienteempresarial);
            procedimiento.setDouble(5, sueldo);
            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public CuentaBancaria modificarCuenta(int numeroCuenta, int idTipoCuenta, int numeroCui, int idClienteEmpresa, double saldo) {
        CuentaBancaria modificar = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_modificarCuentaBancaria(?,?,?,?,?)");
            procedimiento.setInt(1, numeroCuenta);
            procedimiento.setInt(2, idTipoCuenta);
            procedimiento.setInt(3, numeroCui);
            procedimiento.setInt(4, idClienteEmpresa);
            procedimiento.setDouble(5, saldo);
            procedimiento.execute();

        } catch (Exception e) {

        }
        return modificar;
    }

    public CuentaBancaria buscarCuentaBancaria(int numeroCuenta) {
        CuentaBancaria busqueda = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarCuentaBancaria(?)");
            procedimiento.setInt(1, numeroCuenta);

            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                busqueda = new CuentaBancaria();
                busqueda.setNumeroCuenta(resultado.getInt(1));
                busqueda.setIdTipoCuenta(resultado.getInt(2));
                busqueda.setNumeroCui(resultado.getInt(3));
                busqueda.setIdClienteEmpresa(resultado.getInt(4));
                busqueda.setSaldo(resultado.getDouble(5));
                return busqueda;
            }

        } catch (Exception e) {

        }
        return busqueda;
    }

    public CuentaBancaria eliminarCuentaBancaria(int numeroCuenta) {
        CuentaBancaria eliminar = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarCuentaBancaria(?)");
            procedimiento.setInt(1, numeroCuenta);

            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {

        }
        return eliminar;
    }

    public ClienteIndividual verificarUsuario(String login, String password) {
        ClienteIndividual cliente = null;
        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("SELECT *FROM clienteindividual WHERE login=? AND PASSWORD=?");
            proceso.setString(1, login);
            proceso.setString(2, password);

            ResultSet rs = proceso.executeQuery();

            if (rs.next()) {
                cliente = new ClienteIndividual();
                cliente.setNombres(rs.getString(1));
                cliente.setApellidos(rs.getString(2));
                cliente.setSueldo(rs.getDouble(3));
                cliente.setLogin(rs.getString(4));
                cliente.setPassword(rs.getString(5));

                return cliente;
            }
        } catch (Exception e) {

        }
        return cliente;
    }

    public ClienteIndividual buscarclienteindividual(int numeroCui) {
        ClienteIndividual clienteB = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarCliente(?)");
            proceso.setInt(1, numeroCui);

            ResultSet resultado = proceso.executeQuery();
            if (resultado.next()) {
                clienteB = new ClienteIndividual();
                clienteB.setNumeroCui(resultado.getInt(1));
                clienteB.setNombres(resultado.getString(2));
                clienteB.setApellidos(resultado.getString(3));
                clienteB.setFechaNacimiento(resultado.getString(4));
                clienteB.setTelefono(resultado.getString(5));
                clienteB.setDireccion(resultado.getString(6));
                clienteB.setSueldo(resultado.getDouble(7));
                clienteB.setLogin(resultado.getString(8));
                clienteB.setPassword(resultado.getString(9));

                return clienteB;
            }
        } catch (Exception e) {

        }
        return clienteB;
    }

    public ClienteIndividual eliminarClienteindividual(int numeroCui) {
        ClienteIndividual respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL Sp_eliminarCindividual(?)");
            procedimiento.setInt(1, numeroCui);
            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public ClienteIndividual modificarClienteindividual(int numeroCui, String nombre, String apellidos, String fechaNacimiento, String telefono, String direccion, double sueldo, String login, String password) {
        ClienteIndividual clienteM = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL Sp_modificarCindividual(?,?,?,?,?,?,?,?,?)");
            proceso.setInt(1, numeroCui);
            proceso.setString(2, nombre);
            proceso.setString(3, apellidos);
            proceso.setString(4, fechaNacimiento);
            proceso.setString(5, telefono);
            proceso.setString(6, direccion);
            proceso.setDouble(7, sueldo);
            proceso.setString(8, login);
            proceso.setString(9, password);
            proceso.execute();
        } catch (Exception e) {

        }
        return clienteM;
    }

    public TipoCuenta buscarCuenta(int idtipoCuenta) {
        TipoCuenta tipo = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("");
            procedimiento.setInt(1, idtipoCuenta);

            ResultSet resultado = procedimiento.executeQuery();

            while (resultado.next()) {
                tipo = new TipoCuenta(resultado.getInt("idTipoCuenta"), resultado.getString("descripcion"));
            }
        } catch (Exception e) {

        }
        return tipo;
    }

    public String IngresarPrestamos(double cantidadDinero, int numeroCui, int idmodalidad, String fecha) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarPrestamo(?,?,?,?)");
            procedimiento.setDouble(1, cantidadDinero);
            procedimiento.setInt(2, numeroCui);
            procedimiento.setInt(3, idmodalidad);
            procedimiento.setString(4, fecha);
            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Prestamo buscarPrestamo(int numeroCui) {
        Prestamo prestamoB = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarPrestamo(?)");
            proceso.setInt(1, numeroCui);

            ResultSet resultado = proceso.executeQuery();
            if (resultado.next()) {
                prestamoB = new Prestamo();
                prestamoB.setCantidadDinero(resultado.getDouble(1));
                prestamoB.setNumeroCui(resultado.getInt(2));
                prestamoB.setModalidad(resultado.getInt(3));
                prestamoB.setFecha(resultado.getString(4));
                return prestamoB;
            }
        } catch (Exception e) {

        }
        return prestamoB;
    }

    public Prestamo eliminarPrestamo(int numeroCui) {
        Prestamo respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarPrestamo(?)");
            procedimiento.setInt(1, numeroCui);
            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public String registrarCobroDeCheque(String descripcion, int cantidadPago, String fechaPago, int numeroCuenta) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarCheque(?,?,?,?)");
            procedimiento.setString(1, descripcion);
            procedimiento.setInt(2, cantidadPago);
            procedimiento.setString(3, fechaPago);
            procedimiento.setInt(4, numeroCuenta);

            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public Cheque buscarCheque(int numeroCuenta) {
        Cheque busCheque = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarCheque(?)");
            proceso.setInt(1, numeroCuenta);

            ResultSet resultado = proceso.executeQuery();
            if (resultado.next()) {
                busCheque = new Cheque();
                busCheque.setDescripcion(resultado.getString(1));
                busCheque.setCantidad(resultado.getDouble(2));
                busCheque.setFechaPago(resultado.getString(3));
                busCheque.setNumeroCuenta(resultado.getInt(4));
                return busCheque;
            }
        } catch (Exception e) {

        }
        return busCheque;
    }

    public Cheque modificarCheque(String descripcion, int cantidadPago, String fecha, int numeroCuenta) {
        Cheque modifica = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_modificarCheque(?,?,?,?)");
            proceso.setString(1, descripcion);
            proceso.setInt(2, cantidadPago);
            proceso.setString(3, fecha);
            proceso.setInt(4, numeroCuenta);
            proceso.execute();
        } catch (Exception e) {

        }
        return modifica;
    }

    public Cheque eliminarCheque(int numeroCuenta) {
        Cheque respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarCheque(?)");
            procedimiento.setInt(1, numeroCuenta);
            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public String registraDeposito(double deposita, String fecha, int numeroCui, int numeroCuenta) {
        String respuesta = null;
        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarDeposito(?,?,?,?)");
            proceso.setDouble(1, deposita);
            proceso.setString(2, fecha);
            proceso.setInt(3, numeroCui);
            proceso.setInt(4, numeroCuenta);

            int rs = proceso.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (Exception e) {

        }
        return respuesta;
    }

    public Deposito buscarDeposito(int numeroCui) {
        Deposito busDeposito = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL Sp_buscarDeposito(?)");
            proceso.setInt(1, numeroCui);

            ResultSet resultado = proceso.executeQuery();
            if (resultado.next()) {
                busDeposito = new Deposito();
                busDeposito.setDeposita(resultado.getDouble(1));
                busDeposito.setFecha(resultado.getString(2));
                busDeposito.setNumeroCui(resultado.getInt(3));
                busDeposito.setNumeroCuenta(resultado.getInt(4));
                return busDeposito;
            }
        } catch (Exception e) {

        }
        return busDeposito;
    }

    public Deposito EliminarDeposito(int numeroCui) {
        Deposito respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL Sp_eliminarDeposito(?)");
            procedimiento.setInt(1, numeroCui);
            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }
    public String registraRetiro(double retira, String fecha, int numeroCui, int numeroCuenta) {
        String respuesta = null;
        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarRetiro(?,?,?,?)");
            proceso.setDouble(1, retira);
            proceso.setString(2, fecha);
            proceso.setInt(3, numeroCui);
            proceso.setInt(4, numeroCuenta);

            int rs = proceso.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }
        } catch (Exception e) {

        }
        return respuesta;
    }
    public Retirar buscarRetiro(int numeroCui) {
        Retirar buscRetiro = null;

        try {
            PreparedStatement proceso = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarRetiro(?)");
            proceso.setInt(1, numeroCui);

            ResultSet resultado = proceso.executeQuery();
            if (resultado.next()) {
                buscRetiro = new Retirar();
                buscRetiro.setRetira(resultado.getDouble(1));
                buscRetiro.setFecha(resultado.getString(2));
                buscRetiro.setNumeroCui(resultado.getInt(3));
                buscRetiro.setNumeroCuenta(resultado.getInt(4));
                return buscRetiro;
            }
        } catch (Exception e) {

        }
        return buscRetiro;
    }
        public Retirar EliminarRetiro(int numeroCui) {
        Retirar respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_eliminarRetiro(?)");
            procedimiento.setInt(1, numeroCui);
            int rs = procedimiento.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public void generarReportePrestamo() {
        Map parametros = new HashMap();
        GenerarReportePrestamo.generarReporteUsers("reporteUsuario.jasper", parametros, "reporte usuarios");
    }
    public void generarReporteDeposito(){
         Map parametros = new HashMap();
        GenerarReportePrestamo.generarReporteUsers("reporteUsuario.jasper", parametros, "reporte Deposito");
    }
}
