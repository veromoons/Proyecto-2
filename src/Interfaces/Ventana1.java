/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Resumen;
import Info.LeerTxt;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author berna
 */
public class Ventana1 extends javax.swing.JFrame {

    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
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
        cargarResumen = new javax.swing.JButton();
        usarResumenesCargados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cargarResumen.setText("Cargar resumen");
        cargarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarResumenActionPerformed(evt);
            }
        });
        jPanel1.add(cargarResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, -1, -1));

        usarResumenesCargados.setText("Usar resumenes precargados");
        usarResumenesCargados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usarResumenesCargadosActionPerformed(evt);
            }
        });
        jPanel1.add(usarResumenesCargados, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarResumenActionPerformed
        // TODO add your handling code here:
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        File abre =file.getSelectedFile();
        LeerTxt txt = new LeerTxt();
        try {
<<<<<<< HEAD
            txt.cargarResumen(abre);
=======
            if (txt.cargarInfo(abre)){
            txt.cargarResumentxt(txt.getResumen());}
>>>>>>> sofia
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo guardar la informacion. Intente de nuevo");
        }
    }//GEN-LAST:event_cargarResumenActionPerformed

    private void usarResumenesCargadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usarResumenesCargadosActionPerformed
        // TODO add your handling code here:
        LeerTxt txt = new LeerTxt();
        try {
            File archivo = new File("resumenes.txt");
            //txt.leerResumenes(archivo);
            if (!txt.leerResumenesTxt(archivo)) {
               JOptionPane.showMessageDialog(this, "No hay resumenes precargados");
            }
             } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No hay resumenes precargados");
        }
    }//GEN-LAST:event_usarResumenesCargadosActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargarResumen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton usarResumenesCargados;
    // End of variables declaration//GEN-END:variables
}
