package controlador;

import DBaseDato.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Deposito;
import modelo.OrdenProducto;
import modelo.Retirar;

public class ClienteIndividualController {

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

    public String registrarOrdenProducto(int idProducto, int numeroCuenta) {
        String respuesta = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_registrarOrdenProducto(?,?)");
            procedimiento.setInt(1, idProducto);
            procedimiento.setInt(2, numeroCuenta);
            int rs = procedimiento.executeUpdate();

            if (rs > 0) {
                respuesta = "dato registrado";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public OrdenProducto buscarOrdenProducto(int numeroCuenta) {
        OrdenProducto busc = null;
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("CALL SP_buscarOrdenProducto(?)");
            procedimiento.setInt(1, numeroCuenta);

            ResultSet resultado = procedimiento.executeQuery();
            if (resultado.next()) {
                busc = new OrdenProducto();
                busc.setIdProductos(resultado.getInt(1));
                busc.setNumeroCuenta(resultado.getInt(2));
                
                return busc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return busc;
    }
}
