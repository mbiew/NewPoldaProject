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
public class buatDataLp extends javax.swing.JFrame {

    Connection konek; 
    
    public buatDataLp() {
        initComponents();
        
//        koneksi = SqliteKoneksi.connect();
        konek = koneksi.configDB();
            
        itemStatus();
    }

    
                           
        
   
         public void tambahData(){
             
             
         String modelLp = "";
             if (jrb1.isSelected()) {
            modelLp = "A";
        } else if(jrb2.isSelected()) {
            modelLp = "B";
        }
        
        String ktgrPelaku = "";
        if(jrb3.isSelected()){
            ktgrPelaku = "Dilaporkan";
        }else if(jrb4.isSelected()){
            ktgrPelaku = "Tangkap Tangan";
        }
        
        String stat = (String) cmb1.getSelectedItem();
        
        String noLp = jtf1.getText();
        String tglLp = jtf2.getText();
        
        try {
            Statement stmt = konek.createStatement();
            String query = "INSERT INTO tbl_data_laporan(model_laporan,kategori_pelaku,no_laporan,status,tanggal)"
                         +"VALUES('"+modelLp+"','"+ktgrPelaku+"','"+noLp+"','"+stat+"','"+tglLp+"')";
            System.out.println(query);
            
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil dimasukan");
                
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal dimasukan!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        }finally{
            try {
                konek.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
                       
    }
        
         private void itemStatus(){
        
        
        
        try {
        konek = koneksi.configDB();
        Statement stt = konek.createStatement();
        String sql = "select daftar_status from status";     
        ResultSet res = stt.executeQuery(sql);                               
        
        cmb1.addItem("- Data Belum Terpilih -");
        
        while(res.next()){
            Object[] ob = new Object[3];
            ob[0] = res.getString(1);
            
            cmb1.addItem((String) ob[0]);                                      // fungsi ini bertugas menampung isi dari database
        }
        res.close(); stt.close();
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jrb1 = new javax.swing.JRadioButton();
        jrb2 = new javax.swing.JRadioButton();
        jrb3 = new javax.swing.JRadioButton();
        jrb4 = new javax.swing.JRadioButton();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        cmb1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jrb1.setText(" A");
        jrb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrb1ActionPerformed(evt);
            }
        });
        jPanel1.add(jrb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        jrb2.setText(" B");
        jPanel1.add(jrb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, -1, -1));

        jrb3.setText("Dilaporkan");
        jPanel1.add(jrb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        jrb4.setText("Tangkap Tangan");
        jPanel1.add(jrb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, -1, -1));

        jtf1.setBorder(null);
        jtf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf1KeyTyped(evt);
            }
        });
        jPanel1.add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 690, 30));

        jtf2.setBorder(null);
        jPanel1.add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 432, 690, 30));

        cmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 160, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 27_1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1189, 695, 110, 30));

        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 9_4.png"))); // NOI18N
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrb1ActionPerformed

    private void jtf1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf1KeyTyped

  FilterAngka(evt);
    }//GEN-LAST:event_jtf1KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        if (jtf1.getText().equals("") || jtf2.getText().equals("")) {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
            
        } else {
            
             tambahData();
        
        buatDataPelaporr bdp = new buatDataPelaporr();
        bdp.setVisible(true);
        this.dispose();
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb1ActionPerformed

    }//GEN-LAST:event_cmb1ActionPerformed

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
            java.util.logging.Logger.getLogger(buatDataLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buatDataLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buatDataLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buatDataLp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatDataLp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jrb1;
    private javax.swing.JRadioButton jrb2;
    private javax.swing.JRadioButton jrb3;
    private javax.swing.JRadioButton jrb4;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
