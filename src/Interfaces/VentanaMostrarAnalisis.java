/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.Lista;
import Clases.ListaInt;
import Clases.Resumen;
import java.text.Normalizer;

/**
 *
 * @author verol
 */
public class VentanaMostrarAnalisis extends javax.swing.JFrame {

    /**
     * Creates new form VentanaMostrarAnalisis
     */
    public static Resumen resumen;
    public VentanaMostrarAnalisis(Resumen res) {
        initComponents();
        this.mostrarAnalisis.setText("");
        this.setLocationRelativeTo(this);
        this.resumen=res;
        this.getContador();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        mostrarAnalisis = new javax.swing.JTextArea();
        atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mostrarAnalisis.setEditable(false);
        mostrarAnalisis.setBackground(new java.awt.Color(255, 255, 255));
        mostrarAnalisis.setColumns(20);
        mostrarAnalisis.setFont(new java.awt.Font("Eras Light ITC", 0, 12)); // NOI18N
        mostrarAnalisis.setRows(5);
        jScrollPane1.setViewportView(mostrarAnalisis);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 280, 210));

        atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boton atras.png"))); // NOI18N
        atras.setBorder(null);
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        jPanel1.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_atrasActionPerformed

    
    public static ListaInt contarPalabrasClave(String text, Lista palabrasClave) {
        ListaInt cuentasPalabraClave = new ListaInt();
        String textoNorm = normalize(text);
        for(int i=0; i<palabrasClave.getiN(); i++){
            String palabraClaveNorm = normalize(palabrasClave.getPosicion(i).getInfo());
            int cuenta = contarOcurrencias(textoNorm, palabraClaveNorm);
            cuentasPalabraClave.preinsertarPrimero(cuenta);  
        }

        return cuentasPalabraClave;
    }

    private static String normalize(String input) {
        //eliminar acentos y convertir a minúsculas
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        normalized = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        return normalized.toLowerCase();
    }

    private static int contarOcurrencias(String text, String keyword) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(keyword, index)) != -1) {
            count++;
            index += keyword.length();
        }
        return count;
    }
    
    public void getContador(){
        String text = this.resumen.getCuerpo();
        Lista keywords = this.resumen.getPalabrasClave();

        ListaInt result = contarPalabrasClave(text, keywords);
        String analisis= this.resumen.getTitulo() +"\n\n"+this.resumen.getAutores().recorrer()+"\n\n"+"Palabras clave y su frecuencia: \n";

        for (int i = 0; i < keywords.getiN(); i++) {
            analisis+=keywords.getPosicion(keywords.getiN()-1-i).getInfo() + ": " + result.getPosicion(i).getInfo()+"\n";
        }
        
        mostrarAnalisis.setText(analisis);
        mostrarAnalisis.setLineWrap(true);
        mostrarAnalisis.setWrapStyleWord(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaMostrarAnalisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAnalisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAnalisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMostrarAnalisis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMostrarAnalisis(resumen).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mostrarAnalisis;
    // End of variables declaration//GEN-END:variables
}
