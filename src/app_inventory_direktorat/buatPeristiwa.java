/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;


/**
 *
 * @author mbiieww
 */
public class buatPeristiwa extends javax.swing.JFrame {

    Connection konek;
    
    public buatPeristiwa() {
        initComponents();
        
//        konek = SqliteKoneksi.connect();
        
        konek = koneksi.configDB();

        itemPolda();
        itemProv();
        
        
    }
    
    public void tambahData(){
        
        //combobox
        String prov = (String) cmb1.getSelectedItem();
        String polda = (String) cmb2.getSelectedItem();
        
        
        //Textfield
        String tgl = jtf1.getText();
        String tmpt = jtf2.getText();
        String pol = jtf3.getText();
        String kot = jtf4.getText();
        String kec = jtf5.getText();
        String kel = jtf6.getText();
        String alamat = jta1.getText();
        String sek = jtf7.getText();
        
        
        try {
            
            String query = "INSERT INTO tbl_data_peristiwa(tgl_kejadian,tempat_kejadian,provinsi,kota,kecamatan,kelurahan,alamat,polda,polres,polsek)"
                        +"VALUES ( '"+tgl+"','"+tmpt+"','"+prov+"','"+kot+"','"+kec+"','"+kel+"','"+alamat+"','"+polda+"','"+pol+"','"+sek+"') ";
            
//            System.out.println(query);
//            int berhasil = stmt.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Penyimpanan Data Berhasil");
            java.sql.Connection con = (Connection)koneksi.configDB() ;
            java.sql.PreparedStatement pst = con.prepareStatement(query);
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        }
        
        
    }
    
    
    private void itemProv(){
        
        
        try {
            koneksi.configDB();
            Statement stmt = konek.createStatement();
            String query = "SELECT asal_provinsi FROM wilayah_hukum";
            ResultSet rs = stmt.executeQuery(query);
           cmb1.addItem("- Data Belum Terpilih -");
            while (rs.next()) {
                cmb1.addItem(rs.getString(1));
                
            }
            
        } catch (Exception ex) {
        }
        
        
        
    }
    
    
    private void itemPolda(){
        
        
        try {
            koneksi.configDB();
            Statement stmt = konek.createStatement();
            String query = "SELECT nama_polda FROM wilayah_hukum";
            ResultSet rs = stmt.executeQuery(query);
            cmb2.addItem("- Data Belum Terpilih -");
            while (rs.next()) {
                cmb2.addItem(rs.getString(1));
                
            }
            
        } catch (Exception ex) {
        }
        
        
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jtf1 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jtf4 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        jtf6 = new javax.swing.JTextField();
        jtf7 = new javax.swing.JTextField();
        cmb2 = new javax.swing.JComboBox<>();
        cmb1 = new javax.swing.JComboBox<>();
        jtf2 = new javax.swing.JTextField();
        jtf5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 27_1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 870, 120, 40));

        jtf1.setBorder(null);
        jPanel1.add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 700, 20));

        jtf3.setBorder(null);
        jtf3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf3ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 700, -1));

        jtf4.setBorder(null);
        jtf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf4ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 426, 700, 20));

        jta1.setColumns(20);
        jta1.setRows(5);
        jta1.setBorder(null);
        jScrollPane2.setViewportView(jta1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 530, 700, 70));

        jtf6.setBorder(null);
        jPanel1.add(jtf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 740, 700, -1));

        jtf7.setBorder(null);
        jtf7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf7ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 790, 700, 20));

        jPanel1.add(cmb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 690, 210, -1));

        cmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 328, 180, -1));

        jtf2.setBorder(null);
        jtf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf2ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 700, -1));

        jtf5.setBorder(null);
        jtf5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf5ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 700, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 13_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 960));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf3ActionPerformed

    private void jtf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf2ActionPerformed

    private void jtf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf4ActionPerformed

    private void jtf7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf7ActionPerformed

    private void cmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (jtf1.getText().equals("") || jtf2.getText().equals("") || jtf3.getText().equals("") || jtf4.getText().equals("") || jtf5.getText().equals("") || jtf6.getText().equals("") || jtf7.getText().equals("")|| jta1.getText().equals(""))  {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
           
        } else  {
            
        tambahData();
        
        buatKeteranganPerkara bkp = new buatKeteranganPerkara();
        bkp.setVisible(true);
        this.dispose();
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf5ActionPerformed

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
            java.util.logging.Logger.getLogger(buatPeristiwa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buatPeristiwa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buatPeristiwa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buatPeristiwa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatPeristiwa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JComboBox<String> cmb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jta1;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JTextField jtf3;
    private javax.swing.JTextField jtf4;
    private javax.swing.JTextField jtf5;
    private javax.swing.JTextField jtf6;
    private javax.swing.JTextField jtf7;
    // End of variables declaration//GEN-END:variables
}
