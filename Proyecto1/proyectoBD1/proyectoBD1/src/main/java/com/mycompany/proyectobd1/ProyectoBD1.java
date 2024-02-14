/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.proyectobd1;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import formularios.LoginForm;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.CuentaDAO;
import persistencia.Interfaces.IClienteDAO;
import persistencia.Interfaces.IConexionBD;
import persistencia.Interfaces.ICuentaDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class ProyectoBD1 {

    public static void main(String[] args) {
        
        IConexionBD c = new ConexionBD();
        try {
            c.obtenerConexion();
            IClienteDAO b= new ClienteDAO(c);
            Date fechaActual=new Date();
            ClienteEntidad cliente=new ClienteEntidad( "Luis", "Sunshine", "lola", "Burgueno", "Escalante", fechaActual, "calle 14");
           // b.agregar(cliente);
           b.iniciarSesion("Sunshine", "lola");
           b.editar(cliente);
            
            //ICuentaDAO a = new CuentaDAO(c);
            //a.transferencia(new CuentaDTO(1, "1234567890"), new CuentaDTO(2, "0987654321"), 100.0);
            //a.generarRetiroSinCuenta(new CuentaDTO(1, "1234567890"), 200.00);
            //a.disponerDineroRetiro("10506", "15904");
            

        }catch (PersistenciaException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ProyectoBD1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoBD1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
