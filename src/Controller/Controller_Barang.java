/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Barang;
import View.MBarang;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Barang;

/**
 *
 * @author User
 */
public class Controller_Barang {
    MBarang form;
    DAO_Barang model;
    List <Barang> list;
    String [] header;
    
    public Controller_Barang(MBarang form){
         this.form = form;
        model = new DAO_Barang();
        list = model.getAll();
        header = new String[]{"KODE BARANG", "NAMA BARANG","SATUAN","HARGA", "STOK", "KODE KATEGORI", "NAMA KATEGORI"};
        
        form.getTblbarang().setShowGrid(true);
        form.getTblbarang().setShowHorizontalLines(true);
        form.getTblbarang().setGridColor(Color.blue);
    }
    
    public void isicombokategori(){
        form.getCmbkategori().removeAllItems();
        form.getCmbkategori().addItem("-Pilih-");
        for(Barang B : model.IsiCombo()){
           form.getCmbkategori().addItem(B.getKodekategori());
        }
    }
    
    public void isicombosatuan(){
        form.getCmbsatuan().removeAllItems();
        form.getCmbsatuan().addItem("-Pilih-");
        form.getCmbsatuan().addItem("PCS");
        form.getCmbsatuan().addItem("DUS");
        form.getCmbsatuan().addItem("PAK");
        form.getCmbsatuan().addItem("BAL");
    }
    
    
    public void tampilurutankode(){
        if(form.getCmbkategori().getSelectedIndex() > 0){
            form.getTxtkdbarang().setText(String.valueOf(model.autonumber2(Integer.parseInt
        (form.getCmbkategori().getSelectedItem().toString()))));
        }
    }
    
    public void isiTable() {
        list = model.getAll();
        
       DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header){
           public boolean isCellEditable (int rowIndex, int columnIndex){
               return false;
                       }
       };
       
               
Object[] data = new Object[header.length];
for(Barang B : list){
data[0] = B.getKodebarang();
data[1] = B.getNamabarang();
data[2] = B.getSatuan();
data[3] = B.getHarga();
data[4] = B.getStok();
data[5] = B.getKodekategori();
data[6] = B.getNamakategori();
tblModel.addRow(data);
}
    form.getTblbarang().setModel(tblModel);
}
    
    
    public void reset(){
        form.getCmbkategori().setSelectedIndex(0);
        form.getTxtnmkategori().setText("");
        form.getTxtkdbarang().setText("");
        form.getTxtnmbarang().setText("");
        form.getCmbsatuan().setSelectedIndex(0);
        form.getTxtharga().setText("");
        form.getTxtstok().setText("");
        form.getTxtkatakunci().setText("");
        form.getTxtnmbarang().requestFocus();
        form.getTxtnmkategori().setEditable(false);
        form.getTxtkdbarang().setEditable(false);
        isicombokategori();
        isicombosatuan();
        tampilurutankode();
        isiTable();
    }
    
    public void isiField(int row){
        form.getCmbkategori().setSelectedItem(list.get(row).getKodekategori());
        form.getTxtnmkategori().setText(list.get(row).getNamakategori());
        form.getTxtkdbarang().setText(list.get(row).getKodebarang());
        form.getTxtnmbarang().setText(list.get(row).getNamabarang());
        form.getCmbsatuan().setSelectedItem(list.get(row).getSatuan());
        form.getTxtharga().setText(String.valueOf(list.get(row).getHarga()));
        form.getTxtstok().setText(String.valueOf(list.get(row).getStok()));
    }
    
    public void insert(){
        if(!form.getTxtkdbarang().getText().trim().isEmpty() && !form.getTxtkdbarang().getText().trim().isEmpty()&& !form.getTxtnmbarang().getText().trim().isEmpty()
                && !form.getTxtharga().getText().trim().isEmpty()  && !form.getTxtnmkategori().getText().trim().isEmpty()&&
                 !form.getTxtstok().getText().trim().isEmpty() && form.getCmbkategori().getSelectedIndex() !=0 &&
               form.getCmbsatuan().getSelectedIndex() !=0 ){
        Barang B = new Barang();
        B.setKodebarang(form.getTxtkdbarang().getText());
        B.setNamabarang(form.getTxtnmbarang().getText());
        B.setSatuan(form.getCmbsatuan().getSelectedItem().toString());
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
         B.setStok(Integer.parseInt(form.getTxtstok().getText()));
         B.setKodekategori(form.getCmbkategori().getSelectedItem().toString());
         model.insert(B);
          }else{
          JOptionPane.showMessageDialog(form,"Tidak Boleh Kosong");
        }
    }
    
    public void update(){
         Barang B = new Barang();
         if(!form.getTxtkdbarang().getText().trim().isEmpty() && !form.getTxtnmbarang().getText().trim().isEmpty()
                && !form.getTxtharga().getText().trim().isEmpty()  && !form.getTxtnmkategori().getText().trim().isEmpty()&&
                 !form.getTxtstok().getText().trim().isEmpty() && form.getCmbkategori().getSelectedIndex() !=0&&
               form.getCmbsatuan().getSelectedIndex() !=0 ){
        B.setNamabarang(form.getTxtnmbarang().getText());
        B.setSatuan(form.getCmbsatuan().getSelectedItem().toString());
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
         B.setStok(Integer.parseInt(form.getTxtstok().getText()));
         B.setKodekategori(form.getCmbkategori().getSelectedItem().toString());
         B.setKodebarang(form.getTxtkdbarang().getText());
         model.update(B);
          }else{
          JOptionPane.showMessageDialog(form,"Pilih data yang akan diubah");
        }
    }
    
    public void delete(){
         if(!form.getTxtkdbarang().getText().trim().isEmpty() &&  !form.getTxtnmbarang().getText().trim().isEmpty()
                && !form.getTxtharga().getText().trim().isEmpty()  && !form.getTxtnmkategori().getText().trim().isEmpty()&&
                 !form.getTxtstok().getText().trim().isEmpty() && form.getCmbkategori().getSelectedIndex() !=0 &&
               form.getCmbsatuan().getSelectedIndex() !=0  ){
            String id = (form.getTxtkdbarang().getText());
            model.delete(id);
        }else{
          JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus");
        }
}
    
     public void isiTableCari(){
        list = model.getCari(form.getTxtkatakunci().getText().trim());
         DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header);
         Object[] data = new Object[header.length];
         for(Barang B : list){
data[0] = B.getKodebarang();
data[1] = B.getNamabarang();
data[2] = B.getSatuan();
data[3] = B.getHarga();
data[4] = B.getStok();
data[5] = B.getKodekategori();
data[6] = B.getNamakategori();
tblModel.addRow(data);
}
    form.getTblbarang().setModel(tblModel);
    }
     
     public void tampilnamakategori(){
         if(form.getCmbkategori().getSelectedIndex()!=0){
             for(Barang b : model.getDataKategori(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()))){
                form.getTxtnmkategori().setText(b.getNamakategori());
             }
             
         }
     }
     
     
     
     
     
     
}
