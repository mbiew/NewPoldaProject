/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mbiieww
 */
public class koneksi {
    
    public static Connection configDB(){
       String[] dataKoneksi = koneksi.readSettings();
        
        String host = dataKoneksi[0];
        String port = dataKoneksi[1];
        String username = dataKoneksi[2];
        String password = dataKoneksi[3];
        String db = dataKoneksi[4];
            
        
        String konString = "jdbc:mysql://" + host + ":" + port
                + "/" + db;
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(konString,username, password);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Koneksi Database Error");
            koneksi = null;
        }
        return koneksi;
    }

    public static String[] readSettings() {
        String[] data = new String[5];
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader("data//database.polda");
            br = new BufferedReader(fr);

            String sCurrentLine;
            
            int i = 0;
            while ((sCurrentLine = br.readLine()) != null) {
                 data[i] = sCurrentLine;  
                 i++;
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Setting Tidak ditemukan");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    };
    
    
}
