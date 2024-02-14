/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Usuario
 */
public class CuentaDTO {

    private int idCliente;
    private String numeroCuenta;

    public CuentaDTO(int idCliente, String numCuenta) {
        this.idCliente = idCliente;
        this.numeroCuenta = numCuenta;
    }

    public CuentaDTO() {

    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numCuenta) {
        this.numeroCuenta = numCuenta;
    }

    @Override
    public String toString() {
        return numeroCuenta;
    }

}
