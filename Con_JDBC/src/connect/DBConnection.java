/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Minority
 */
public class DBConnection {

    public static void connect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection con = null;
    
    public Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_mhs","root","");
            System.out.println("Koneki Berhasil");
        } catch (Exception e){
            System.out.println("Koneksi Gagal");
        }
        return con;
    }

   
}
