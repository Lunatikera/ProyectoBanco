/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import entidades.ClienteEntidad;
import java.sql.SQLException;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public interface IClienteDAO {

    public void agregar(ClienteEntidad cliente) throws PersistenciaException;

    public void editar(ClienteEntidad cliente) throws PersistenciaException;

    public ClienteEntidad iniciarSesion(String nombreUsuario, String contraseña) throws PersistenciaException;
}
