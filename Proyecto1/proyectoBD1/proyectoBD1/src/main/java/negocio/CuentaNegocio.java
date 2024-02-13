/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class CuentaNegocio implements ICuentaNegocio {

    @Override
    public void agregar(CuentaEntidad cuenta, ClienteEntidad cliente) throws NegocioException {
    }

    @Override
    public void cancelarCuenta(CuentaEntidad cliente) throws NegocioException {
    }

    @Override
    public void transaccion(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws NegocioException {
         if (cuenta2 == null) {
            throw new PersistenciaException("No se pudo encontrar la cuenta");
        }
    }
    
}
