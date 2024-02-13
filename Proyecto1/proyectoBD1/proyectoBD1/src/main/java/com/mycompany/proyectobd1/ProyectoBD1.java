/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectobd1;

import dto.CuentaDTO;
import formularios.LoginForm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.ClienteDAO;
import persistencia.ConexionBD;
import persistencia.CuentaDAO;
import persistencia.Interfaces.IClienteDAO;
import persistencia.Interfaces.IConexionBD;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class ProyectoBD1 {

    public static void main(String[] args){
IConexionBD c = new ConexionBD();
        try {
            c.obtenerConexion();
CuentaDAO a = new CuentaDAO();
 a.transaccion(new CuentaDTO(1, "1234567890"), new CuentaDTO(2, "0987654321"), 1000.0);
        } catch (SQLException ex) {
            Logger.getLogger(ProyectoBD1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ProyectoBD1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}