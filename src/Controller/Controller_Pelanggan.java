/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.DAO_Pelanggan;
import Dao.Model_DAO;
import View.MPelanggan;
import java.awt.Color;

import javax.swing.table.DefaultTableModel;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pelanggan;

/**
 *
 * @author User
 */
public class Controller_Pelanggan {
    MPelanggan form;
    Model_DAO<Pelanggan> model;
    List<Pelanggan> list;
    String[] header;
    
    public Controller_Pelanggan(MPelanggan form){
        this.form = form;
        model = new DAO_Pelanggan();
        list = model.getAll();
        header = new String[]{"KODE", "NAMA PELANGAN","ALAMAT","TELEPON"};
        
        form.getTblplg().setShowGrid(true);
        form.getTblplg().setShowHorizontalLines(true);
        form.getTblplg().setGridColor(Color.blue);
    }
    public void tampilurutankode(){
        Pelanggan p = new Pelanggan();
        model.autonumber(p);
        form.getTxtkdplg().setText(String.valueOf(model.autonumber(p)));
        
    }
    public void reset(){
        form.getTxtkdplg().setText("");
        form.getTxtnmplg().setText("");
        form.getTxtalamat().setText("");
        form.getTxttelp().setText("");
        form.getTxtnmplg().requestFocus();
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
for(Pelanggan p : list){
data[0] = p.getKode();
data[1] = p.getNama();
data[2] = p.getAlamat();
data[3] = p.getTelp();
tblModel.addRow(data);
}
    form.getTblplg().setModel(tblModel);
}
    
    public void isiField(int row){
        form.getTxtkdplg().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtnmplg().setText(list.get(row).getNama());
        form.getTxtalamat().setText(list.get(row).getAlamat());
        form.getTxttelp().setText(list.get(row).getTelp());
    }
    
    public void insert(){
       Pelanggan p = new Pelanggan();
        if(!form.getTxtkdplg().getText().trim().isEmpty()&& !form.getTxtnmplg().getText().trim().isEmpty()&&
                !form.getTxtalamat().getText().trim().isEmpty() && !form.getTxttelp().getText().trim().isEmpty()){
           p.setKode(Integer.parseInt(form.getTxtkdplg().getText()));
           p.setNama(form.getTxtnmplg().getText());
            p.setAlamat(form.getTxtalamat().getText());
             p.setTelp(form.getTxttelp().getText());
             
             model.insert(p);
              }else{
             JOptionPane.showMessageDialog(form,"Tidak Boleh Kosong");
            }
           
       }
    
    public void update(){
         Pelanggan p = new Pelanggan();
          if(!form.getTxtkdplg().getText().trim().isEmpty()&& !form.getTxtnmplg().getText().trim().isEmpty()&&
                !form.getTxtalamat().getText().trim().isEmpty() && !form.getTxttelp().getText().trim().isEmpty()){
           p.setKode(Integer.parseInt(form.getTxtkdplg().getText()));
           p.setNama(form.getTxtnmplg().getText());
            p.setAlamat(form.getTxtalamat().getText());
             p.setTelp(form.getTxttelp().getText());
             
             model.update(p);
             }else{
             JOptionPane.showMessageDialog(form,"Pilih data yang akan diubah");
            }
    }
    
    public void delete(){
       if(!form.getTxtkdplg().getText().trim().isEmpty()&& !form.getTxtnmplg().getText().trim().isEmpty()&&
                !form.getTxtalamat().getText().trim().isEmpty() && !form.getTxttelp().getText().trim().isEmpty()){
        int kode = Integer.parseInt(form.getTxtkdplg().getText());
        model.delete(kode);
    }else{
             JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus");
            }
    }
    
    public void isiTableCari(){
        list = model.getCari(form.getTxtkdplg().getText().trim());
         DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header);
         Object[] data = new Object[header.length];
         for(Pelanggan p : list){
data[0] = p.getKode();
data[1] = p.getNama();
data[2] = p.getAlamat();
data[3] = p.getTelp();
tblModel.addRow(data);
}
    form.getTblplg().setModel(tblModel);
    }
    
    
    
    
    }



