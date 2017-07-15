package controlador;

import DBaseDato.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public boolean autenticarse(String nombre, String password) {
       
        try {
            PreparedStatement procedimiento = Conexion.getInstancia().getConexion().prepareCall("SELECT empleado.`cui`,empleado.`nombre`,empleado.`apellidos`,empleado.`direccion`,empleado.`telefono`,empleado.`idAgencia`,empleado.`idrol`,empleado.`login`,empleado.`password` FROM empleado WHERE empleado.`login`=? AND empleado.`password`=?");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, password);
            ResultSet resultado = procedimiento.executeQuery();
            return resultado.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String autentica(String nombre, String password){
        String respuesta=null;
        try{
            PreparedStatement procedimiento=Conexion.getInstancia().getConexion().prepareCall("CALL SP_autenticarEmpleado(?,?)");
            procedimiento.setString(1, nombre);
            procedimiento.setString(2, password);
            procedimiento.execute();
            
            
            int rs=procedimiento.executeUpdate();
            if(rs>0){
                respuesta="busqueda exitosa";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return respuesta;
    }
}
