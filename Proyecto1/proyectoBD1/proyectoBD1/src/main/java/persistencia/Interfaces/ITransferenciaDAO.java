/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia.Interfaces;

import entidades.TransferenciaEntidad;

/**
 *
 * @author Usuario
 */
public interface ITransferenciaDAO {

    public TransferenciaEntidad registrar(TransferenciaEntidad retiro);

    public TransferenciaEntidad cobrarRetiro(TransferenciaEntidad retiro);
}
