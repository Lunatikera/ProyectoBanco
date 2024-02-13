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
public interface ICuentaNegocio {
      public void agregar(CuentaEntidad cuenta, ClienteEntidad cliente) throws PersistenciaException;

    public void cancelarCuenta(CuentaEntidad cliente) throws PersistenciaException;

    public void transaccion(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws PersistenciaException;

}
