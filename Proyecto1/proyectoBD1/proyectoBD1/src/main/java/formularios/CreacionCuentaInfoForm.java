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
        jPanel1 = new javax.swing.JPanel();
        FondoV = new javax.swing.JPanel();
        RegistrarNombrejText1 = new javax.swing.JTextField();
        FechaNtext = new javax.swing.JTextField();
        RegistrarApellidoPajText1 = new javax.swing.JTextField();
        RegistrarApellidoMajText2 = new javax.swing.JTextField();
        FondorResgistrate = new javax.swing.JLabel();
        SiguienteButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        RegistrarDomiciliojText1 = new javax.swing.JTextField();
        NombreUsuariojText = new javax.swing.JTextField();
        RegistrarContraseñajText = new javax.swing.JPasswordField();
        ConfirmarContraseñajText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(87, 87, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FondoV.setBackground(new java.awt.Color(108, 142, 132));
        FondoV.setAutoscrolls(true);

        javax.swing.GroupLayout FondoVLayout = new javax.swing.GroupLayout(FondoV);
        FondoV.setLayout(FondoVLayout);
        FondoVLayout.setHorizontalGroup(
            FondoVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        FondoVLayout.setVerticalGroup(
            FondoVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(FondoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 500));

        RegistrarNombrejText1.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarNombrejText1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarNombrejText1.setForeground(new java.awt.Color(196, 196, 196));
        RegistrarNombrejText1.setText("Nombre");
        RegistrarNombrejText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarNombrejText1MouseClicked(evt);
            }
        });
        RegistrarNombrejText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarNombrejText1ActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarNombrejText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, 30));

        FechaNtext.setBackground(new java.awt.Color(224, 224, 224));
        FechaNtext.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        FechaNtext.setForeground(new java.awt.Color(196, 196, 196));
        FechaNtext.setText("AAAA-MM-DD");
        FechaNtext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FechaNtextMouseClicked(evt);
            }
        });
        FechaNtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaNtextActionPerformed(evt);
            }
        });
        jPanel1.add(FechaNtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 150, 30));

        RegistrarApellidoPajText1.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarApellidoPajText1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarApellidoPajText1.setForeground(new java.awt.Color(196, 196, 196));
        RegistrarApellidoPajText1.setText("Primer Apellido");
        RegistrarApellidoPajText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarApellidoPajText1MouseClicked(evt);
            }
        });
        RegistrarApellidoPajText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarApellidoPajText1ActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarApellidoPajText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 150, 30));

        RegistrarApellidoMajText2.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarApellidoMajText2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarApellidoMajText2.setForeground(new java.awt.Color(196, 196, 196));
        RegistrarApellidoMajText2.setText("Segundo Apellido");
        RegistrarApellidoMajText2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarApellidoMajText2MouseClicked(evt);
            }
        });
        RegistrarApellidoMajText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarApellidoMajText2ActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarApellidoMajText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 150, 30));

        FondorResgistrate.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        FondorResgistrate.setForeground(new java.awt.Color(224, 224, 224));
        FondorResgistrate.setText("Registrate");
        jPanel1.add(FondorResgistrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, 100));

        SiguienteButton1.setBackground(new java.awt.Color(108, 142, 132));
        SiguienteButton1.setText("Siguiente");
        SiguienteButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(SiguienteButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 100, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Confirmar Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        RegistrarDomiciliojText1.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarDomiciliojText1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarDomiciliojText1.setForeground(new java.awt.Color(196, 196, 196));
        RegistrarDomiciliojText1.setText("Domicilio");
        RegistrarDomiciliojText1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegistrarDomiciliojText1MouseClicked(evt);
            }
        });
        RegistrarDomiciliojText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarDomiciliojText1ActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarDomiciliojText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 150, 30));

        NombreUsuariojText.setBackground(new java.awt.Color(224, 224, 224));
        NombreUsuariojText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        NombreUsuariojText.setForeground(new java.awt.Color(196, 196, 196));
        NombreUsuariojText.setText("Nombre Usuario");
        NombreUsuariojText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreUsuariojTextMouseClicked(evt);
            }
        });
        NombreUsuariojText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreUsuariojTextActionPerformed(evt);
            }
        });
        jPanel1.add(NombreUsuariojText, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 150, 30));

        RegistrarContraseñajText.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarContraseñajText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarContraseñajText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarContraseñajTextActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarContraseñajText, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 150, 30));

        ConfirmarContraseñajText.setBackground(new java.awt.Color(224, 224, 224));
        ConfirmarContraseñajText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ConfirmarContraseñajText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarContraseñajTextActionPerformed(evt);
            }
        });
        jPanel1.add(ConfirmarContraseñajText, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FechaNtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaNtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FechaNtextActionPerformed

    private void RegistrarNombrejText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarNombrejText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarNombrejText1ActionPerformed

    private void RegistrarApellidoPajText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarApellidoPajText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarApellidoPajText1ActionPerformed

    private void RegistrarApellidoMajText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarApellidoMajText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarApellidoMajText1ActionPerformed

    private void RegistrarApellidoMajText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarApellidoMajText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarApellidoMajText2ActionPerformed

    private void SiguienteButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteButton1ActionPerformed
        // TODO add your handling code here:
                                              
    // Cadenas que reciben texto de los campos de texto
    String Nombre = RegistrarNombrejText1.getText();
    String NombreU = RegistrarNombrejText1.getText();
    String ApellidoP = RegistrarApellidoPajText1.getText();
    String ApellidoM = RegistrarApellidoMajText2.getText();
    String Domicilio = RegistrarDomiciliojText1.getText();
    String Fecha = FechaNtext.getText();
    String Contraseña = new String(RegistrarContraseñajText.getPassword()); // Obtener la contraseña del campo de texto de contraseña
     String ConfirmaContraseña = new String(ConfirmarContraseñajText.getPassword()); // Obtener la contraseña del campo de texto de  confirmar contraseña
     
    // VALIDACIONES DENTRO DEL METODO AGREGAR
     //Validar que los campos no estén vacíos
    if (Nombre.isEmpty() || ApellidoP.isEmpty() || ApellidoM.isEmpty() || Fecha.isEmpty() || Contraseña.isEmpty()|| Domicilio.isEmpty()|| NombreU.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);}
         // Confirmar Contraseña 
    if(! Contraseña.equals(ConfirmaContraseña)){
         javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);}
// Validar formato de fecha
if (!Fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
    javax.swing.JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use AAAA-MM-DD", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
} else {
    // Conectar a la base de datos y realizar la inserción
    ClienteEntidad Cliente = new ClienteEntidad(Nombre, NombreU, Contraseña, ApellidoP, ApellidoM, Domicilio);
    Cliente.setFechaNacimiento(java.sql.Date.valueOf(Fecha)); // Convertir la cadena de fecha a un objeto Date
    ConexionBD conexionBD = new ConexionBD();
    ClienteDAO CD = new ClienteDAO();
     
    try {conexionBD.obtenerConexion(); CD.agregar(Cliente);
        // Mostrar mensaje de éxito o realizar acciones adicionales en la interfaz gráfica si es necesario
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente insertado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        // Cerrar el JFrame actual
    } catch (SQLException ex) {
        ex.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al insertar el cliente", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }}
  this.dispose();
    }//GEN-LAST:event_SiguienteButton1ActionPerformed

    private void RegistrarDomiciliojText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarDomiciliojText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarDomiciliojText1ActionPerformed

    private void NombreUsuariojTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreUsuariojTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreUsuariojTextActionPerformed

    private void RegistrarContraseñajTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarContraseñajTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarContraseñajTextActionPerformed

    private void ConfirmarContraseñajTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarContraseñajTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmarContraseñajTextActionPerformed

    private void RegistrarNombrejText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarNombrejText1MouseClicked
    RegistrarNombrejText1.setText("");
    }//GEN-LAST:event_RegistrarNombrejText1MouseClicked

    private void RegistrarApellidoPajText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarApellidoPajText1MouseClicked
        RegistrarApellidoPajText1.setText("");
    }//GEN-LAST:event_RegistrarApellidoPajText1MouseClicked

    private void FechaNtextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FechaNtextMouseClicked
        FechaNtext.setText("");
    }//GEN-LAST:event_FechaNtextMouseClicked

    private void RegistrarApellidoMajText2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarApellidoMajText2MouseClicked
                RegistrarApellidoMajText2.setText("");
    }//GEN-LAST:event_RegistrarApellidoMajText2MouseClicked

    private void RegistrarDomiciliojText1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarDomiciliojText1MouseClicked
        RegistrarDomiciliojText1.setText("");
    }//GEN-LAST:event_RegistrarDomiciliojText1MouseClicked

    private void NombreUsuariojTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreUsuariojTextMouseClicked
       NombreUsuariojText.setText("");
    }//GEN-LAST:event_NombreUsuariojTextMouseClicked

    
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
            java.util.logging.Logger.getLogger(CreacionCuentaInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreacionCuentaInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreacionCuentaInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreacionCuentaInfoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreacionCuentaInfoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmarContraseñajText;
    private javax.swing.JTextField FechaNtext;
    private javax.swing.JPanel FondoV;
    private javax.swing.JLabel FondorResgistrate;
    private javax.swing.JTextField NombreUsuariojText;
    private javax.swing.JTextField RegistrarApellidoMajText1;
    private javax.swing.JTextField RegistrarApellidoMajText2;
    private javax.swing.JTextField RegistrarApellidoPajText1;
    private javax.swing.JPasswordField RegistrarContraseñajText;
    private javax.swing.JTextField RegistrarDomiciliojText1;
    private javax.swing.JTextField RegistrarNombrejText1;
    private javax.swing.JButton SiguienteButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpinner4;
    // End of variables declaration//GEN-END:variables
}
