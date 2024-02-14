/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public interface IClienteNegocio {

    public void agregarCliente(ClienteEntidad cliente) throws NegocioException;

    public void actualizarCliente(ClienteEntidad cliente) throws NegocioException;

    public ClienteEntidad iniciarSesion(String nombreUsuario, String contraseña) throws NegocioException;

  
}
