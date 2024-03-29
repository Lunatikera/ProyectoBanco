/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formularios;

import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.ICuentaNegocio;
import negocio.NegocioException;

/**
 *
 * @author Usuario
 */
public class CreacionCuentaForm extends javax.swing.JFrame {

    private ICuentaNegocio cuentaNegocio;
    private ClienteEntidad clienteActual;

    /**
     * Creates new form CreacionCuentaForm
     */
    public CreacionCuentaForm(ICuentaNegocio cuentaNegocio, ClienteEntidad clienteActual) {
        this.cuentaNegocio = cuentaNegocio;
        this.clienteActual = clienteActual;
        initComponents();
        this.setLocationRelativeTo(this);

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
        saldojText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        RegistrarseButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        RegistrarContraseñajText = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        confirmarContraseñajText1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(87, 87, 86));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        saldojText.setBackground(new java.awt.Color(224, 224, 224));
        saldojText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        saldojText.setForeground(new java.awt.Color(0, 0, 0));
        saldojText.setText("00.00");
        jPanel1.add(saldojText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 150, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 224, 224));
        jLabel1.setText("Crear Cuenta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 200, 100));

        RegistrarseButton.setBackground(new java.awt.Color(108, 142, 132));
        RegistrarseButton.setForeground(new java.awt.Color(224, 224, 224));
        RegistrarseButton.setText("Registrarse");
        RegistrarseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RegistrarseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 150, 30));

        jPanel3.setBackground(new java.awt.Color(108, 142, 132));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        RegistrarContraseñajText.setBackground(new java.awt.Color(224, 224, 224));
        RegistrarContraseñajText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        RegistrarContraseñajText.setText("Contraseña");
        jPanel1.add(RegistrarContraseñajText, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, 30));

        jPanel2.setBackground(new java.awt.Color(108, 142, 132));
        jPanel2.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 450));

        confirmarContraseñajText1.setBackground(new java.awt.Color(224, 224, 224));
        confirmarContraseñajText1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        confirmarContraseñajText1.setText("Contraseña");
        jPanel1.add(confirmarContraseñajText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Saldo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("PIN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Confirmar PIN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void registrarCuenta(CuentaEntidad cuenta, ClienteEntidad cliente) throws PresentacionException {
        try {
            this.cuentaNegocio.agregarCuenta(cuenta, clienteActual);

            JOptionPane.showMessageDialog(null, "Enhorabuena, " + cliente.getNombre()+"su nuevo numero de cuenta es: "+ cuenta.getNumeroCuenta(), "Se ha registrado con exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error de registro", JOptionPane.ERROR_MESSAGE);

        }
    }
    private void RegistrarseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseButtonActionPerformed
        String pin = new String(RegistrarContraseñajText.getPassword());
        String pin2 = new String(confirmarContraseñajText1.getPassword());
        String saldoString = saldojText.getText();
        BigDecimal saldo = new BigDecimal(saldoString);

        CuentaEntidad cuenta = new CuentaEntidad(clienteActual.getIdCliente(), saldo, pin);
            
        try {
            registrarCuenta(cuenta, clienteActual);
        } catch (PresentacionException ex) {
            Logger.getLogger(CreacionCuentaForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_RegistrarseButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField RegistrarContraseñajText;
    private javax.swing.JButton RegistrarseButton;
    private javax.swing.JPasswordField confirmarContraseñajText1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField saldojText;
    // End of variables declaration//GEN-END:variables
}
