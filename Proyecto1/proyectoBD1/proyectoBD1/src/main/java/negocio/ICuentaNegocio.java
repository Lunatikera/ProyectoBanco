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

    public void agregarCuenta(CuentaEntidad cuenta, ClienteEntidad cliente) throws NegocioException;

    public void cancelarCuenta(CuentaEntidad cuenta) throws NegocioException;

    public void realizarTransferencia(CuentaDTO cuentaOrigen, CuentaDTO cuentaDestino, double monto) throws NegocioException;

    public void generarRetiroSinCuenta(CuentaDTO cuentaOrigen, double monto) throws NegocioException;

    public void disponerDineroRetiro(String folio, String contraseña) throws NegocioException;
}
