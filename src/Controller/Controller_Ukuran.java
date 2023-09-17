/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Dao.DAO_Ukuran;
import View.Mukuran;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ukuran;

/**
 *
 * @author User
 */
public class Controller_Ukuran {
    Mukuran form;
    DAO_Ukuran model;
    List <Ukuran> list;
    String [] header;
    
    public Controller_Ukuran(Mukuran form){
         this.form = form;
        model = new DAO_Ukuran();
        list = model.getAll();
        header = new String[]{"Kode Ukuran", "Ukuran"};
        
        form.getTblukuran().setShowGrid(true);
        form.getTblukuran().setShowHorizontalLines(true);
        form.getTblukuran().setGridColor(Color.blue);
    }
    
    public void tampilurutankode(){
        Ukuran u = new Ukuran();
        model.autonumber(u);
        form.getTxtkdukuran().setText(String.valueOf(model.autonumber(u)));
        
    }
    
    
     public void reset(){
        form.getTxtkdukuran().setText("");
        form.getTxtukuran().setText("");
        form.getTxtkdukuran().requestFocus();
        isiTable();
    }

    private void isiTable() {
        
        list = model.getAll();
        
       DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header){
           public boolean isCellEditable (int rowIndex, int columnIndex){
               return false;
                       }
       };
        
Object[] data = new Object[header.length];
for(Ukuran u : list){
data[0] = u.getKode();
data[1] = u.getUkuran();

tblModel.addRow(data);
}
    form.getTblukuran().setModel(tblModel);
       
    }
      public void isiField(int row){
        form.getTxtkdukuran().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtukuran().setText(list.get(row).getUkuran());
    }
      
      public void insert(){
       Ukuran u = new Ukuran();
        if(!form.getTxtkdukuran().getText().trim().isEmpty()&& !form.getTxtukuran().getText().trim().isEmpty()){
           u.setKode(Integer.parseInt(form.getTxtkdukuran().getText()));
           u.setUkuran(form.getTxtukuran().getText());
         
             
             model.insert(u);
              }else{
             JOptionPane.showMessageDialog(form,"Tidak Boleh Kosong");
            }
           
       }
      
       public void update(){
          Ukuran u = new Ukuran();
           if(!form.getTxtkdukuran().getText().trim().isEmpty()&& !form.getTxtukuran().getText().trim().isEmpty()){
            u.setKode(Integer.parseInt(form.getTxtkdukuran().getText()));
           u.setUkuran(form.getTxtukuran().getText());
         
           
             model.update(u);
             }else{
             JOptionPane.showMessageDialog(form,"Pilih data yang akan diubah");
            }
    }
       
       public void delete(){
      if(!form.getTxtkdukuran().getText().trim().isEmpty()&& !form.getTxtukuran().getText().trim().isEmpty()){
        int kode = Integer.parseInt(form.getTxtkdukuran().getText());
        model.delete(kode);
    }else{
             JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus");
            }
    }
       
       public void isiTableCari(){
        list = model.getCari(form.getTxtkdukuran().getText().trim());
         DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{},header);
         Object[] data = new Object[header.length];
         for(Ukuran u : list){
data[0] = u.getKode();
data[1] = u.getUkuran();
tblModel.addRow(data);
}
    form.getTblukuran().setModel(tblModel);
    }
     
}
