/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_inventory_direktorat;

/**
 *
 * @author mbiieww
 */
public class UpdateDetailKasus extends javax.swing.JDialog {

    /**
     * Creates new form DetailKasus
     */
    public UpdateDetailKasus(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jtf4 = new javax.swing.JTextField();
        jtf5 = new javax.swing.JTextField();
        jtf6 = new javax.swing.JTextField();
        jtf7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtf1.setBorder(null);
        jPanel1.add(jtf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 132, 480, 30));

        jtf2.setBorder(null);
        jtf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf2ActionPerformed(evt);
            }
        });
        jPanel1.add(jtf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 480, 30));

        jtf3.setBorder(null);
        jPanel1.add(jtf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 480, 30));

        jtf4.setBorder(null);
        jPanel1.add(jtf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 480, 20));

        jtf5.setBorder(null);
        jPanel1.add(jtf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 450, 480, 20));

        jtf6.setBorder(null);
        jPanel1.add(jtf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 490, 20));

        jtf7.setBorder(null);
        jPanel1.add(jtf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 610, 480, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Group 7_1.png"))); // NOI18N
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 675, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_inventory_direktorat/img/Web 1280 – 1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf2ActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateDetailKasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDetailKasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDetailKasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDetailKasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdateDetailKasus dialog = new UpdateDetailKasus(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JTextField jtf3;
    private javax.swing.JTextField jtf4;
    private javax.swing.JTextField jtf5;
    private javax.swing.JTextField jtf6;
    private javax.swing.JTextField jtf7;
    // End of variables declaration//GEN-END:variables
}
