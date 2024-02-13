/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import dto.CuentaDTO;
import entidades.ClienteEntidad;
import entidades.CuentaEntidad;
import java.math.BigDecimal;
import java.sql.SQLException;
import persistencia.PersistenciaException;

/**
 *
 * @author Usuario
 */
public interface ICuentaDAO {

    public void agregar(CuentaEntidad cuenta, ClienteEntidad cliente) throws PersistenciaException;

    public void cancelarCuenta(CuentaEntidad cliente) throws PersistenciaException;

    public void transferencia(CuentaDTO cuenta1, CuentaDTO cuenta2, double monto) throws PersistenciaException;

    public BigDecimal consultarSaldo(CuentaDTO cuenta) throws PersistenciaException;
    
    public void retiroSinCuenta(CuentaEntidad cuenta1, double monto) throws PersistenciaException;
}
