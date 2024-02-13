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
public class TransaccionEntidad {
    private int idTransaccion;
    private BigDecimal monto;
    private Date fechaRealizacion;
    private String folio;
    private int idCuentaOrigen;

    // Constructor
    public TransaccionEntidad(int idTransaccion, BigDecimal monto, Date fechaRealizacion, String folio, int idCuentaOrigen) {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fechaRealizacion = fechaRealizacion;
        this.folio = folio;
        this.idCuentaOrigen = idCuentaOrigen;
    }

    // Getters and Setters
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

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
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
