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
           
            String query1 = "SELECT id_penerimaLp, nama_penerima, nrp_penerima, pangkat_penerima, COUNT(`status`) AS 'Jumlah Kasus'\n" +
"FROM `tbl_penerima_lp`\n" +
"INNER JOIN `tbl_data_laporan` ON (`tbl_data_laporan`.`id_penerima_lp` = `tbl_penerima_lp`.`id_penerimaLp`)\n" +
"WHERE `tbl_data_laporan`.`status` = 'p21'\n" +
"GROUP BY id_penerima_lp";
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

        button = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1920, 1080));

        button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 6.png"))); // NOI18N
        button.setBorder(null);
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jTextField1.setBorder(null);

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
        jScrollPane1.setViewportView(table);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1366 – 2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1020, 1020, 1020)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(630, 630, 630)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        
            buatDataLp bdl = new buatDataLp();
            bdl.setVisible(true);
            this.dispose();
  
    }//GEN-LAST:event_buttonActionPerformed

  
    
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
    private javax.swing.JButton button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
