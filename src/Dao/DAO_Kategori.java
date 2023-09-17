/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;
import model.Kategori;
import Koneksi.Database;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import View.MPelanggan;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DAO_Kategori implements Model_DAO<Kategori>{
    
    public DAO_Kategori(){
        connection = Database.KoneksiDB();
    }
    
    Connection connection;
    
    String INSERT = "INSERT INTO kategori_2011500390 (`KdKategori`, `NmKategori`) VALUES (?,?)";
    String UPDATE = "UPDATE kategori_2011500390 SET NmKategori=? WHERE KdKategori=?";
    String DELETE = "DELETE FROM kategori_2011500390 WHERE KdKategori=?";
    String SELECT = "SELECT * FROM kategori_2011500390";
    String CARI   = "SELECT * FROM kategori_2011500390 WHERE KdKategori LIKE ?";
    String COUNTER = "SELECT max(KdKategori) AS Kode FROM kategori_2011500390";

    @Override
    public int autonumber(Kategori object) {
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
    public void insert(Kategori object) {
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
              statement2.setString(2, object.getNama());
             statement2.executeUpdate();
              JOptionPane.showMessageDialog(null,"data berhasil disimpan");
             }
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
    public void update(Kategori object) {
      PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setInt(2, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"data berhasil diubah");
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
    public void delete(Integer id) {
         PreparedStatement statement = null ;
      try{
          statement = connection.prepareStatement(DELETE);
          statement.setInt(1, id);
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
    public List<Kategori> getAll() {
         List<Kategori> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Kategori>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Kategori k = new Kategori();
                k.setKode(rs.getInt("KdKategori"));
                k.setNama(rs.getString("NmKategori"));
                   list.add(k);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Kategori> getCari(String key) {
       List<Kategori> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Kategori>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, "%"+key+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Kategori k = new Kategori();
                k.setKode(rs.getInt("KdKategori"));
                k.setNama(rs.getString("NmKategori"));
                   list.add(k);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    
    }
    
}
