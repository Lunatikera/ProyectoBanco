/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.math.BigDecimal;

/**
 *
 * @author Usuario
 */
public class TransaccionDTO {

    private int idTransaccion;
    private BigDecimal monto;
    private String folio;
    private int idCuentaOrigen;

    public TransaccionDTO(int idTransaccion, BigDecimal monto, String folio, int idCuentaOrigen) {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.folio = folio;
        this.idCuentaOrigen = idCuentaOrigen;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getIdCuentaOrigen() {
        return idCuentaOrigen;
    }

    public void setIdCuentaOrigen(int idCuentaOrigen) {
        this.idCuentaOrigen = idCuentaOrigen;
    }

}