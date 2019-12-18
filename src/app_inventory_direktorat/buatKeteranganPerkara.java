/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mbiieww
 */
public class buatKeteranganPerkara extends javax.swing.JFrame {

    Connection konek;
    
    public buatKeteranganPerkara() {
        initComponents();
        
        konek = koneksi.configDB();
        
    }
    
    
    public void tambahData(){
        
        // Data Radio Button
        String immaterial = "";
        if (rb1.isSelected()) {
            immaterial = "Ada";
            
        } else if (rb2.isSelected()) {
            immaterial = "Tidak";
            
        }
        
        //Data Textfield
        
        String motif = jtf1.getText();
        String modus = jtf2.getText();
        String sasaran = jtf3.getText();
        String korban = jtf4.getText();
        String ringan = jtf5.getText();
        String berat = jtf6.getText();
        String materi = jtf7.getText();
        String uraian = jta1.getText();
        
         try {
            Statement stmt = konek.createStatement();
            String query = "INSERT INTO tbl_ket_perkara(motif_kejahatan,modus_operandi,sasaran_kejahatan,korban_jiwa,luka_ringan,luka_berat,kerugian_materi,kerugian_immaterial,uraian_kejadian)"
                        +"VALUES ( '"+motif+"','"+modus+"','"+sasaran+"','"+korban+"','"+ringan+"','"+berat+"','"+materi+"','"+immaterial+"','"+uraian+"') ";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        button = new javax.swing.JButton();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jtf4 = new javax.swing.JTextField();
        jtf5 = new javax.swing.JTextField();
        jtf6 = new javax.swing.JTextField();
        jtf7 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jta1 = new javax.swing.JTextArea();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 27_1.png"))); // NOI18N
        button.setText("jButton1");
        button.setBorder(null);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        jPanel1.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 970, 120, 40));

        jtf1.setBorder(null);
        jPanel1.add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 690, 20));

        jtf2.setBorder(null);
        jtf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf2ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 690, 20));

        jtf3.setBorder(null);
        jPanel1.add(jtf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 324, 690, 20));

        jtf4.setBorder(null);
        jtf4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf4KeyTyped(evt);
            }
        });
        jPanel1.add(jtf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 376, 610, 20));

        jtf5.setBorder(null);
        jtf5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf5KeyTyped(evt);
            }
        });
        jPanel1.add(jtf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 426, 610, 20));

        jtf6.setBorder(null);
        jtf6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf6KeyTyped(evt);
            }
        });
        jPanel1.add(jtf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 476, 610, 20));

        jtf7.setBorder(null);
        jtf7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtf7KeyTyped(evt);
            }
        });
        jPanel1.add(jtf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 610, 20));

        jta1.setColumns(20);
        jta1.setRows(5);
        jta1.setBorder(null);
        jScrollPane2.setViewportView(jta1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 630, 690, 230));

        buttonGroup1.add(rb1);
        rb1.setText(" Ya");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });
        jPanel1.add(rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 570, 70, -1));

        buttonGroup1.add(rb2);
        rb2.setText(" Tidak");
        jPanel1.add(rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 14.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf2ActionPerformed

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1ActionPerformed

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed

        if (jtf1.getText().equals("") || jtf2.getText().equals("") || jtf3.getText().equals("") || jtf7.getText().equals("")|| jta1.getText().equals(""))  {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
           
        } else  {
            
        tambahData();
        
        buatBarangBukti bbb = new buatBarangBukti();
        bbb.setVisible(true);
        this.dispose();
        } 
        
    }//GEN-LAST:event_buttonActionPerformed

    private void jtf4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf4KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf4KeyTyped

    private void jtf5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf5KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf5KeyTyped

    private void jtf6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf6KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf6KeyTyped

    private void jtf7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtf7KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_jtf7KeyTyped

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
            java.util.logging.Logger.getLogger(buatKeteranganPerkara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buatKeteranganPerkara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buatKeteranganPerkara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buatKeteranganPerkara.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatKeteranganPerkara().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    // End of variables declaration//GEN-END:variables
}
