/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import model.Ukuran;
import Koneksi.Database;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DAO_Ukuran implements Model_DAO<Ukuran> {
    
    public DAO_Ukuran(){
        connection = Database.KoneksiDB();
    }
     Connection connection;
     
     String INSERT = "INSERT INTO ukuran_2011500390 (`Kdukuran`, `Ukuran`) VALUES (?,?)";
    String UPDATE = "UPDATE ukuran_2011500390 SET Ukuran=? WHERE Kdukuran=?";
    String DELETE = "DELETE FROM ukuran_2011500390 WHERE Kdukuran=?";
    String SELECT = "SELECT * FROM ukuran_2011500390";
    String CARI   = "SELECT * FROM ukuran_2011500390 WHERE Kdukuran LIKE ?";
    String COUNTER = "SELECT max(Kdukuran) AS Kode FROM ukuran_2011500390";

    @Override
    public int autonumber(Ukuran object) {
         PreparedStatement statement = null ;
       int nomor = 0;
       try{
           statement = connection.prepareStatement(COUNTER);
           ResultSet rs = statement.executeQuery();
           if(rs.next()){
               nomor=rs.getInt("Kode")+1;
               
           }
               
       }catch (Exception e){
           e.printStackTrace();
       }
    return nomor;
        
        
    }

    @Override
    public void insert(Ukuran object) {
        PreparedStatement statement = null ;
     try{
         statement =  connection.prepareStatement(CARI);
         statement.setInt(1, object.getKode());
         ResultSet rs = statement.executeQuery();
         if(rs.next())
             JOptionPane.showMessageDialog(null,"data sudah pernah disimpan");
     else{
             PreparedStatement statement2 = null ;
             statement2 = connection.prepareStatement(INSERT);
             statement2.setInt(1, object.getKode());
              statement2.setString(2, object.getUkuran());
             statement2.executeUpdate();
              JOptionPane.showMessageDialog(null,"data berhasil disimpan");
             }
    }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Ukuran.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    }

    @Override
    public void update(Ukuran object) {
       PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getUkuran());
            statement.setInt(2, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"data berhasil diubah");
        }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Ukuran.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    }

    @Override
    public void delete(Integer kode) {
         PreparedStatement statement = null ;
      try{
          statement = connection.prepareStatement(DELETE);
          statement.setInt(1, kode);
          statement.executeUpdate();
          JOptionPane.showMessageDialog(null,"data berhasil dihapus");
      }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    }

    @Override
    public List<Ukuran> getAll() {
        List<Ukuran> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Ukuran>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ukuran u = new Ukuran();
                u.setKode(rs.getInt("Kdukuran"));
                u.setUkuran(rs.getString("Ukuran"));
                   list.add(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Ukuran> getCari(String key) {
        List<Ukuran> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Ukuran>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, "%"+key+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Ukuran u = new Ukuran();
                u.setKode(rs.getInt("Kdukuran"));
                u.setUkuran(rs.getString("ukuran"));
                   list.add(u);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
