/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author mbiieww
 */
public class menu_utama extends javax.swing.JFrame {

    Connection tersambung;
    DefaultTableModel model = new DefaultTableModel();
    int baris;
    
    public menu_utama() {
        initComponents();
        
//    tersambung = SqliteKoneksi.connect();
    tersambung = koneksi.configDB();
    loadTable();
 
    }

    public void loadTable(){
        int no = 1;
        
        model.addColumn("No");
        model.addColumn("ID Anggota");
        model.addColumn("Nama Anggota");
        model.addColumn("NRP");
        model.addColumn("Pangkat");
        model.addColumn("Jumlah Kasus");
        
        try {
//            String query1 = "SELECT nama_anggota, nrp, nama_pangkat, COUNT(tbl_det_laporan.id_anggota) AS jumlah_kasus FROM tbl_anggota, tbl_pangkat, tbl_det_laporan WHERE (tbl_anggota.id_pangkat = tbl_pangkat.id_pangkat) AND (tbl_det_laporan.id_anggota = tbl_anggota.id_anggota) GROUP BY tbl_anggota.id_anggota";
           
            String query1 = "SELECT id_penerimaLp, nama_penerima, nrp_penerima, pangkat_penerima, COUNT(`status`) AS 'Jumlah Kasus' FROM `tbl_penerima_lp` INNER JOIN `tbl_data_laporan` ON (`tbl_data_laporan`.`id_penerima_lp` = `tbl_penerima_lp`.`id_penerimaLp`) WHERE `tbl_data_laporan`.`status` = 'p21' GROUP BY nama_penerima";
            java.sql.Connection con = (Connection) koneksi.configDB();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query1);
            while (res.next()) {
                String ia = res.getString("id_penerimaLp");
                String na = res.getString("nama_penerima");
                String nrp = res.getString("nrp_penerima");
                String pkt = res.getString("pangkat_penerima");
                String jk = res.getString("Jumlah Kasus");
                
                
                model.addRow(new Object[]{no++,ia,na,nrp,pkt,jk});
                
                
            }
            
            table.setModel(model);
            
        } catch (Exception e) {
            
            e.printStackTrace();
        
        }finally{
            try {
                tersambung.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 1270, 470));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 114.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1119, 125, 170, 30));

        jTextField1.setBorder(null);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 50, 780, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 117.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 2_4.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          
        String id = (String) table.getValueAt(bariss, 1);
        DetailKasus kasus = new DetailKasus(id);
        kasus.setVisible(true);       
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        buatDataLp bdl = new buatDataLp();
        bdl.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
 int bariss;
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
   bariss = table.getSelectedRow();
    }//GEN-LAST:event_tableMouseClicked

  
    
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
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
