/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import entidades.ClienteEntidad;
import java.sql.SQLException;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;

/**
 *
 * @author Usuario
 */
public class CreacionCuentaInfoForm extends javax.swing.JFrame {

    /**
     * Creates new form CreacionCuentaInfoForm
     */
    public CreacionCuentaInfoForm() {
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

        RegistrarApellidoMajText1 = new javax.swing.JTextField();
        jSpinner4 = new javax.swing.JSpinner();

        RegistrarApellidoMajText1.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarApellidoMajText1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarApellidoMajText1.setForeground(new java.awt.Color(196, 196, 196));
        RegistrarApellidoMajText1.setText("Segundo Apellido");
        RegistrarApellidoMajText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarApellidoMajText1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarApellidoMajText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarApellidoMajText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarApellidoMajText1ActionPerformed
/**/
/**/
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField RegistrarApellidoMajText1;
    private javax.swing.JSpinner jSpinner4;
    // End of variables declaration//GEN-END:variables
}
