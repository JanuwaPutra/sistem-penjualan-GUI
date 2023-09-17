/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class Controller_LapStok {
    
    public void cetak(){
        try{
            Connection conn = Koneksi.Database.KoneksiDB();
            String reportPath = "src/Report/RepLapStok.jasper";
            JasperPrint print=JasperFillManager.fillReport(reportPath,null,conn);
            JasperViewer.viewReport(print);
            
           
             
        }catch(Exception ex){
              JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ ex.getMessage(),
                      "Cetak Data", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void cetak_excel(){
         try{
            Connection conn = Koneksi.Database.KoneksiDB();
            String path = "src/Report/RepLapStok.jasper";
            File xlxs = new File("C:\\Users\\User\\Documents\\TUGAS KULIAH(JANU)\\Semester 6\\Implementasi Pbo\\LAPORAN");
            JasperPrint print = JasperFillManager.fillReport(path, null,conn);

           
            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();
            Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE,xlxs);
            Xlsxexporter.exportReport();
             
        }catch(Exception ex){
              JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ ex.getMessage(),
                      "Cetak Data", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    
}
