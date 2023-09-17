/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.DAO_Kategori;
import Dao.Model_DAO;
import View.MKategoriBarang;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Kategori;
/**
 *
 * @author User
 */
public class Controller_Kategori {
    MKategoriBarang form;
    Model_DAO<Kategori> model;
    List <Kategori> list;
    String [] header;
   
    
    public Controller_Kategori(MKategoriBarang form){
        this.form = form;
        model = new DAO_Kategori();
        list = model.getAll();
        header = new String[]{"KODE Kategori", "NAMA Kategori"};
        
        form.getTblkategori().setShowGrid(true);
        form.getTblkategori().setShowHorizontalLines(true);
        form.getTblkategori().setGridColor(Color.blue);
    }
     public void tampilurutankode(){
         Kategori k = new Kategori();
         model.autonumber(k);
         form.getTxtkdkategori().setText(String.valueOf(model.autonumber(k)));
     }
     
     
     
     public void reset(){
        form.getTxtkdkategori().setText("");
        form.getTxtnmkategori().setText("");
        form.getTxtnmkategori().requestFocus();
        isiTable();
    }

     public void isiTable() {
       list = model.getAll();
        
       DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header){
           public boolean isCellEditable (int rowIndex, int columnIndex){
               return false;
                       }
       };
        Object[] data = new Object[header.length];
    for(Kategori k : list){
    data[0] = k.getKode();
    data[1] = k.getNama();
    tblModel.addRow(data);
}
    form.getTblkategori().setModel(tblModel);
    }
    
    public void isiField(int row){
            form.getTxtkdkategori().setText(String.valueOf(list.get(row).getKode()));
            form.getTxtnmkategori().setText(list.get(row).getNama());
        }   
     public void insert(){
       Kategori k = new Kategori();
        if(!form.getTxtkdkategori().getText().trim().isEmpty()&& !form.getTxtnmkategori().getText().trim().isEmpty()){
           k.setKode(Integer.valueOf(form.getTxtkdkategori().getText()));
           k.setNama(form.getTxtnmkategori().getText());
             
             model.insert(k);
              }else{
             JOptionPane.showMessageDialog(form,"Tidak Boleh Kosong");
            }
     }
 public void update(){
       Kategori k = new Kategori();
        if(!form.getTxtkdkategori().getText().trim().isEmpty()&& !form.getTxtnmkategori().getText().trim().isEmpty()){
           k.setKode(Integer.valueOf(form.getTxtkdkategori().getText()));
           k.setNama(form.getTxtnmkategori().getText());
             
             model.update(k);
              }else{
             JOptionPane.showMessageDialog(form,"Tidak Boleh Kosong");
            }
        
 }
    public void delete(){
        if(!form.getTxtkdkategori().getText().trim().isEmpty()&& !form.getTxtnmkategori().getText().trim().isEmpty()){
        int id = Integer.parseInt(form.getTxtkdkategori().getText());
        model.delete(id);
    }else{
             JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus");
            }
    }
 
  public void isiTableCari(){
        list = model.getCari(form.getTxtkdkategori().getText().trim());
         DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header);
         Object[] data = new Object[header.length];
         for(Kategori k : list){
data[0] = k.getKode();
data[1] = k.getNama();
tblModel.addRow(data);
}
    form.getTblkategori().setModel(tblModel);
    }
    
}
