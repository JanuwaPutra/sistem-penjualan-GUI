/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.util.List;
import model.Barang;
import Koneksi.Database;
import java.sql.Connection;
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
public class DAO_Barang implements Model_DAO<Barang> {
    public DAO_Barang(){
        connection = Database.KoneksiDB();
    }
    Connection connection;
    String INSERT = "INSERT INTO barang_2011500390(KdBrg, NmBrg, Satuan, HargaBrg, Stok, KdKategori) values (?,?,?,?,?,?)";
    String UPDATE = "UPDATE barang_2011500390 SET NmBrg=?, Satuan = ?, HargaBrg = ?, Stok =?, KdKategori=? WHERE KdBrg=?";
    String DELETE = "DELETE FROM barang_2011500390 WHERE KdBrg=?";
    String SELECT = "SELECT a.*, b.* FROM barang_2011500390 a, kategori_2011500390 b WHERE a.KdKategori = b.KdKategori order by KdBrg";
    String CARI   = "SELECT a.*, b.* FROM barang_2011500390 a, kategori_2011500390 b WHERE a.KdKategori = b.KdKategori and KdBrg like ?";
    String CARIKATEGORI = "SELECT * FROM kategori_2011500390 WHERE KdKategori=?";
    String COMBO = "SELECT KdKategori FROM kategori_2011500390 order by convert(right(KdKategori,2),signed integer)";
    String COUNTER = "SELECT ifnull(max(convert(right(KdBrg,2),signed integer)),0) as kode," 
                      + "ifnull(length(max(convert(right(KdBrg,2),signed integer))),0) as panjang "
                      + "FROM barang_2011500390 WHERE KdKategori =?";
    
    @Override
    public int autonumber(Barang object) {
      return 0;
    }

    @Override
    public void insert(Barang object) {
       PreparedStatement statement = null ;
     try{
         statement =  connection.prepareStatement(CARI);
         statement.setString(1, object.getKodebarang());
         ResultSet rs = statement.executeQuery();
         if(rs.next())
             JOptionPane.showMessageDialog(null,"data sudah pernah disimpan");
     else{
             PreparedStatement statement2 = null ;
             statement2 = connection.prepareStatement(INSERT);
             statement2.setString(1, object.getKodebarang());
              statement2.setString(2, object.getNamabarang());
              statement2.setString(3, object.getSatuan());
              statement2.setInt(4, object.getHarga()); 
               statement2.setInt(5, object.getStok()); 
                statement2.setString(6, object.getKodekategori()); 
             statement2.executeUpdate();
              JOptionPane.showMessageDialog(null,"data berhasil disimpan");
             }
    }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    }

    @Override
    public void update(Barang object) {
        PreparedStatement statement = null ;
     try{
         statement =  connection.prepareStatement(CARI);
         statement.setString(1, object.getKodebarang());
         ResultSet rs = statement.executeQuery();
         if(rs.next()){
             statement = connection.prepareStatement(UPDATE);
             
              statement.setString(1, object.getNamabarang());
              statement.setString(2, object.getSatuan());
              statement.setInt(3, object.getHarga()); 
               statement.setInt(4, object.getStok()); 
                statement.setString(5, object.getKodekategori()); 
                statement.setString(6, object.getKodebarang());
             statement.executeUpdate();
              JOptionPane.showMessageDialog(null,"data berhasil disimpan");

         }else{
                        
             JOptionPane.showMessageDialog(null,"data sudah pernah disimpan");
             }
    }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,ex);
    }
}
    }

    
    public void delete(String id) {
        PreparedStatement statement = null ;
      try{
          statement = connection.prepareStatement(DELETE);
          statement.setString(1, id);
          statement.executeUpdate();
          JOptionPane.showMessageDialog(null,"data berhasil dihapus");
      }catch (Exception e){
    e.printStackTrace();
}finally{
    try{
        statement.close();
    }catch (SQLException ex){
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE,null,ex);
    }
    }
    }

    @Override
    public List<Barang> getAll() {
         List<Barang> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Barang>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Barang b = new Barang();
                b.setKodebarang(rs.getString("KdBrg"));
                b.setNamabarang(rs.getString("NmBrg"));
                b.setSatuan(rs.getString("Satuan"));
                b.setHarga(rs.getInt("HargaBrg"));
                 b.setStok(rs.getInt("Stok"));
                  b.setKodekategori(rs.getString("a.KdKategori"));
                   b.setNamakategori(rs.getString("NmKategori"));
                   list.add(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Barang> getCari(String key) {
         List<Barang> list = null;
        PreparedStatement statement = null ;
        try{
            list = new ArrayList<Barang>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, "%"+key+"%");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Barang b = new Barang();
                b.setKodebarang(rs.getString("KdBrg"));
                b.setNamabarang(rs.getString("NmBrg"));
                b.setSatuan(rs.getString("Satuan"));
                b.setHarga(rs.getInt("HargaBrg"));
                 b.setStok(rs.getInt("Stok"));
                  b.setKodekategori(rs.getString("a.KdKategori"));
                   b.setNamakategori(rs.getString("NmKategori"));
                   list.add(b);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void delete(Integer kode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String autonumber2(Integer id){
        PreparedStatement statement = null ;
        int nomor_berikutnya = 0;
        String urutan ="";
        try{
            statement = connection.prepareStatement(COUNTER);
            statement.setInt(1, id);
            ResultSet rs2 = statement.executeQuery();
            if(rs2.next()){
                nomor_berikutnya = rs2.getInt("kode")+1;
                if(rs2.getInt("kode")!= 0){
                    if(rs2.getInt("panjang") == 1){
                        urutan = "B" +id + "0" + nomor_berikutnya;
                    }else if(rs2.getInt("panjang")== 2){
                         urutan = "B" + id + nomor_berikutnya;
                    }
                }else{
                    urutan = "B" + id + "01";
                }
            }else{
                JOptionPane.showMessageDialog(null,"data tidak ditemukan");
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }
        return urutan;
         
        
    }
    
    public List <Barang> IsiCombo(){
         PreparedStatement statement = null ;
         List<Barang> list = null;
         try{
             list = new ArrayList<Barang>();
            statement = connection.prepareStatement(COMBO);
            ResultSet rs = statement.executeQuery();
             while(rs.next()){
                 Barang b = new Barang();
                 b.setKodekategori(rs.getString("KdKategori"));
                    list.add(b);
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         return list;
    }
   
    public List<Barang> getDataKategori(Integer id){
        PreparedStatement statement = null ;
        List<Barang> list = null;
         try{
             list = new ArrayList<Barang>();
            statement = connection.prepareStatement(CARIKATEGORI);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
             while(rs.next()){
                 Barang b = new Barang();
                 b.setNamakategori(rs.getString("NmKategori"));
                    list.add(b);
             }
         }catch(Exception e){
             e.printStackTrace();
         }
         return list;
        
        
        
    }
    
}
