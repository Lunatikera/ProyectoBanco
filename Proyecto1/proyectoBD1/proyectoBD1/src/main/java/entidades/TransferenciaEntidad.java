/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class TransferenciaEntidad extends TransaccionEntidad {

    private int idCuentaDestino;

    public TransferenciaEntidad(int idTransaccion, int idCuentaDestino, int idTransferencia, BigDecimal monto, Date fechaRealizacion, String folio, int idCuentaOrigen) {
        super(idTransaccion, monto, fechaRealizacion, folio, idCuentaOrigen);
        this.idCuentaDestino = idCuentaDestino;
    }

    public int getIdCuentaDestino() {
        return idCuentaDestino;
    }

    public void setIdCuentaDestino(int idCuentaDestino) {
        this.idCuentaDestino = idCuentaDestino;
    } 

}
