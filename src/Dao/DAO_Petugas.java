/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Koneksi.Database;
import java.util.List;
import model.Petugas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DAO_Petugas implements Model_DAO <Petugas> {
    
     public DAO_Petugas(){
        connection = Database.KoneksiDB();
     }
     
      Connection connection;
    String INSERT = "INSERT INTO petugas_2011500390 (`KdPetugas`, `NmPetugas`, `AlamatPetugas`, `TelpPetugas`) VALUES (?,?,?,?);";
    String UPDATE = "UPDATE petugas_2011500390 SET NmPetugas=?, AlamatPetugas=?, TelpPetugas=? WHERE KdPetugas=?";
    String DELETE = "DELETE FROM petugas_2011500390 WHERE KdPetugas=?";
    String SELECT = "SELECT * FROM petugas_2011500390";
    String CARI = "SELECT * FROM petugas_2011500390 WHERE KdPetugas LIKE ? OR NmPetugas LIKE ?";
    String COUNTER = "SELECT max(KdPetugas) AS Kode FROM petugas_2011500390";

    @Override
    public int autonumber(Petugas object) {
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
    public void insert(Petugas object) {
        PreparedStatement statement = null ;
     try{
         statement =  connection.prepareStatement(CARI);
         statement.setInt(1, object.getKode());
         statement.setString(2, object.getNama());
         ResultSet rs = statement.executeQuery();
         if(rs.next())
             JOptionPane.showMessageDialog(null,"data sudah pernah disimpan");
     else{
             PreparedStatement statement2 = null ;
             statement2 = connection.prepareStatement(INSERT);
             statement2.setInt(1, object.getKode());
              statement2.setString(2, object.getNama());
              statement2.setString(3, object.getAlamat());
              statement2.setString(4, object.getTelp()); 
             statement2.executeUpdate();
              JOptionPane.showMessageDialog(null,"data berhasil disimpan");
             }
    }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    }

    @Override
    public void update(Petugas object) {
        PreparedStatement statement = null ;
        try{
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setString(2, object.getAlamat());
            statement.setString(3, object.getTelp());
            statement.setInt(4, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null,"data berhasil diubah");
        }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE,null,ex);
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
        Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    }

    @Override
    public List<Petugas> getAll() {
        List<Petugas> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Petugas>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Petugas p = new Petugas();
                p.setKode(rs.getInt("KdPetugas"));
                p.setNama(rs.getString("NmPetugas"));
                 p.setAlamat(rs.getString("AlamatPetugas"));
                   p.setTelp(rs.getString("TelpPetugas"));
                   list.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
        
    }

    @Override
    public List<Petugas> getCari(String key) {
       List<Petugas> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Petugas>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, "%"+key+"%");
            statement.setString(2, "%"+key+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Petugas p = new Petugas();
                p.setKode(rs.getInt("KdPetugas"));
                p.setNama(rs.getString("NmPetugas"));
                 p.setAlamat(rs.getString("AlamatPetugas"));
                   p.setTelp(rs.getString("TelpPetugas"));
                   list.add(p);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
