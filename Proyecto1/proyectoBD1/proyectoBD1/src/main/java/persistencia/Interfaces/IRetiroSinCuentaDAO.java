/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import entidades.RetiroSinCuentaEntidad;

/**
 *
 * @author Usuario
 */
public interface IRetiroSinCuentaDAO {
    public RetiroSinCuentaEntidad registrar(RetiroSinCuentaEntidad retiro);
    public RetiroSinCuentaEntidad cobrarRetiro(RetiroSinCuentaEntidad retiro);
}
