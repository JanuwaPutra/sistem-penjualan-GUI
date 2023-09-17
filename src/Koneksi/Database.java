    
package Koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Database {
    static  Properties  mypanel;
    static String driver, database,user,pass; 
    static Connection conn;
        
    public static Connection KoneksiDB(){
        if(conn == null){
            try {
                mypanel = new Properties();
                mypanel.load(new FileInputStream("lib/database.ini"));
                driver    = mypanel.getProperty("DBDriver");
                database  =  mypanel.getProperty("DBDatabase");
                user  =  mypanel.getProperty("DBUsername");
                pass  =  mypanel.getProperty("DBPassword");
            
                Class.forName(driver).newInstance();
                conn = DriverManager.getConnection(database,user,pass);                
                JOptionPane.showMessageDialog(null,"Koneksi Berhasil!","Pesan",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {                
                JOptionPane.showMessageDialog(null,"Koneksi Tidak Berhasil!","Pesan",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Error : "+ex.getMessage());
            } 
        }
        return conn;
    }
}   