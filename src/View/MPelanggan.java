/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Controller_Pelanggan;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class MPelanggan extends javax.swing.JFrame {
    
    Controller_Pelanggan controller;
    
    
    
   
    public JTable getTblplg() {
        return tblplg;
    }

    public JTextArea getTxtalamat() {
        return txtalamat;
    }

    public JTextField getTxtkdplg() {
        return txtkdplg;
    }

    public JTextField getTxtnmplg() {
        return txtnmplg;
    }
    public JTextField getTxttelp() {
        return txttelp;
    }
    
    


    /**
     * Creates new form MPelanggan
     */
    public MPelanggan() {
        initComponents();
        setLocationRelativeTo(this);
        controller = new Controller_Pelanggan(this);
        controller.reset();
        controller.tampilurutankode();
         this.txtnmplg.requestFocus();
        this.setSize(1000,600);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtkdplg = new javax.swing.JTextField();
        txttelp = new javax.swing.JTextField();
        txtnmplg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblplg = new javax.swing.JTable();
        cmdsimpan = new javax.swing.JButton();
        cmdubah = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();
        cmdbatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ENTRY DATA PELANGGAN");

        jLabel2.setText("Kode Pelangan      :");

        jLabel3.setText("Nama Pelanggan  :");

        jLabel4.setText("Alamat                   :");

        jLabel5.setText("Telepon                 :");

        txtkdplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdplgActionPerformed(evt);
            }
        });
        txtkdplg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtkdplgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkdplgKeyReleased(evt);
            }
        });

        txttelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelpActionPerformed(evt);
            }
        });

        txtnmplg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmplgActionPerformed(evt);
            }
        });

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        tblplg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pelanggan", "Nama Pelanggan", "Alamat", "No. Telp"
            }
        ));
        tblplg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblplgMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblplg);

        cmdsimpan.setText("Simpan");
        cmdsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpanActionPerformed(evt);
            }
        });

        cmdubah.setText("Ubah");
        cmdubah.setMaximumSize(new java.awt.Dimension(72, 30));
        cmdubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubahActionPerformed(evt);
            }
        });

        cmdhapus.setText("Hapus");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });

        cmdbatal.setText("batal");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(txtnmplg)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txttelp))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(txtkdplg, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdsimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmdhapus, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(cmdbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cmdubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtkdplg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmdsimpan))
                    .addComponent(txtnmplg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmdubah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmdhapus)
                        .addGap(16, 16, 16)
                        .addComponent(cmdbatal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1014, 656));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtkdplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdplgActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtkdplgActionPerformed

    private void txttelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelpActionPerformed

    private void txtnmplgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmplgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmplgActionPerformed

    private void cmdsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpanActionPerformed
        // TODO add your handling code here:
        controller.insert();
        controller.reset();
        controller.tampilurutankode();
    }//GEN-LAST:event_cmdsimpanActionPerformed

    private void cmdubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubahActionPerformed
        // TODO add your handling code here:
         controller.update();
        controller.reset();
        controller.tampilurutankode();
    }//GEN-LAST:event_cmdubahActionPerformed

    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        // TODO add your handling code here:
         controller.delete();
        controller.reset();
        controller.tampilurutankode();
    }//GEN-LAST:event_cmdhapusActionPerformed

    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
controller.reset();    
controller.tampilurutankode();
// TODO add your handling code here:
    }//GEN-LAST:event_cmdbatalActionPerformed

    private void txtkdplgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdplgKeyReleased
        // TODO add your handling code here:
       controller.isiTableCari();
    }//GEN-LAST:event_txtkdplgKeyReleased

    private void txtkdplgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkdplgKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txtkdplg.getText().isEmpty()){
                controller.tampilurutankode();
                controller.reset();
            }else{
                controller.isiTable();
                controller.tampilurutankode();
                this.txtnmplg.requestFocus();
            }
        }
    }//GEN-LAST:event_txtkdplgKeyPressed

    private void tblplgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblplgMouseClicked
        // TODO add your handling code here:
        controller.isiField(tblplg.getSelectedRow());
        this.txtnmplg.requestFocus();
    }//GEN-LAST:event_tblplgMouseClicked

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
            java.util.logging.Logger.getLogger(MPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JButton cmdubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblplg;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtkdplg;
    private javax.swing.JTextField txtnmplg;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables

    
}