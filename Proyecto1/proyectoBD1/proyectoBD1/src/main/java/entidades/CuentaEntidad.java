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
public class CuentaEntidad {

    private int idCuenta;
    private String numeroCuenta;
    private BigDecimal saldo;
    private String estado;
    private Date fechaApertura;
    private String nip;
    private int idCliente;
    // Constructor
    public CuentaEntidad(int idCuenta, String numeroCuenta, BigDecimal saldo, String estado,
                  Date fechaApertura, String nip, int idCliente) {
        this.idCuenta = idCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.fechaApertura = fechaApertura;
        this.nip = nip;
        this.idCliente = idCliente;
    }
    
    public CuentaEntidad(){
        
    }

    public CuentaEntidad(int idCliente,BigDecimal saldo, String nip) {
        this.idCliente=idCliente;
        this.saldo = saldo;
        this.nip = nip;
    }
    
    

    // Getters and Setters
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}