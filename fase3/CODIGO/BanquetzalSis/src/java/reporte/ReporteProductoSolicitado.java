package reporte;

import DBaseDato.Conexion;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteProductoSolicitado {
    public static void generarReporteProducto(String nombreReporte, Map parametros, String titulo){
        InputStream reporte=GenerarReportePrestamo.class.getResourceAsStream("productoSolicitado.jasper");
        JasperReport generadorReporte=null;
        try{
            generadorReporte=(JasperReport)JRLoader.loadObject(reporte);
            JasperPrint reporteSalida=JasperFillManager.fillReport(generadorReporte, parametros,Conexion.getInstancia().getConexion());
            JasperViewer vista=new JasperViewer(reporteSalida,false);
            vista.setTitle(titulo);
            vista.setVisible(true);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
