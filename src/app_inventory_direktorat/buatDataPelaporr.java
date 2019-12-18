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
public class buatDataPelaporr extends javax.swing.JFrame {

    Connection konek;
    
    public buatDataPelaporr() {
        initComponents();
        
        konek = koneksi.configDB();
        itemIdentitas();
        itemPendidikan();
        
    }
    
    
    public void tambahData(){
        
        // Data Radio Button
        String statusPelapor = "";
        if (rb1.isSelected()) {
            statusPelapor = "Diri Sendiri";
            
        } else if (rb2.isSelected()) {
            statusPelapor = "Kuasa dari";
            
        }
        
        
        String j_kelamin = "";
        if (rb3.isSelected()) {
            j_kelamin = "Laki Laki";
            
        } else if (rb4.isSelected()){
            j_kelamin = "Perempuan";
            
        }
        
        String kewarganegaraan = "";
        if (rb5.isSelected()) {
            kewarganegaraan = "WNA";
            
        } else if (rb6.isSelected()) {
            kewarganegaraan = "WNI";
            
        }
        
        
        // Jenis Combobox
        String identitas = (String) cmb1.getSelectedItem();
        String pendidikan = (String) cmb2.getSelectedItem();
        
        
        // Data text field
        String no_identitas = tf1.getText();
        String nm_lengkap = tf2.getText();
        String tmpt_lahir = tf3.getText();        
        String tgl_lahir = tf4.getText();
        String nm_ibu = tf5.getText();
        String nm_bapa = tf6.getText();
        String nm_alias = tf7.getText();
        String agama = tf8.getText();
        String pekerjaan = tf9.getText();
        String nm_negara = tf10.getText();
        String no_telepon = tf11.getText();
        String email = tf12.getText();
        
        try {
            Statement stmt = konek.createStatement();
            String query = "INSERT INTO tbl_data_pelapor (status_pelapor,jenis_identitas,no_identitas,nama_lengkap,tempat_lahir,tgl_lahir,jenis_kelamin,nama_ibu,nama_bapak,nama_alias,agama,pendidikan,pekerjaan,kewarganegaraan,nama_negara,no_telepon,alamat_email)"
                        + "VALUES ( '"+statusPelapor+"','"+identitas+"','"+no_identitas+"','"+nm_lengkap+"','"+tmpt_lahir+"','"+tgl_lahir+"','"+j_kelamin+"','"+nm_ibu+"','"+nm_bapa+"','"+nm_alias+"','"+agama+"','"+pendidikan+"','"+pekerjaan+"','"+kewarganegaraan+"','"+nm_negara+"','"+no_telepon+"','"+email+"')";
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
    
    
     private void itemIdentitas(){
        
        try {
            
            koneksi.configDB();
            Statement stmt = konek.createStatement();
            String query = "SELECT identitas FROM jenis_identitas";
            ResultSet rs = stmt.executeQuery(query);
            cmb1.addItem("Pilih Jenis Identitas");
            while (rs.next()){
                cmb1.addItem(rs.getString(1));
                
            }
        } catch (Exception e) {
            
        }
        
    }
     
     private void itemPendidikan(){
         
         try {
             
             koneksi.configDB();
             Statement stmt = konek.createStatement();
             String query = "SELECT pendidikan_akhir FROM pendidikan";
             ResultSet rs = stmt.executeQuery(query);
             cmb2.addItem("Pilih Pendidikan Terakhir");
             while (rs.next()) {                 
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        cmb1 = new javax.swing.JComboBox<>();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        cmb2 = new javax.swing.JComboBox<>();
        rb5 = new javax.swing.JRadioButton();
        rb6 = new javax.swing.JRadioButton();
        btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        tf6 = new javax.swing.JTextField();
        tf7 = new javax.swing.JTextField();
        tf8 = new javax.swing.JTextField();
        tf10 = new javax.swing.JTextField();
        tf11 = new javax.swing.JTextField();
        tf12 = new javax.swing.JTextField();
        tf9 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rb1);
        rb1.setText(" Diri Sendiri");
        rb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb1ActionPerformed(evt);
            }
        });
        jPanel1.add(rb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 107, -1));

        buttonGroup1.add(rb2);
        rb2.setText(" Kuasa dari");
        jPanel1.add(rb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 107, -1));

        jPanel1.add(cmb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 250, 30));

        buttonGroup2.add(rb3);
        rb3.setText("Laki Laki");
        rb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb3ActionPerformed(evt);
            }
        });
        jPanel1.add(rb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        buttonGroup2.add(rb4);
        rb4.setText("Perempuan");
        jPanel1.add(rb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, -1, -1));

        jPanel1.add(cmb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 760, 240, -1));

        buttonGroup3.add(rb5);
        rb5.setText(" WNA");
        rb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb5ActionPerformed(evt);
            }
        });
        jPanel1.add(rb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 860, -1, -1));

        buttonGroup3.add(rb6);
        rb6.setText(" WNI");
        rb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb6ActionPerformed(evt);
            }
        });
        jPanel1.add(rb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 860, -1, -1));

        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 27_1.png"))); // NOI18N
        btn.setBorder(null);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        jPanel1.add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 1110, 140, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 44.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 210, -1));

        tf1.setBorder(null);
        tf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf1KeyTyped(evt);
            }
        });
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 700, 20));

        tf2.setBorder(null);
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 700, 20));

        tf3.setBorder(null);
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 700, 20));

        tf4.setBorder(null);
        jPanel1.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 700, -1));

        tf5.setBorder(null);
        jPanel1.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 558, 700, -1));

        tf6.setBorder(null);
        tf6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf6ActionPerformed(evt);
            }
        });
        jPanel1.add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 700, -1));

        tf7.setBorder(null);
        jPanel1.add(tf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 660, 700, -1));

        tf8.setBorder(null);
        jPanel1.add(tf8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 710, 700, -1));

        tf10.setBorder(null);
        jPanel1.add(tf10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 916, 690, 20));

        tf11.setBorder(null);
        tf11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf11KeyTyped(evt);
            }
        });
        jPanel1.add(tf11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 960, 690, 30));

        tf12.setBorder(null);
        tf12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf12ActionPerformed(evt);
            }
        });
        jPanel1.add(tf12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 1010, 690, 30));

        tf9.setBorder(null);
        jPanel1.add(tf9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 802, 690, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Rectangle 66.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 800, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 11_3.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb1ActionPerformed

    private void rb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb3ActionPerformed

    private void rb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb5ActionPerformed

    private void rb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb6ActionPerformed

    private void tf12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf12ActionPerformed

    private void tf6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf6ActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
 
        if (tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("") || tf7.getText().equals("")|| tf8.getText().equals("")|| tf9.getText().equals("")|| tf10.getText().equals("")|| tf11.getText().equals("") )  {
            
            JOptionPane.showMessageDialog(null,"Masukan Data Terlebih Dahulu","Terjadi Kesalahan",JOptionPane.ERROR_MESSAGE);
            return;
           
        } else  {
            
        tambahData();
        
        buatAlamatPelapor bap = new buatAlamatPelapor();
        bap.setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_btnActionPerformed

    private void tf1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf1KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_tf1KeyTyped

    private void tf11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf11KeyTyped
 FilterAngka(evt);
    }//GEN-LAST:event_tf11KeyTyped

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buatDataPelaporr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JComboBox<String> cmb2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    private javax.swing.JRadioButton rb5;
    private javax.swing.JRadioButton rb6;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf10;
    private javax.swing.JTextField tf11;
    private javax.swing.JTextField tf12;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    private javax.swing.JTextField tf8;
    private javax.swing.JTextField tf9;
    // End of variables declaration//GEN-END:variables
}
