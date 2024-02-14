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
import negocio.ClienteNegocio;
import negocio.IClienteNegocio;
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
        IConexionBD conexionBD = new ConexionBD();
        IClienteDAO clienteDAO = new ClienteDAO(conexionBD);
        IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);

        LoginForm login = new LoginForm(clienteNegocio);
        login.show();

    }
}
