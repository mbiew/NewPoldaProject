/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mbiieww
 */
public class buatBarangBukti extends javax.swing.JFrame {

    Connection konek;
    
    public buatBarangBukti() {
        initComponents();
        
//        koneksi = SqliteKoneksi.connect();
        konek = koneksi.configDB();
    }

    
    public void tambahData(){
        
        String det = jtf1.getText();
        String kat = jtf2.getText();
        String jml = jtf3.getText();
        String ket = jta1.getText();
        
        try {
         Statement stmt = konek.createStatement();
            String query = "INSERT INTO tbl_barang_bukti (det_brg_bukti,kat_brg_bukti,jumlah,keterangan)"
                        +"VALUES ( '"+det+"','"+kat+"','"+jml+"','"+ket+"') ";
            System.out.println(query);
            int berhasil = stmt.executeUpdate(query);
            if (berhasil == 1) {
                JOptionPane.showMessageDialog(null, "Data Berhasil dimasukan");
                
            } else {
                JOptionPane.showMessageDialog(null, "Data Gagal dimasukan!");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan pada Database!");
        }
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf1.setBorder(null);
        jPanel1.add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 690, -1));

        jtf2.setBorder(null);
        jPanel1.add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 286, 690, 20));

        jtf3.setBorder(null);
        jtf3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf3KeyTyped(evt);
            }
        });
        jPanel1.add(jtf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 334, 690, 20));

        jta1.setColumns(20);
        jta1.setRows(5);
        jta1.setBorder(null);
        jScrollPane1.setViewportView(jta1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 690, 140));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 27_1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 670, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 15.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jtf1.getText().equals("") || jtf2.getText().equals("") || jtf3.getText().equals("")|| jta1.getText().equals(""))  {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
           
        } else  {
            
        tambahData();
        
        buatDataBersangkutan bdb = new buatDataBersangkutan();
        bdb.setVisible(true);
        this.dispose();
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtf3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf3KeyTyped
 
    }//GEN-LAST:event_jtf3KeyTyped

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
            java.util.logging.Logger.getLogger(buatBarangBukti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buatBarangBukti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buatBarangBukti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buatBarangBukti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatBarangBukti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta1;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JTextField jtf3;
    // End of variables declaration//GEN-END:variables
}
