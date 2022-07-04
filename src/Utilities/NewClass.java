/* @author nghiacubu */


package Utilities;

import Entity.Ve;
import com.GUI.main.Main;
import java.util.Hashtable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class NewClass {
    public static void main(String[] args) throws JRException {
//        exportHoaDon("HD200");
        exportVe();
    }
    
    public static void exportHoaDon(String maHoaDon) throws JRException {
        Hashtable a = new Hashtable();
        JasperReport jasperReport = JasperCompileManager.compileReport("src/Utilities/HoaDon.jrxml");
        a.put("MaHoaDon", maHoaDon);
        JasperPrint p = JasperFillManager.fillReport(jasperReport, a, XJdbc.ConnectDB());
        JasperViewer.viewReport(p, false);
    }

    public static void exportVe() throws JRException {
        Hashtable a = new Hashtable();
            JasperReport jasperReport = JasperCompileManager.compileReport("src/Utilities/Ve.jrxml");
            a.put("MaVe", "ve651");
            JasperPrint p = JasperFillManager.fillReport(jasperReport, a, XJdbc.ConnectDB());
            JasperViewer.viewReport(p, false);
    }
}
