/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Koneksi.Database;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;
import model.BuktiPesan;
/**
 *
 * @author User
 */
public class DAO_BuktiPesan implements Model_DAO<BuktiPesan> {
    Connection connection;
    public DAO_BuktiPesan(){
        connection = Database.KoneksiDB();
    }
    

    @Override
    public int autonumber(BuktiPesan object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    public void insert_detiltransaksi(BuktiPesan object) {
       PreparedStatement statement ;
       try{
           String INSERTDETIL = "INSERT INTO detil_pesan_2011500390(NoPesan, KdBrg, HrgPesan, JmlPesan) values (?,?,?,?)";
            statement =  connection.prepareStatement(INSERTDETIL);
             statement.setString(1, object.getNobp());
              statement.setString(2, object.getKodebarang());
              statement.setInt(3, object.getHarga());
              statement.setInt(4, object.getQty());
                statement.executeUpdate();
       }catch (Exception e){
    e.printStackTrace();
        }
       
    }
    
    public void update_stok(BuktiPesan object) {
     PreparedStatement statement ;
     int stok_akhir=0;
      try{
          String SELECT = "SELECT Stok from barang_2011500390 WHERE KdBrg=?";
            statement =  connection.prepareStatement(SELECT);
            statement.setString(1, object.getKodebarang());
             ResultSet rs = statement.executeQuery();
             if(rs.next()){
               if(rs.getInt("Stok")<0)
              {
                JOptionPane.showMessageDialog(null,"Stok Kode Barang :" +object.getKodebarang() + "Kosong");  
                stok_akhir = 0;
              }else{
                   stok_akhir = rs.getInt("Stok") -  object.getQty();
                     PreparedStatement statement2;
                     String UPDATESTOK= ("UPDATE  barang_2011500390 set Stok=? WHERE KdBrg=?");
                       statement2 = connection.prepareStatement(UPDATESTOK);
                          statement2.setInt(1, stok_akhir);
                          statement2.setString(2, object.getKodebarang());
                   statement2.executeUpdate();
               }
             }
          
          
      }catch (Exception e){
    e.printStackTrace();
        }
    }
    
    public String autonumber2(){
         PreparedStatement statement ;
         int nomor_berikutnya = 0;
         String urutan = "";
         try{
             String COUNTER = "SELECT ifnull(max(convert(right(NoPesan,5), signed integer)),0) as kode," 
                     + "ifnull(length(max(convert(right(NoPesan,5)+1,signed integer))),0)as panjang from buktipesan_2011500390";
             statement =  connection.prepareStatement(COUNTER);
              ResultSet rs2 = statement.executeQuery();
              if(rs2.next()){
                  nomor_berikutnya = rs2.getInt("kode")+1;
                  if(rs2.getInt("kode")!=0){
                      if(rs2.getInt("panjang") == 1){
                          urutan = "BP" + "0000" + nomor_berikutnya;
                      } if(rs2.getInt("panjang") == 2){
                          urutan = "BP" + "0000" + nomor_berikutnya;
                      } if(rs2.getInt("panjang") == 3){
                          urutan = "BP" + "0000" + nomor_berikutnya;
                      } if(rs2.getInt("panjang") == 4){
                          urutan = "BP" + "0000" + nomor_berikutnya;
                      } if(rs2.getInt("panjang") == 5){
                          urutan = "BP" + "0000" + nomor_berikutnya;
                      }
                  }else{
                      urutan = "BP" + "00001";
                  }
              }else{
                   JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan");
              }
                  
         }catch (Exception e){
    e.printStackTrace();
        }
         return urutan;
    }
    
    
    
    
    

    @Override
    public void delete(Integer kode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public List<BuktiPesan> isicomboplg() {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String TAMPILPELANGAN = "SELECT * FROM pelanggan_2011500390 order by NmPlg";
            statement =  connection.prepareStatement(TAMPILPELANGAN);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                BuktiPesan b = new BuktiPesan();
                b.setNamaplg(rs.getString("Nmplg"));
                list.add(b);
            }
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
    
    
    public List<BuktiPesan> getkdplg(String namaplg) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIPELANGAN2 = "SELECT * FROM pelanggan_2011500390 WHERE NmPlg=?";
            statement =  connection.prepareStatement(CARIPELANGAN2);
            statement.setString(1, namaplg);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                BuktiPesan b = new BuktiPesan();
                b.setKodeplg(rs.getInt("KdPlg"));
                list.add(b);
            }
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
    
    public List<BuktiPesan> getnmplg(Integer kode) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIPELANGGAN = "SELECT * FROM pelanggan_2011500390 WHERE KdPlg=?";
            statement =  connection.prepareStatement(CARIPELANGGAN);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
                  JOptionPane.showMessageDialog(null,"data tidak ditemukan");
                
            }else{
                 BuktiPesan b = new BuktiPesan();
                b.setNamaplg(rs.getString("NmPlg"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
        
    
    public List<BuktiPesan> isicombokategori() {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String TAMPILKATEGORI = "SELECT * FROM kategori_2011500390 order by NmKategori";
            statement =  connection.prepareStatement(TAMPILKATEGORI);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 BuktiPesan b = new BuktiPesan();
                b.setNamakategori(rs.getString("NmKategori"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
    public List<BuktiPesan> getkdkategori(String namakat) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIKATEGORI2 = "SELECT * FROM kategori_2011500390 WHERE NmKategori=?";
            statement =  connection.prepareStatement(CARIKATEGORI2);
            statement.setString(1, namakat);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 BuktiPesan b = new BuktiPesan();
                b.setKodekategori(rs.getInt("KdKategori"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
     public List<BuktiPesan> getnmkategori(Integer kode) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIKATEGORI = "SELECT * FROM kategori_2011500390 WHERE KdKategori=?";
            statement =  connection.prepareStatement(CARIKATEGORI);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"data tidak ditemukan");
            }
            else{
                 BuktiPesan b = new BuktiPesan();
                b.setNamakategori(rs.getString("NmKategori"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
     
     public List<BuktiPesan> isicombobarang(Integer kode) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String TAMPILBARANG = "SELECT * FROM barang_2011500390 WHERE KdKategori=? ORDER BY NmBrg";
            statement =  connection.prepareStatement(TAMPILBARANG);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 BuktiPesan b = new BuktiPesan();
                b.setNamabarang(rs.getString("NmBrg"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
     
       public List<BuktiPesan> isicombobarang2(String kode) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String TAMPILBARANG = "SELECT * FROM barang_2011500390 WHERE KdBrg=? ORDER BY NmBrg";
            statement =  connection.prepareStatement(TAMPILBARANG);
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 BuktiPesan b = new BuktiPesan();
                b.setNamabarang(rs.getString("NmBrg"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
    
       public List<BuktiPesan> getkdbrg(String namaplg) {
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIBARANG2 = "SELECT * FROM barang_2011500390 WHERE NmBrg=?";
            statement =  connection.prepareStatement(CARIBARANG2);
            statement.setString(1, namaplg);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                 BuktiPesan b = new BuktiPesan();
                b.setKodebarang(rs.getString("KdBrg"));
                b.setHarga(rs.getInt("HargaBrg"));
                b.setStok(rs.getInt("Stok"));
                list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }
       
       
       public List<BuktiPesan> getnmbarang(String kode) {
           int i = 0;
       PreparedStatement statement ;
       List<BuktiPesan> list = null;
       try{
           list = new ArrayList();
           String CARIBARANG = "SELECT a.*, b.* FROM barang_2011500390 a, kategori_2011500390 b WHERE a.KdKategori=b.KdKategori and KdBrg=?";
            statement =  connection.prepareStatement(CARIBARANG);
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();
            BuktiPesan b = new BuktiPesan();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"data tidak ditemukan");
                b.setKodekategori(0);
                b.setNamakategori("-pilih-");
                b.setKodebarang("");
                b.setNamabarang("");
                b.setHarga(0);
                b.setStok(0);
                list.add(b);
            }else{
                b.setKodekategori(rs.getInt("a.KdKategori"));
                b.setNamakategori(rs.getString("NmKategori"));
                b.setNamabarang(rs.getString("NmBrg"));
                b.setHarga(rs.getInt("HargaBrg"));
                b.setStok(rs.getInt("Stok"));
                 list.add(b);
            }
            
            
           
       }catch (Exception e){
    e.printStackTrace();
        }
       return list;
    }

    @Override
    public List<BuktiPesan> getCari(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     @Override
    public void insert(BuktiPesan object) {
        PreparedStatement statement;
        try{
            String SELECT = "SELECT * FROM buktipesan_2011500390 WHERE NoPesan=?";
            statement =  connection.prepareStatement(SELECT);
            statement.setString(1, object.getNobp());
            ResultSet rs = statement.executeQuery();
              if(rs.next())
              {
             JOptionPane.showMessageDialog(null,"data sudah pernah disimpan");
              }else{
                  PreparedStatement statement2;
                  String INSERT = "INSERT INTO buktipesan_2011500390 (NoPesan, TglPesan, KdPlg) VALUES (?, ?, ?)";
                  statement2 = connection.prepareStatement(INSERT);
                  statement2.setString(1, object.getNobp());
                  statement2.setString(2, object.getTglbp());
                  statement2.setInt(3, object.getKodeplg());
                  statement2.executeUpdate();
                   JOptionPane.showMessageDialog(null,"data berhasil disimpan");
              }
                
             
             
        }catch (Exception e){
    e.printStackTrace();
        }
        
    }


    @Override
    public void update(BuktiPesan object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BuktiPesan> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
