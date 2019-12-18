/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mbiieww
 */
public class buatPenerimaLp extends javax.swing.JFrame {

    Connection konek;
    
    public buatPenerimaLp() {
        initComponents();
        
//        koneksi = SqliteKoneksi.connect();
    
        konek =koneksi.configDB();

        itemPangkat();
        
    }
    
    
     public void tambahData(){
        
          // Jenis Combobox
        String pgktPenerima = (String) cmb1.getSelectedItem();
        String pgktSiaga = (String) cmb2.getSelectedItem();
         
        String nmPenerima = jtf1.getText();
        String nrpPenerima = jtf2.getText();
        String nmSiaga = jtf3.getText();
        String nrpSiaga = jtf4.getText();
        
        try {
         Statement stmt = konek.createStatement();
            String query = "INSERT INTO tbl_penerima_lp (nama_penerima,pangkat_penerima,nrp_penerima,nama_perwira_siaga,pangkat_perwira_siaga,nrp_perwira_siaga)"
                        +"VALUES ( '"+nmPenerima+"','"+pgktPenerima+"','"+nrpPenerima+"','"+nmSiaga+"','"+pgktSiaga+"','"+nrpSiaga+"') ";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil dimasukan");
              //** UPDATE id_penerima_lp di    tbl_data_laporan */
                updateTblDataLaporan(getIdOfLatestLaporan(), getIdOfLatestPenerima());
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal dimasukan!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        }
    }
     
     //************************************* UPDATE LAPORAN **************************************************************/
    public void updateTblDataLaporan(int tmpIdLaporan, int tmpIdPenerima) {
        int idDataLaporan = tmpIdLaporan; 
        int idPenerimaLP = tmpIdPenerima;

        try {
            Statement stmt = konek.createStatement();
            String query = "UPDATE tbl_data_laporan SET id_penerima_lp = idPenerimaLP.toString() WHERE id_data_laporan = + idDataLaporan.toString()";
            int berhasil = stmt.executeUpdate(query);

            if (berhasil == 1) {
                System.out.println("Data Laporan Updated");
            } else {
                System.out.println("Failed to update Data Laporan");
            }
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        } 
    }
    
    public int getIdOfLatestLaporan() {
//        Statement stmt = konek.createStatement();
//        String query = "SELECT MAX(id_data_laporan) FROM tbl_data_laporan";
//        ResultSet result = stmt.executeQuery(query);
//        result.first();
        try {
            Statement stmt = konek.createStatement();
            String query = "SELECT MAX(id_data_laporan) FROM tbl_data_laporan";
            ResultSet result = stmt.executeQuery(query);
            result.first();
            return result.getInt(0); 
           
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        } 
        return 0;
         
    }
        
    public int getIdOfLatestPenerima() {
        
        try {
            
            Statement stmt = konek.createStatement();
        String query = "SELECT MAX(id_penerimaLp) FROM tbl_penerima_lp";
        ResultSet result = stmt.executeQuery(query);
        result.first();
        
        return result.getInt(0);
            
        } catch (Exception e) {
            
             e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
            
        }
        return 0;
        
    }
    //************************************* UPDATE LAPORAN **************************************************************/
    

    
    
     private void itemPangkat(){
         
         try {
             
             koneksi.configDB();
             Statement stmt = konek.createStatement();
             String query = "SELECT nama_pangkat FROM tbl_pangkat";
             ResultSet rs = stmt.executeQuery(query);
             cmb1.addItem("Pilih Pangkat");
             cmb2.addItem("Pilih Pangkat");
             while (rs.next()) {                 
                 cmb1.addItem(rs.getString(1));
                 cmb2.addItem(rs.getString(1));
             }
         } catch (Exception e) {
         }
         
     }
     
      public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jtf4 = new javax.swing.JTextField();
        cmb1 = new javax.swing.JComboBox<>();
        cmb2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 775, -1, -1));

        jtf1.setBorder(null);
        getContentPane().add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, 690, 20));

        jtf2.setBorder(null);
        jtf2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf2KeyTyped(evt);
            }
        });
        getContentPane().add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 690, 20));

        jtf3.setBorder(null);
        getContentPane().add(jtf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 690, -1));

        jtf4.setBorder(null);
        jtf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf4KeyTyped(evt);
            }
        });
        getContentPane().add(jtf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 690, 20));

        getContentPane().add(cmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 150, -1));

        cmb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb2ActionPerformed(evt);
            }
        });
        getContentPane().add(cmb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 150, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 98.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 670, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 12.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         if (jtf1.getText().equals("") || jtf2.getText().equals("") || jtf3.getText().equals("")|| jtf4.getText().equals(""))  {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
           
        } else  {
            
        tambahData();
        
        menu_utama mu = new menu_utama();
        mu.setVisible(true);
        this.dispose();
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf2KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf2KeyTyped

    private void jtf4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf4KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf4KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(buatPenerimaLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buatPenerimaLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buatPenerimaLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buatPenerimaLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatPenerimaLp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JComboBox<String> cmb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JTextField jtf3;
    private javax.swing.JTextField jtf4;
    // End of variables declaration//GEN-END:variables
}
