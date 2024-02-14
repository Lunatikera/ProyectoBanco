/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import persistencia.Interfaces.ICuentaDAO;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public class CuentaNegocio implements ICuentaNegocio {

private ICuentaDAO cuentaDAO;

    public CuentaNegocio(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    @Override
    public void agregarCuenta(CuentaEntidad cuenta, ClienteEntidad cliente) throws NegocioException {
        try {
            cuentaDAO.agregar(cuenta, cliente);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al agregar la cuenta", e);
        }
    }

    @Override
    public void cancelarCuenta(CuentaEntidad cuenta) throws NegocioException {
        try {
            cuentaDAO.cancelarCuenta(cuenta);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al cancelar la cuenta", e);
        }
    }

    @Override
    public void realizarTransferencia(CuentaDTO cuentaOrigen, CuentaDTO cuentaDestino, double monto) throws NegocioException {
        try {
            cuentaDAO.transferencia(cuentaOrigen, cuentaDestino, monto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al realizar la transferencia", e);
        }
    }

    @Override
    public void generarRetiroSinCuenta(CuentaDTO cuentaOrigen, double monto) throws NegocioException {
        try {
            cuentaDAO.generarRetiroSinCuenta(cuentaOrigen, monto);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al generar el retiro sin cuenta", e);
        }
    }

    @Override
    public void disponerDineroRetiro(String folio, String contraseña) throws NegocioException {
        try {
            cuentaDAO.disponerDineroRetiro(folio, contraseña);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al disponer dinero del retiro sin cuenta", e);
        }
    }
}
