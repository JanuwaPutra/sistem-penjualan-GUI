/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Dao.DAO_BuktiPesan;
import Koneksi.Database;
import View.TBuktiPesan;
import java.sql.Connection;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BuktiPesan;
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
public class Controller_BuktiPesan {
    TBuktiPesan form;
    DAO_BuktiPesan model;
    
    String[] header = new String[] {"KODE KATEGORI", "NAMA KATEGORI", "KODE BARANG", "NAMA BARANG", "HARGA", "QTY","TOTAL"};
    DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header){
        
         @Override
         public boolean isCellEditable(int rowIndex, int columnIndex){
             return false;
         }
    };
    
    public Controller_BuktiPesan(TBuktiPesan form){
        this.form = form;
        model = new DAO_BuktiPesan();
        form.getTbldetil().setModel(tblModel);
         form.getTbldetil().setShowGrid(true);
          form.getTbldetil().setShowVerticalLines(true);
           form.getTbldetil().setGridColor(Color.blue);
    }
    
    public void tampilurutankode(){
        form.getTxtnobp().setText(model.autonumber2());
    }
    
    public void reset(){
        SimpleDateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
        form.getTxttglbp().setText(String.valueOf(tgl.format(new Date())));
        
        form.getTxttotal().setText("Rp. 0");
        form.getCmbpelanggan().setSelectedIndex(0);
        form.getCmbkategori().setSelectedIndex(0);
        form.getCmbbarang().setSelectedIndex(0);
        form.getTxtkdplg().setText("");
        form.getTxtkdbrg().setText("");
        form.getTxtkdkategori().setText("");
        form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");
        
        tampilurutankode();
        isicombopelanggan();
        isicombokategori();
        tblModel.setRowCount(0);
        form.getTxtkdplg().requestFocus();
        form.getTxtnobp().setEditable(false);
        form.getTxttglbp().setEditable(false);
        form.getTxtstok().setEditable(false);
    }
    
    public void reset2(){
    form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");
         form.getTxtkdplg().requestFocus();
          form.getTxtstok().setEditable(false);
         
}
    public void reset3(){
         form.getCmbkategori().setSelectedIndex(0);
        form.getCmbbarang().setSelectedIndex(0);
        form.getTxtkdbrg().setText("");
        form.getTxtkdkategori().setText("");
        form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");
        form.getTxtkdkategori().requestFocus();
    }
    
    public void resetrow(){
        int[] selectedRows = form.getTbldetil().getSelectedRows();
        if(selectedRows.length > 0){
            for(int i = selectedRows.length - 1; i>=0; i--){
                tblModel.removeRow(selectedRows[i]);
            }
        }
        form.getTxtkdbrg().requestFocus();
    }
    
    
    
    public void isiTable(){
        int jmlbaris = tblModel.getRowCount();
        int i = 0;
        int datasama =0;
        int stok=1;
        
        if((form.getTxtqty().getText().isEmpty()==true)|| 
                (Integer.parseInt(form.getTxtqty().getText()) > Integer.parseInt(form.getTxtstok().getText()))){
            JOptionPane.showMessageDialog(null,"Quantity / Jumlah tidak boleh kosong atau melebihi stok tersedia!");
            stok = 0;
        
    }
        
        if(!form.getTxtkdkategori().getText().isEmpty() && stok >0){
            if(jmlbaris == 0){
                tblModel.addRow(new Object[]{
                    form.getTxtkdkategori().getText(),
                    form.getCmbkategori().getSelectedItem().toString(),
                    form.getTxtkdbrg().getText(),
                    form.getCmbbarang().getSelectedItem().toString(),
                    form.getTxtharga().getText(),
                    form.getTxtqty().getText(),
                    (Integer.parseInt(form.getTxtharga().getText())*Integer.parseInt(form.getTxtqty().getText()))     
                });
            }else{
                for(i = 0; i<jmlbaris; i++){
                    if(form.getTxtkdbrg().getText().equals(tblModel.getValueAt(i, 2).toString())){
                    datasama = 1;
                      JOptionPane.showMessageDialog(null,"Kode Barang " + tblModel.getValueAt(i, 2).toString()+ "Sudah pernah ada, dan akan diupdate dengan data terbaru.");
                      
                    tblModel.setValueAt(form.getTxtkdkategori().getText(),i,0);
                     tblModel.setValueAt(form.getCmbkategori().getSelectedItem().toString(),i ,1);
                      tblModel.setValueAt(form.getTxtkdbrg().getText(), i, 2);
                       tblModel.setValueAt(form.getCmbbarang().getSelectedItem().toString(),i, 3);
                        tblModel.setValueAt(form.getTxtharga().getText(),i, 4);
                         tblModel.setValueAt(form.getTxtqty().getText(),i, 5);
                          tblModel.setValueAt((Integer.parseInt(form.getTxtharga().getText()) 
                                  * Integer.parseInt(form.getTxtqty().getText())),i, 6);
                          
                          break;
                }else{
                        datasama = 0;
                        }
                }
            
            
            if(datasama == 0 ){
                tblModel.addRow(new Object[]{
                    form.getTxtkdkategori().getText(),
                     form.getCmbkategori().getSelectedItem().toString(),
                    form.getTxtkdbrg().getText(),
                    form.getCmbbarang().getSelectedItem().toString(),
                    form.getTxtharga().getText(),
                    form.getTxtqty().getText(),
                    (Integer.parseInt(form.getTxtharga().getText())*Integer.parseInt(form.getTxtqty().getText()))     
                });
            }
        }
    }
    }
    
    public void hitung_grandtotal(){
        int jmlbaris = tblModel.getRowCount();
        int total = 0;
        int Amount = 0;
        DecimalFormat konversi = new DecimalFormat("###,###,###.00");
        for(int i =0; i< tblModel.getRowCount(); i++){
            Amount = Integer.parseInt(String.valueOf(tblModel.getValueAt(i,6).toString()));
            total = Amount+total;
        }
        
        if(jmlbaris !=0){
            form.getTxttotal().setText("Rp. " + konversi.format(Integer.parseInt(String.valueOf(total))));
        }else{
            form.getTxttotal().setText("RP. 0");
        }
    }   
    
    public void isiField(int row){
        form.getTxtkdkategori().setText(String.valueOf(tblModel.getValueAt(row, 0)));
        form.getCmbkategori().setSelectedItem(tblModel.getValueAt(row, 1));
        form.getTxtkdbrg().setText(tblModel.getValueAt(row, 2).toString());
        form.getCmbbarang().setSelectedItem(tblModel.getValueAt(row, 3));
        form.getTxtharga().setText(String.valueOf(tblModel.getValueAt(row, 4)));
        form.getTxtqty().setText(String.valueOf(tblModel.getValueAt(row, 5)));
        
    }

    private void isicombopelanggan() {
       form.getCmbpelanggan().removeAllItems();
       form.getCmbpelanggan().addItem("-pilih-");
       for(BuktiPesan b : model.isicomboplg()){
           form.getCmbpelanggan().addItem(b.getNamaplg());
       }
    }
    
    public void tampilkdplg(){
        if(form.getCmbpelanggan().getSelectedIndex() !=0){
            for(BuktiPesan b : model.getkdplg(form.getCmbpelanggan().getSelectedItem().toString())){
                form.getTxtkdplg().setText(String.valueOf(b.getKodeplg()));
            }
        }
    }
    
    public void tampilnmplg(){
        for(BuktiPesan b : model.getnmplg(Integer.parseInt(form.getTxtkdplg().getText()))){
            form.getCmbpelanggan().setSelectedItem(b.getNamaplg());
        }
    }

    private void isicombokategori() {
       form.getCmbkategori().removeAllItems();
       form.getCmbkategori().addItem("-pilih-");
      for(BuktiPesan b : model.isicombokategori()){
          form.getCmbkategori().addItem(b.getNamakategori());
      }
       
    }
    
    public void tampilkdkategori(){
        if(form.getCmbkategori().getSelectedIndex()!=0){
            for(BuktiPesan b : model.getkdkategori(form.getCmbkategori().getSelectedItem().toString())){
                form.getTxtkdkategori().setText(String.valueOf(b.getKodekategori()));
            }
        }
    }
    
    public void tampilnmkategori(){
        for(BuktiPesan b : model.getnmkategori(Integer.parseInt(form.getTxtkdkategori().getText()))){
            form.getCmbkategori().setSelectedItem(b.getNamakategori());
            
            
        }
    }
    
    public void isicombobarang(){
        form.getCmbbarang().removeAllItems();
        form.getCmbbarang().addItem("-Pilih-");
        for(BuktiPesan b : model.isicombobarang(Integer.parseInt(form.getTxtkdkategori().getText()))){
            form.getCmbbarang().addItem(b.getNamabarang());
        }
    }
    
    public void isicombobarang2(){
        form.getCmbbarang().removeAllItems();
        form.getCmbbarang().addItem("-Pilih-");
        for(BuktiPesan b : model.isicombobarang2(form.getTxtkdbrg().getText())){
            form.getCmbbarang().addItem(b.getNamabarang());
            form.getCmbbarang().setSelectedItem(b.getNamabarang());
        }
    }
    
    public void tampilkdbarang(){
        if(form.getCmbkategori().getSelectedIndex() !=0){
            for(BuktiPesan b : model.getkdbrg(form.getCmbbarang().getSelectedItem().toString())){
                form.getTxtkdbrg().setText(String.valueOf(String.valueOf(b.getKodebarang())));
                  form.getTxtharga().setText(String.valueOf(String.valueOf(b.getHarga())));
                    form.getTxtstok().setText(String.valueOf(String.valueOf(b.getStok())));
            }
        }
    }
    
    public void tampilnmbarang(){
          for(BuktiPesan b : model.getnmbarang(form.getTxtkdbrg().getText())){
              form.getCmbbarang().setSelectedItem(b.getNamabarang());
              form.getCmbkategori().setSelectedItem(b.getNamakategori());
              form.getTxtkdkategori().setText(String.valueOf(b.getKodekategori()));
              form.getTxtharga().setText(String.valueOf(b.getHarga()));
              form.getTxtstok().setText(String.valueOf(b.getStok()));
              
              if(b.getKodebarang().equals("")){
                  form.getTxtkdbrg().setText("");
              }
          }
    }
    
    public void simpan_transaksi(){
        BuktiPesan B = new BuktiPesan();
        B.setNobp(form.getTxtnobp().getText());
        B.setTglbp(form.getTxttglbp().getText());
        B.setKodeplg(Integer.parseInt(form.getTxtkdplg().getText()));
        model.insert(B);
    }
    
    public void simpan_detiltransaksi(){
        int jmlbaris = tblModel.getRowCount();
        int simpan = 0;
        int i =0;
        for(i = 0; i< jmlbaris; i++){
            BuktiPesan B = new BuktiPesan();
            
            B.setNobp(form.getTxtnobp().getText());
            B.setKodebarang(tblModel.getValueAt(i,2).toString());
            B.setHarga(Integer.parseInt(tblModel.getValueAt(i,4).toString()));
            B.setQty(Integer.parseInt(tblModel.getValueAt(i,5).toString()));
            model.insert_detiltransaksi(B);
            model.update_stok(B);
            simpan=simpan+1;
        }
        if(simpan>0){
             JOptionPane.showMessageDialog(null,"Detil Belanja Berhasil Disimpan dan Stok barang sudah diubah ");
        }
    }
    
    public void cetak(){
        try{
            Connection conn = Koneksi.Database.KoneksiDB();
            String path = "C:\\Users\\User\\Documents\\TUGAS KULIAH(JANU)\\Semester 6\\Implementasi Pbo\\Pertemuan 2\\SistemPenjualan_2011500390\\src\\Report\\RepBuktiPesan.jasper";
            HashMap parameter = new HashMap();
            parameter.put("nops", (form.getTxtnobp().getText()));

            JasperPrint print=JasperFillManager.fillReport(path,parameter,conn);
            JasperViewer.viewReport(print);
            
            OutputStream output = new FileOutputStream(new File("C:/Users/User/Documents/TUGAS KULIAH(JANU)/Semester 6/Implementasi Pbo"+ (form.getTxtnobp().getText())+".pdf"));
            JasperExportManager.exportReportToPdfStream(print, output);
            
            File xlsx = new File("C:/Users/User/Documents/TUGAS KULIAH(JANU)/Semester 6/Implementasi Pbo" + (form.getTxtnobp().getText())+".xlsx");
            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();
            Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE,xlsx);
            Xlsxexporter.exportReport();
             
        }catch(Exception ex){
              JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ ex.getMessage(),
                      "Cetak Data", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}

