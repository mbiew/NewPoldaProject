/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mbiieww
 */
public class SqliteKoneksi {

   
  
 
    public static Connection connect(){
        
        Connection koneksi = null;
        
       //untuk koneksi ke driver
       try{
           Class.forName("org.sqlite.JDBC");
           System.out.println("berhasil load driver");
       }catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null, "Tidak ada Driver!\n" + ex);
       }
 
       //untuk koneksi ke database
       try{
           String url;
           url = "jdbc:sqlite:polda.db";
           koneksi=DriverManager.getConnection(url);
           System.out.println("Berhasil koneksi");
       }catch(SQLException se){
           System.out.println("Gagal koneksi "+se);
           JOptionPane.showMessageDialog(null,"Gagal Koneksi Database","Peringatan",JOptionPane.WARNING_MESSAGE);
       }
       return koneksi;
    }
    
}
